import chisel3._
import chisel3.util._

class Counter extends Module {
    val io = IO(new Bundle {
        val cnt = Output(UInt(4.W))
        val out = Output(UInt(1.W))
    })
    val CNT_MAX = (20 / 2 - 1).U
    val cntReg = RegInit(0.U(4.W))
    val blkReg = RegInit(0.U(1.W))
    cntReg := cntReg + 1.U
    when(cntReg === CNT_MAX) {
        cntReg := 0.U
        blkReg := ~blkReg
    }
    io.out := blkReg
    io.cnt := cntReg
}

object DecoderMain extends App {
  val s = getVerilogString(new Counter())
  println(s)
}