package org.janzhou.native

import com.sun.jna._
import org.janzhou.native._
import scala.reflect._

object trim {
  def trim(file:String, offset:Long, length:Long):Unit = { // length = N * page size
    val fd = libc.run().open(file, 1)
    val range = Array(offset, length)
    if ( fd != 0 ) {
      libc.run().ioctl(fd, libc.IOCTL_TRIM, range)
    }
    libc.run().close(fd)
  }

  def main (args: Array[String]) {
    trim(args(0), args(1).toLong, args(2).toLong)
  }
}
