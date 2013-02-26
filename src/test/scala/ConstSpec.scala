import org.scalatest._
import jsy.lab3.ast._
import Lab3._

class ConstSpec extends FlatSpec {

  "ConstDecl" should "extend the environment using big-step semantics" in {
    val e1 = N(3)
    val e2 = Binary(Plus, Var("x"), N(1))
    val e3 = evaluate(ConstDecl("x", e1, e2)) 
    assert(e3 === N(4))
  } 

  "ConstDecl" should "perform a substitution using small-step semantics" in {
    val e1 = N(3)
    val e2 = Binary(Plus, Var("x"), N(1))
    val e3 = iterateStep(ConstDecl("x", e1, e2)) 
    assert(e3 === N(4))
  } 

  
}
