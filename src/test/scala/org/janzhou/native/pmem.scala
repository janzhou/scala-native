package org.janzhou.native

import com.sun.jna._
import org.janzhou.native._

object pmem {
  def main (args: Array[String]) {
    val pmemory = new Pmem("/tmp/pmem")
    pmemory.setString(0, "Hello Wrold!")
    println(pmemory.getString(0))
  }
}
