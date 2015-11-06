package org.janzhou.native

import com.sun.jna._
import scala.reflect.ClassTag

import org.janzhou.native._

class Pmemory ( _file:String = null, _fd:Int = 0, _pmemaddr:Pointer = null ) {
  require ( ( _file != null || _fd > 0 || _pmemaddr != null ),  "Please give valid parameters!" )

  private var fd = _fd

  if( _file != null ) {
    fd = libc.run().open(_file, libc.O_CREAT | libc.O_RDWR);
    require ( ( fd > 0 ),  "Error open file: " + _file )
  }

  val size = libc.run().lseek(fd, 0L, libc.SEEK_END)
  require ( size > 0,  "File too small." )

  private var pmemaddr = _pmemaddr
  if( fd > 0 ) {
    pmemaddr = libpmem.run().pmem_map(fd)
    require ( ( pmemaddr != Pointer.NULL ), "Error open pmem_map." )
  }

  private var pmemaddrNative = Pointer.nativeValue( pmemaddr )

  def store[T]( offset:Long, v: T):Long = v match {
    case _:Int => {
      pmemaddr.setInt(offset, v.asInstanceOf[Int])
      4L
    }
    case _:Long => {
      pmemaddr.setLong(offset, v.asInstanceOf[Long])
      8L
    }
    case _:String => {
      pmemaddr.setString(offset, v.asInstanceOf[String])
      (v.asInstanceOf[String].length + 1).asInstanceOf[Long]
    }
  }

  private val string = implicitly[ClassTag[String]]
  def load[T:ClassTag](offset:Long):T = implicitly[ClassTag[T]] match {
    case ClassTag.Int => pmemaddr.getInt(offset).asInstanceOf[T]
    case ClassTag.Long => pmemaddr.getLong(offset).asInstanceOf[T]
    case `string` => pmemaddr.getString(offset).asInstanceOf[T]
  }

  def flush = {
    libpmem.run().pmem_flush(pmemaddr, size)
  }

  override def finalize:Unit = {
    libpmem.run().pmem_flush(pmemaddr, size)
    libpmem.run().pmem_drain()
    libpmem.run().pmem_unmap(pmemaddr, size)
    libc.run().close(fd)
  }
}

object pmem {
  def main (args: Array[String]) {
    val pmemory = new Pmemory("/tmp/pmem")
    pmemory.store(0, "Hello Wrold!")
    println(pmemory.load[String](0))
  }
}
