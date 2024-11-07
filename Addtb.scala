import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class Addtb extends AnyFlatSpec with ChiselScalatestTester {
    "Add" should "pass" in {
        test(new Add) { dut =>
            for (a <- 0 to 100) {
                for (b <- 0 to 10) {
                    dut.io.a.poke(a)
                    dut.io.b.poke(b)
                    println(s"a=${a}, b=${b}, y= ${dut.io.y.peekInt()}")
                }
            }
        }    
    }
}

class AddWaveSpec extends AnyFlatSpec with ChiselScalatestTester {
  "Add" should "pass" in {
    test(new Add).withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
            for (a <- 0 to 100) {
                for (b <- 0 to 10) {
                    dut.io.a.poke(a)
                    dut.io.b.poke(b)
                    dut.clock.step()
                }
            }
//      dut.clock.step(20)
    }
  }
}