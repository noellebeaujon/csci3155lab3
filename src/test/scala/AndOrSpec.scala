import org.scalatest._
import jsy.lab3.ast._
import Lab3._

class AndOrSpec extends FlatSpec {

  "And" should "return true only if both expressions are true using big-step semantics" in {
    val t = B(true)
    val f = B(false)
    assert(evaluate(Binary(And,t,t)) === t)
    assert(evaluate(Binary(And,t,f)) === f)
    assert(evaluate(Binary(And,f,t)) === f)
    assert(evaluate(Binary(And,f,f)) === f)
  } 

 
  "Or" should "return true if either or both expressions are true using big-step semantics" in {
    val t = B(true)
    val f = B(false)
    assert(evaluate(Binary(Or,t,t)) === t)
    assert(evaluate(Binary(Or,f,t)) === t)
    assert(evaluate(Binary(Or,t,f)) === t)
    assert(evaluate(Binary(Or,f,f)) === f)
  }


  "And" should "return true only if both expressions are true using small-step semantics" in {
    val t = B(true)
    val f = B(false)
    assert(iterateStep(Binary(And,t,t)) === t)
    assert(iterateStep(Binary(And,t,f)) === f)
    assert(iterateStep(Binary(And,f,t)) === f)
    assert(iterateStep(Binary(And,f,f)) === f)
  }

  "Or" should "return true if either or both expressions are true using small-step semantics" in {
    val t = B(true)
    val f = B(false)
    assert(iterateStep(Binary(Or,t,t)) === t)
    assert(iterateStep(Binary(Or,f,t)) === t)
    assert(iterateStep(Binary(Or,t,f)) === t)
    assert(iterateStep(Binary(Or,f,f)) === f)
  }
}
