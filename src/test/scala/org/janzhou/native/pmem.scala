package org.janzhou.native

import com.sun.jna._
import org.janzhou.native._

object pmem {
  def main (args: Array[String]) {
    val pmemory = new Pmemory("/tmp/pmem")
    pmemory.store(0, "Hello Wrold!")
    println(pmemory.load[String](0))
  }
}
