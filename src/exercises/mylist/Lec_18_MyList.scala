package exercises.mylist

object Lec_18_MyList extends App {

  abstract class MyList[+A] {

    /*
        head = first element of the list
        tail = remainder of the list
        isEmpty = is this list empty
        add(int) = new list with this element added.
        toString => a string representation of the list.
     */

    def head: A
    def tail: MyList[A]
    def isEmpty: Boolean
    def add[B >: A](element: B): MyList[B]
    def printElements: String
    // polymorphic call
    override def toString: String = "[" + printElements + "]"

  }

  /*
     Nothing type is a proper substitute for any type.

     In much the same way, as Nothing type is a proper
     substitute for any type, the object Empty here
     should be a proper substitute of a my list of
     any type.
   */

  object Empty extends MyList[Nothing]{

    def head: Nothing = throw new NoSuchElementException
    def tail: MyList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
    def printElements: String = ""

  }


  class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

    def head: A = h
    def tail: MyList[A] = t
    def isEmpty: Boolean = false
    def add[B >: A](element: B): MyList[B] = new Cons(element, this)
    def printElements: String = {
      if(t.isEmpty) "" + h
      else h + " " + t.printElements
    }

  }

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}
