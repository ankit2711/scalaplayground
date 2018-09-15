package cats.examples

import org.scalatest.{FlatSpec, Matchers}

class AckermannWithEvalSpec extends FlatSpec with Matchers {
  it should "return result for A[2,2] as " in {

    val ackermannWithEval = AckermannWithEval;
    ackermannWithEval.ack(2,2).value shouldBe 7
  }

  it should "return result for A[4,1] as " in {

    val ackermannWithEval = AckermannWithEval;
    ackermannWithEval.ack(4,1).value shouldBe 65533
  }
}

object AckermannWithEvalSpec
