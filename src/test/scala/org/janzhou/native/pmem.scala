package org.janzhou.native

import org.janzhou.native._

object pmem {
  def main (args: Array[String]) {
    val fd = libc.run().open("/tmp/pmem", libc.O_CREAT | libc.O_RDWR);

    if(fd < 0) {
      println("Error open /tmp/pmem")
      return
    }

    val pmemaddr = libpmem.run().pmem_map(fd)

    if(pmemaddr == 0) {
      println("Error open pmem_map. File should be larger than 2MB.")
    }

    libc.run().close(fd)
  }
}
