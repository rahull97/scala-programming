package lectures.part2oop

/*
    1. Scala has a single class inheritance.
    2. Extending a class mean inheriting all the non private fields and
       methods of a base class.
    3. Access modifiers in Scala are private, protected and public.
    4. When we instantiate a sub class, JVM needs to call the parent class
       constructor first. Also, we can call any auxiliary constructor of
       super class as well.
    5. We can override the public or protected fields and methods
       of super class in child class using "override" keyword.
    6. Fields as opposed to methods has special property that they can
       be overridden in child class constructor as well.
    7. Whenever a method is called, it goes to the most overridden
       version whenever possible.
    8. super keyword is used whenever we want to reference method or
       field from base class.
 */

object Inheritance extends App {

  sealed class Animal {
    val creatureType: String = "wild"
    // protected def eat: Unit = println("nom-nom")
    def eat: Unit = println("nom-nom")
  }

  class Cat extends Animal {
    def crunch: Unit = {
      eat
      println("crunch-crunch")
    }
  }

  val cat = new Cat
  cat.crunch


  // constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)


  // overriding
  class Dog(override val creatureType: String) extends Animal{
    // override val creatureType: String = "domestic"
    override def eat: Unit = {
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)


  // type substitution (broad-sense: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat // prints crunch, crunch instead of non-nom


  /*
      overriding = It means to supply different implementation in
                   derived classes.

      overloading = It means implementing multiple methods with
                    the same name but different signatures in
                    the same class.
   */


  /*
      Preventing overrides:

      1. use final keyword on the member
      2. use final on the class itself - It prevents the class from being extended(inherited).
      3. seal the class = extend classes in THIS FILE, prevent extension in other files.
   */

}
