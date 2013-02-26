import org.scalatest._
import jsy.lab3.ast._
import Lab3._

class ArithmeticSpec extends FlatSpec {

  "Plus" should "add two number values and return a number using big-step semantics" in {
    val e1 = N(1)
    val e2 = N(2)
    val e3 = evaluate(Binary(Plus, e1, e2))
    assert(e3 === N(3))
  }


  "Plus" should "also be able to concatenate strings using big-step semantics" in {
    val e1 = S("Hello")
    val e2 = S("World")
    val e3 = evaluate(Binary(Plus, e1, e2))
    assert(e3 === S("HelloWorld"))
  }

  "Minus" should "subtract two number values and return a number using big-step semantics" in {
    val e1 = N(3)
    val e2 = N(1)
    val e3 = evaluate(Binary(Minus, e1, e2))
    assert(e3 === N(2))
  }

  "Times" should "multiply two number values and return a number using big-step semantics" in {
    val e1 = N(3)
    val e2 = N(2)
    val e3 = evaluate(Binary(Times, e1, e2))
    assert(e3 === N(6))
  }

  "Div" should "divide two number values and return a number using big-step semantics" in {
    val e1 = N(8)
    val e2 = N(5)
    val e3 = evaluate(Binary(Div, e1, e2))
    assert(e3 === N(1.6))
  }

  "Plus" should "add two number values and return a number using small-step semantics" in {
    val e1 = N(1)
    val e2 = N(2)
    val e3 = iterateStep(Binary(Plus, e1, e2))
    assert(e3 === N(3))
  }

  "Plus" should "also be able to concatenate strings using small-step semantics" in {
    val e1 = S("Hello")
    val e2 = S("World")
    val e3 = iterateStep(Binary(Plus, e1, e2))
    assert(e3 === S("HelloWorld"))
  }

  "Minus" should "subtract two number values and return a number using small-step semantics" in {
    val e1 = N(3)
    val e2 = N(1)
    val e3 = iterateStep(Binary(Minus, e1, e2))
    assert(e3 === N(2))
  }

  "Times" should "multiply two number values and return a number using small-step semantics" in {
    val e1 = N(3)
    val e2 = N(2)
    val e3 = iterateStep(Binary(Times, e1, e2))
    assert(e3 === N(6))
  }

  "Div" should "divide two number values and return a number using small-step semantics" in {
    val e1 = N(8)
    val e2 = N(5)
    val e3 = iterateStep(Binary(Div, e1, e2))
    assert(e3 === N(1.6))
  }

}
