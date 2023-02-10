package lectures.part2oop

object AbstractDataTypes extends App {

  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "K9"
    override def eat: Unit = println("crunch crunch")

  }


  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a $creatureType and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // -- scala has single class inheritance
  // 3 - traits are behavior

  /**
   * Scala's type hiearchy
   * scala.Any -> scala.AnyRef (String, List, Set, etc) -> scala.Null
   * scala.Any -> scala.AnyVal (Int, Unit, Boolean, Float
   * scala.Nothing
   */

}
