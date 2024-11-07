import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class Countertb extends AnyFlatSpec with ChiselScalatestTester {
    "Counter" should "pass" in {
        test(new Counter) { dut =>
            for (sel <- 0 to 100) {
                dut.clock.step(1)
                println(s"counter=${dut.io.cnt.peekInt()}\tblnk=${dut.io.out.peekInt()}")
            }
        }    
    }
}

class CounterWaveSpec extends AnyFlatSpec with ChiselScalatestTester {
  "Counter" should "pass" in {
    test(new Counter).withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
      dut.clock.step(20)
    }
  }
}