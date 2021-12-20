package lectures.part2oop

object Objects extends App {

  /*
    Scala classes does not have class level functionality ("static").
    They offer even better approach using the concept of object.

    SCALA OBJECT = SINGLETON INSTANCE
   */

  object Person {  // type + its only instance

    // "static/class" - level functionality

    val N_EYES = 2
    def canFly: Boolean = false

    // Implement Factory Pattern
    def apply(mother: Person, father: Person): Person = new Person("Bob")

  }

  class Person(val name: String) {

    // instance-level functionality

  }

  /*
      In a module when a class and its corresponding object are defined
      together, then they are called as COMPANIONS.

      Companions can also access each other's private members.
   */


  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john) // false


  val person1 = Person
  val person2 = Person
  println(person1 == person2) // true


  // call factory method
  val bob = Person(mary, john) //  equivalent to Person.apply(mary, john)
  println(bob.name)

}
