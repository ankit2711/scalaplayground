package cats.examples

import cats.Eval

/**
  * Ackermann function defintion
  * A(m,n) = if m >0 n+1 else if (m >0 && n==0) A(m-1,1) else if (m > 0 && n > 0) A(m-1, A(m, n-1))
  *
  */
object AckermannWithEval {

  def ack(m: Int, n: Int): Eval[Int] = (m, n) match {
    case (0, _) => Eval.now(n + 1)
    case (_, 0) => Eval.later(ack(m - 1, 1)).flatMap(x => x)
    case (_, _) => for {
      inner <- Eval.later(ack(m, n - 1)).flatMap(x => x)
      outer <- Eval.later(ack(m - 1, inner)).flatMap(x => x)
    } yield outer
  }
}
