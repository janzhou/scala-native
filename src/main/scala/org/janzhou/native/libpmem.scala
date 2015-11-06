package org.janzhou.native

import com.sun.jna._

trait libpmem extends Library {
  def pmem_map(fd:Int):Pointer
  def pmem_unmap(pmemaddr:Pointer, pmem_len:Long):Int
  def pmem_is_pmem(pmemaddr:Pointer, pmem_len:Long):Int
  def pmem_persist(addr:Pointer, len:Long):Unit
  def pmem_msync(addr:Pointer, len:Long):Int
  def pmem_flush(addr:Pointer, len:Long):Unit
  def pmem_drain():Unit
  def pmem_has_hw_drain():Int
  def pmem_memmove_persist(pmemdest:Pointer, src:Pointer, len:Int):Pointer
  def pmem_memcpy_persist(pmemdest:Pointer, src:Pointer, len:Int):Pointer
  def pmem_memset_persist(pmemdest:Pointer, c:Int, len:Int):Pointer
  def pmem_memmove_nodrain(pmemdest:Pointer, src:Pointer, len:Int):Pointer
  def pmem_memcpy_nodrain(pmemdest:Pointer, src:Pointer, len:Int):Pointer
  def pmem_memset_nodrain(pmemdest:Pointer, c:Int, len:Int):Pointer
}

object libpmem {
  private var _libpmem:libpmem = null
  def run():libpmem = {
    if ( _libpmem == null ) {
      _libpmem = Native.loadLibrary("pmem", classOf[libpmem]).asInstanceOf[libpmem]
    }
    _libpmem
  }

  def call:libpmem = run()
}
