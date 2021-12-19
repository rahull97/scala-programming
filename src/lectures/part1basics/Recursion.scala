package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {


  def factorial(n: Int): Int = {
    if(n <= 1) 1
    else {
      println(s"Computing factorial of $n - I first need factorial of ${n-1}..")
      val result = n * factorial(n-1)
      println(s"Computed factorial of $n")
      result
    }
  }
  println(factorial(5))


  def anotherFactorial(n: Int): BigInt = {

    @tailrec
    def factHelper(x: Int, acc: BigInt): BigInt = {
      if(x <= 1)acc
      else factHelper(x-1, x*acc)
    }

    factHelper(n,1)
  }
  println(anotherFactorial(5000))


  /*
      anotherFactorial(10) = factHelper(10, 1)
      = factHelper(9, 10 * 1)
      = factHelper(8, 9 * 10 * 1)
      = factHelper(7, 8 * 9 * 10 * 1)
      = ...
      = factHelper(2, 3 * 4 * ... * 10 * 1)
      = factHelper(1, 2 * 3 * ....* 10 * 1)
      = 1 * 2 * 3 *... * 8 * 9 * 10
   */


  /*
      Tail Recursion: Recursive call should be the LAST EXPRESSION of
                      its code path.
                      This allows JVM to preserve the same stack
                      frame and not use additional stack frames
                      for recursive calls.

      Tail Recursion = use recursive call as the last expression.

      When you need loops use tail recursion

      Thumb Rule: We need as many accumulators equal to the number
                  of recursive calls we have on code path.
   */


  /*
      1.  Concatenate a string n times
      2.  IsPrime function using tail recursive
      3.  Fibonacci function using tail recursive
   */


  def nTimesString(aString: String, n: Int): String = {

    @tailrec
    def concatHelper(str: String, curr_cnt: Int, acc: String): String = {
      if(curr_cnt < 1) acc
      else concatHelper(str, curr_cnt-1, str + acc)
    }

    concatHelper(aString, n, "")
  }
  println(nTimesString("hello", 3))


  def isPrime(n: Int): Boolean = {

    @tailrec
    def isPrimeUntil(t: Int, isStillPrime: Boolean): Boolean = {
      if(t <= 1) true
      else if (!isStillPrime) false
      else isPrimeUntil(t-1, n % t !=0 && isStillPrime)
    }

    isPrimeUntil(n/2, isStillPrime = true)
  }
  println(isPrime(10))


  def fib(n: Int): Int = {

    @tailrec
    def fibHelper(x: Int, last: Int, nextToLast: Int): Int = {
      if(x >= n) last
      else fibHelper(x+1, last + nextToLast, last)
    }

    fibHelper(2, 1, 1)
  }
  println(fib(8))


  /*
      fibonacci series:
      1 1 2 3 5 8 13 21 34 55 ....
   */
}
