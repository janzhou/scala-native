package org.janzhou.native

import com.sun.jna._
import org.janzhou.native._
import scala.reflect._

class Plog( _file:String, _init:Boolean = false ) {
  private val pmemory = new Pmemory(_file)
  private var offset = 0L

  def store[T](v: T):Long = {
    val ret = offset
    offset += pmemory.store(offset, v)
    ret
  }

  def load[T:ClassTag](_offset:Long):T = pmemory.load[T](_offset).asInstanceOf[T]

  def flush = pmemory.flush

  if(_init) {
    offset += pmemory.store(0L, 8L)
  } else {
    offset = load[Long](0)
  }

  override def finalize:Unit = {
    pmemory.store(0L, offset)
  }
}

object plog {
  def main (args: Array[String]) {
    var plog = new Plog("/tmp/pmem", true)
    val list = List("Hello", "world!")
    val size = list.map(v => v.length)

    val plist = list.map(v => plog.store(v))
    val psize = size.map(v => plog.store(v))

    plog = null
    System.gc()
    System.runFinalization()
    Thread.sleep(1000);                 //1000 milliseconds is one second.

    plog = new Plog("/tmp/pmem")

    plist.map(v => plog.load[String](v)).map(println)
    psize.map(v => plog.load[Int](v)).map(println)
  }
}
