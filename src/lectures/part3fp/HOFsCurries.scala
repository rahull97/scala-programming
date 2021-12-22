package lectures.part3fp

import scala.annotation.tailrec

object HOFsCurries extends App {


  /*
    Higher Order Function: The function which takes other function as an argument or
    return another function as its result are called as HOFs.

    Example: map, filter, flatMap etc
   */


  // function that applies a given function n times over a given value x.
  // nTimes(f, n, x)
  // nTimes(f, 3, x) =  f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  // nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))
  @tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if(n <= 0)x
    else nTimes(f, n-1, f(x))
  }

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  // better way to implement above function
  // ntb(f,n) = x => f(f(f...f(x)))
  // increment10 = ntb(plusOne, 10) = x => plusOne(plusOne...plusOne(x)) = 10 times application of the function
  // val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if(n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))
  }

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))


  /*
     curried functions
     ARROW SIGNS ARE RIGHT ASSOCIATIVE.

     They are very useful if we want to define the helper functions
     that we want to use later on various values

   */
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // 3 + y
  println(add3(20))
  println(superAdder(2)(20)) // currying.


  // functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")  // It is compulsory to specify types of sub functions.
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))


  /*
      Currying = functions with multiple parameter lists
   */

  /*
    Exercises:

    1. toCurry(f: (Int, Int) => Int) = (Int => Int => Int)
       fromCurry(f: (Int => Int => Int)) = (Int, Int) => Int

    2. compose(f,g) = x => f(g(x))
       andThen(f,g) = x => g(f(x))

   */

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) = {
    x => y => f(x,y)
  }

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int = {
    (x, y) => f(x)(y)
  }

  // FunctionX

  /*

  def compose(f: Int => Int, g: Int => Int): Int => Int = {
    x => f(g(x))
  }

  def andThen(f: Int => Int, g: Int => Int): Int => Int = {
    x => g(f(x))
  }

  */


  // Making Generic

  def compose[A,B,T](f: A => B, g: T => A): T => B = {
    x => f(g(x))
  }

  def andThen[A,B,C](f: A => B, g: B => C): A => C = {
    x => g(f(x))
  }

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)
  def add4: Int => Int = superAdder2(4)
  println(add4(17))

  val simpleAdder = fromCurry(superAdder2)
  println(simpleAdder(4,17))


  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)

  println(composed(2))
  println(ordered(2))

}
