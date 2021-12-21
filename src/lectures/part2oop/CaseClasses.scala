package lectures.part2oop

object CaseClasses extends App {

  /*
     They are Quick lightweight data structures with little boilerplate

     CCs are extremely powerful for lightweight data structures.

     They already provide sensible implementation of various
     methods such as:
     equals, hashCode, toString

     Thus they can used in Collections as well.

     They are serializable too, thus extremely useful
     in distributed computing applications

   */

  case class Person(name: String, age: Int)

  // 1. class parameters are promoted to class fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString method implementation
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim)

  // 3. equals and hashcode implemented out of the box - values are compared
  // instead of references
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // true

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. CCs have COMPANION objects
  val thePerson = Person
  val mary = Person("Mary", 23)
  println(mary)

  // 6. CCs are serializable
  // Akka

  // 7. CCs have extractor pattern = CCs can be used in PATTERN MATCHING


  /*
    case objects are similar to case classes, except they
    do not have companion objects
   */
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

}
