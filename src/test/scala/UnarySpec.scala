import org.scalatest._
import jsy.lab3.ast._
import Lab3._

class UnarySpec extends FlatSpec {

  "Neg" should "return the negation of a number value using big-step semantics" in {
    val e1 = N(5)
    val e2 = evaluate(Unary(Neg, e1))
    assert(e2 === N(-5))
  } 
  
  "Not" should "return the compliment of a boolean value using big-step semantics" in {
    val e1 = B(true)
    val e2 = B(false)
    val e3 = evaluate(Unary(Not, e1))
    val e4 = evaluate(Unary(Not, e2))
    assert(e3 === B(false))
    assert(e4 === B(true))
  }

  "Neg" should "return the negation of a number value using small-step semantics" in {
    val e1 = N(5)
    val e2 = iterateStep(Unary(Neg, e1))
    assert(e2 === N(-5))
  } 
  
  "Not" should "return the compliment of a boolean value using small-step semantics" in {
    val e1 = B(true)
    val e2 = B(false)
    val e3 = iterateStep(Unary(Not, e1))
    val e4 = iterateStep(Unary(Not, e2))
    assert(e3 === B(false))
    assert(e4 === B(true))
  }
}
