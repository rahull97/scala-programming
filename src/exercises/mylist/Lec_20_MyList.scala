package exercises.mylist


/*
  Exercises covered in this part:

  1. Generic trait MyPredicate[-T] with a little method test(T) => Boolean
  2. Generic trait MyTransformer[-A, B] with a method transform(A) => B
  3. MyList:
      - map(transformer) => MyList
      - filter(predicate) => MyList
      - flatMap(transformer from A to MyList[B]) => MyList[B]

      class EvenPredicate extends MyPredicate[Int]
      class StringToIntTransformer extends MyTransformer[String, Int]

      [1, 2, 3].map(n * 2) = [2, 4, 6]
      [1, 2, 3, 4].filter(n % 2 == 0) = [2, 4]
      [1, 2, 3].flatMap(n => [n, n+1]) => [1, 2, 2, 3, 3, 4]

 */

object Lec_20_MyList extends App {

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

    def map[B](transformer: MyTransformer[A, B]): MyList[B]
    def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
    def filter(predicate: MyPredicate[A]): MyList[A]

    //concatenation
    def ++[B >: A](list: MyList[B]): MyList[B]

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

    def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
    def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
    def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

    def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
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

    /*
      [1, 2, 3].filter(n % 2 == 0)
       = [2,3].filter(n % 2 == 0)
       = new Cons(2, [3].filter(n % 2 == 0))
       = new Cons(2, Empty.filter(n % 2 == 0))
       = new Cons(2, Empty)
     */
    def filter(predicate: MyPredicate[A]): MyList[A] = {
      if(predicate.test(h)) new Cons(h, t.filter(predicate))
      else t.filter(predicate)
    }

    /*
      [1, 2, 3].map(n * 2)
      = new Cons(2, [2, 3].map(n * 2))
      = new Cons(2, new Cons(4, [3].map(n * 2)))
      = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
      = new Cons(2, new Cons(4, new Cons(6, Empty)))
     */
    def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
      new Cons(transformer.transform(h), t.map(transformer))
    }


    /*
      [1, 2] ++ [3, 4, 5]
       = new Cons(1, [2] ++ [3, 4, 5])
       = new Cons(1, new Cons(2, Empty ++ [3, 4, 5]))
       = new Cons(1, new Cons(2, [3,4,5])) = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, Empty)))))
     */
    def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

    /*
      [1, 2].flatMap(n => [n, n + 1])
       = [1,2] ++ [2].flatMap(n => [n, n + 1])
       = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n + 1])
       = [1,2] ++ [2,3] ++ Empty
       = [1,2,2,3,Empty] = [1,2,2,3]
     */
    def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
      transformer.transform(h) ++ t.flatMap(transformer)

  }


  trait MyPredicate[-T] {
    def test(elem: T): Boolean
  }


  trait MyTransformer[-A, B]{
    def transform(element: A): B
  }


  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  // use of anonymous class
  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(element: Int): Int = element * 2
  }).toString)

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)
  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(element: Int): MyList[Int] = new Cons(element, new Cons(element + 1, Empty))
  }).toString)

}
