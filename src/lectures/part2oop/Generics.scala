package lectures.part2oop

object Generics extends App {

  /*
     Type A between square brackets denotes a generic type.
     We can use it then inside the class definition.
   */

  class MyList[+A]{
    // use type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
       A = Cat
       B = Animal
     */
  }

  class MyMap[Key, Value]

  trait MyTrait[A]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]


  /*
      define generic methods
   */
  object MyList {

    def empty[A]: MyList[A] = ???
    def sampleMethod[A](element: A): List[A] = ???

  }
  val emptyListOfIntegers = MyList.empty[Int]


  /*
     variance problem
   */
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  /*
    Question: If Cat extends Animal, does a list of Cat also extend list of Animal

    There are three possible answers to this question:

    1. yes List[Cat] extends List[Animal] = COVARIANCE BEHAVIOR
    2. no List[Cat] and List[Animal] are two separate things = INVARIANCE BEHAVIOR
       Invariant classes are each in its own world and you cannot substitute one
       for another.
    3. Hell, no! = opposite of option 1 = CONTRAVARIANCE BEHAVIOR
   */

  // +A means this is a Covariant list
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION => we return a list of Animals

  // A means this is an Invariant list
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  //-A means this is a Contravariant
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]


  /*
    bounded types: Bounded types allows you to use your generic classes,
                   only for certain types that are either a subclass of
                   a different type or a super class of a different
                   type.

                   class Cage[A <: Animal] = upper bounded type = only accepts subtypes of Animal
                   class Cage[A >: Animal] = lower bounded type = only accepts supertypes of Animal

    Bounded types solve a variance problem.
   */

  // Class Cage only accepts type parameters A which are subtypes of class Animal.
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  // generic type needs proper bounded type
  // val newCage = new Cage(new Car)

  // expand MyList exercise, to be generic.
}
