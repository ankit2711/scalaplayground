package typeclasses

import org.scalatest.{FlatSpec, Matchers}


class ShowSpec extends FlatSpec with Matchers {

  it should "return String for Int" in {

    import typeclasses.Show._
    20.show shouldBe "Int[20]"

  }

  it should "return String for Double" in {

    import typeclasses.Show._
    20.0.show shouldBe "Double[20.0]"

  }

}

object ShowSpec