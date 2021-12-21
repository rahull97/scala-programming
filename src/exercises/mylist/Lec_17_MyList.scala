package exercises.mylist

/*
   MyList is singly linked list, describing a list of Integers.
 */

object Lec_17_MyList extends App {


  abstract class MyList {

    /*
        head = first element of the list
        tail = remainder of the list
        isEmpty = is this list empty
        add(int) = new list with this element added.
        toString => a string representation of the list.
     */

    def head: Int
    def tail: MyList
    def isEmpty: Boolean
    def add(element: Int): MyList
    def printElements: String
    // polymorphic call
    override def toString: String = "[" + printElements + "]"

  }


  object Empty extends MyList{

    def head: Int = throw new NoSuchElementException
    def tail: MyList = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add(element: Int): MyList = new Cons(element, Empty)
    def printElements: String = ""

  }


  class Cons(h: Int, t: MyList) extends MyList {

    def head: Int = h
    def tail: MyList = t
    def isEmpty: Boolean = false
    def add(element: Int): MyList = new Cons(element, this)
    def printElements: String = {
      if(t.isEmpty) "" + h
      else h + " " + t.printElements
    }

  }


  // val li = new Cons(1, Empty)
  val li = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(li.head)
  println(li.tail.head)
  println(li.add(4).head)
  println(li.isEmpty)
  println(li.toString)

}
