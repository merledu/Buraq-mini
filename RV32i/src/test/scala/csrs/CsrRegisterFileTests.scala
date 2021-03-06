package csrs
import chisel3._
import chisel3.iotesters.PeekPokeTester
import main.scala.core.csrs.{CsrAddressMap, CsrRegisterFile, Exc_Cause}

class CsrRegisterFileTests(c: CsrRegisterFile) extends PeekPokeTester(c) {
  // default values
  reset(5)
  poke(c.io.i_hart_id, 0.U)
  poke(c.io.i_boot_addr, 0.U)
  poke(c.io.i_csr_mtvec_init, false.B)
  poke(c.io.i_csr_access, false.B)
  poke(c.io.i_csr_wdata, 0.U)
  poke(c.io.i_csr_op, 0.U)
  poke(c.io.i_csr_op_en, false.B)
  poke(c.io.i_csr_addr, 0.U)
  poke(c.io.i_irq_software, false.B)
  poke(c.io.i_irq_timer, false.B)
  poke(c.io.i_irq_external, false.B)
  poke(c.io.i_nmi_mode, false.B)
  poke(c.io.i_pc_if, 0.U)
  poke(c.io.i_pc_id, 0.U)
  poke(c.io.i_pc_wb, 0.U)
  poke(c.io.i_csr_save_if, false.B)
  poke(c.io.i_csr_save_id, false.B)
  poke(c.io.i_csr_save_wb, false.B)
  poke(c.io.i_csr_restore_mret, false.B)
  poke(c.io.i_csr_restore_dret, false.B)
  poke(c.io.i_csr_mcause, 0.U)
  poke(c.io.i_csr_mtval, 0.U)
  poke(c.io.i_instr_ret, false.B)
  poke(c.io.i_iside_wait, false.B)
  poke(c.io.i_jump, false.B)
  poke(c.io.i_branch, false.B)
  poke(c.io.i_branch_taken, false.B)
  poke(c.io.i_mem_load, false.B)
  poke(c.io.i_mem_store, false.B)
  poke(c.io.i_dside_wait, false.B)
  step(3)
  poke(c.io.i_csr_addr, CsrAddressMap.MSTATUS)
  poke(c.io.i_csr_wdata, "h00000f".U)
  poke(c.io.i_csr_op, 3.U)
  poke(c.io.i_csr_op_en, true.B)
 step(1)
  poke(c.io.i_csr_addr, CsrAddressMap.MSTATUS)
  poke(c.io.i_csr_op, 0.U)
  poke(c.io.i_csr_op_en, true.B)
  step(4)
}
