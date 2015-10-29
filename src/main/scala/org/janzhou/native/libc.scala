package org.janzhou.native

import com.sun.jna._

trait libc extends Library {
  def open(path:String, flag:Int):Int
  def ioctl(fd:Int, request:Int, args:Array[_]):Int
  def close(fd:Int):Unit
}

object libc {
  private var _libc:libc = null
  def run():libc = {
    if ( _libc == null ) {
      _libc = Native.loadLibrary("c", classOf[libc]).asInstanceOf[libc]
    }
    _libc
  }

  val O_ACCMODE    =   3
  val O_RDONLY     =   0
  val O_WRONLY     =   1
  val O_RDWR       =   2
  val O_CREAT      = 100
  val IOCTL_TRIM   = 0x1277
}