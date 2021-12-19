package lectures.part2oop

object OOBasics extends App {


  val person = new Person("John", 26)

  // The below line throws error because the name is class parameter and not class field
  // println(person.name)
  println(person.age) // 26
  println(person.x) // 20
  person.greet("Daniel")
  person.greet()
}


/*

   class <name-of-the-class>(param1: Int, val param2: Int)

   In the above line, param1 is the class parameter and not
   class field. Thus it can be used only inside the class
   definition and not accessed outside of it. In other words,
   it is private to class.

   To convert a class parameter to a class field, we need
   to prepend with val or var keyword.

   val and var definitions inside class body are class fields.

   Every time the class is instantiated, the whole body of the
   class is evaluated.

   constructors can be overloaded as well. The overloaded
   constructor definition can only included the call to other
   constructor definition and nothing else.

 */


// constructor
class Person(name: String, val age: Int = 0) {

  // body

  // class field
  val x: Int = 20
  println(1 + 3)


  def greet(name: String): Unit = {
    println(s"${this.name} says: Hi $name")
  }


  // method overloading
  def greet(): Unit = {
    println(s"Hi, my name is $name")
  }


  // multiple constructors
  def this(name: String) = this(name, 1)
  def this() = this("John Doe")
}