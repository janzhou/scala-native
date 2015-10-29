package org.janzhou.native

import com.sun.jna._

trait libpmem extends Library {
  def pmem_map(fd:Int):Int
  def pmem_unmap(fd:Int, pmem_len:Int):Int
  def pmem_is_pmem(pmemaddr:Int, pmem_len:Int):Int
  def pmem_persist(addr:Int, len:Int):Unit
  def pmem_msync(addr:Int, len:Int):Int
  def pmem_flush(addr:Int, len:Int):Unit
  def pmem_drain():Unit
  def pmem_has_hw_drain():Int
  def pmem_memmove_persist(pmemdest:Int, src:Int, len:Int):Int
  def pmem_memcpy_persist(pmemdest:Int, src:Int, len:Int):Int
  def pmem_memset_persist(pmemdest:Int, c:Int, len:Int):Int
  def pmem_memmove_nodrain(pmemdest:Int, src:Int, len:Int):Int
  def pmem_memcpy_nodrain(pmemdest:Int, src:Int, len:Int):Int
  def pmem_memset_nodrain(pmemdest:Int, c:Int, len:Int):Int
}

object libpmem {
  private var _libpmem:libpmem = null
  def run():libpmem = {
    if ( _libpmem == null ) {
      _libpmem = Native.loadLibrary("pmem", classOf[libpmem]).asInstanceOf[libpmem]
    }
    _libpmem
  }
}
