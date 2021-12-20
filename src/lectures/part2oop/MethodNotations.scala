package lectures.part2oop

object MethodNotations extends App {


  class Person(val name: String, favoriteMovie: String) {

    def likes(movie: String): Boolean = movie == favoriteMovie
    def + (person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck ?!"
    def isAlive(): Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie."

  }


  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // syntactic sugar
  /*
      The above notation of calling a method is called as infix
      notation or operator notation

      infix notation = operator notation.

      It can only be used for methods which receives single
      parameters

      Syntactic sugars are nicer ways of writing code that
      are equivalent to more complex or cumbersome way of
      writing the same code.
   */


  // "operators in Scala"
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // All OPERATORS are METHODS in Scala.


  // prefix notation

  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)


  // postfix notation - Can be only with methods which does not receive any parameters

  println(mary.isAlive())
  println(mary isAlive)

  /*
     apply method

     It is a special method in Scala.
     Whenever a object of a class is called like a function,
     compiler actually calls the apply method of the class.

     Example:

      class Person(name: String, age: Int) {

        def apply(): String = s"Hi, my name is $name and I am $age years old."

      }

      val mary = new Person("Mary", 20)

      println(mary.apply())
      println(mary()) // equivalent
   */

  println(mary.apply())
  println(mary()) //equivalent
}
