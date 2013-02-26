import org.scalatest._
import jsy.lab3.ast._
import Lab3._

class IfSpec extends FlatSpec {

  "If" should "evaluate the first expression if the conditional is true using big-step semantics" in {
    val e1 = Binary(Plus, N(3), N(2))
    val e2 = Binary(Plus, N(1), N(1))
    val e3 = evaluate(If(B(true), e1, e2)) 
    assert(e3 === N(5))
  } 
  
  "If" should "evaluate the second expression if the conditional is false using big-step semantics" in {
    val e1 = Binary(Plus, N(3), N(2))
    val e2 = Binary(Plus, N(1), N(1))
    val e3 = evaluate(If(B(false), e1, e2)) 
    assert(e3 === N(2))
  } 

  "If" should "evaluate the first expression if the conditional is true using small-step semantics" in {
    val e1 = Binary(Plus, N(3), N(2))
    val e2 = Binary(Plus, N(1), N(1))
    val e3 = iterateStep(If(B(true), e1, e2)) 
    assert(e3 === N(5))
  } 
  
  "If" should "evaluate the second expression if the conditional is false using small-step semantics" in {
    val e1 = Binary(Plus, N(3), N(2))
    val e2 = Binary(Plus, N(1), N(1))
    val e3 = iterateStep(If(B(false), e1, e2)) 
    assert(e3 === N(2))
  } 
}
