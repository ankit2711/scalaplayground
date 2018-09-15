package typeclasses

//Type class
trait Show[A] {
  def show(a: A): String
}

//Companion Object
object Show {

  def apply[A](implicit sh: Show[A]) = sh

  //With implicit argument (Option 1)
  def show[A](a: A)(implicit sh: Show[A]) = sh.show(a)

  //With implicitly and also context bound syntax. (Option 2)
  //def show[A: Show](a: A) = implicitly[Show[A]].show(a)

  //Apply method with implicit argument (Option 3)
  //def show[A: Show](a: A) = Show.apply[A].show(a)

  //Implicit implementation
  implicit val intShow: Show[Int] = new Show[Int] {
    override def show(a: Int): String = s"Int[$a]"
  }

  implicit val stringShow: Show[String] = new Show[String] {
    override def show(a: String): String = s"String[$a]"
  }

  implicit val doubleShow: Show[Double] = new Show[Double] {
    override def show(a: Double): String = s"Double[$a]"
  }

  implicit class ShowOps[A](a: A)(implicit sh : Show[A]) {
    def show = sh.show(a)
  }

}