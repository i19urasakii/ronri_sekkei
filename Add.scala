import chisel3._

class Add extends Module {
    val io = IO(new Bundle {
        val a = Input(UInt(8.W))
        val b = Input(UInt(8.W))
        val y = Output(UInt(8.W))
    })
    io.y := io.a + io.b
}


object AddMain extends App {
  val s = getVerilogString(new Add())
  println(s)
}