package lectures.part2oop

/*
    1. There are some situations where we need leave fields or methods
       blank or un-implemented. These are called as abstract members
    2. Classes which contain abstract fields or methods are called as
       abstract classes.
    3. Abstract classes cannot be instantiated.
    4. "override" keyword is not mandatory for abstract members.
    5. traits are the ultimate abstract data types in Scala.
    6. traits by default, like abstract classes, have abstract fields and
       methods.
    7. classes can implement multiple traits
    8. "abstract classes" and "traits" can have both abstract as well
       as non abstract types.
 */


object AbstractDataTypes extends App {


  // abstract
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }


  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh-meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    override def eat: Unit = println("nom-nom")
    override def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)


  /*
      Difference between traits and abstract classes.
      1. traits do not have constructor parameters.
      2. multiple traits may be inherited by the same class.
      3. traits = behavior, abstract class = "thing"
   */

}
