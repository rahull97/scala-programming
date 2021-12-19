package lectures.part1basics

object Functions extends App {


  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }
  println(aFunction("hello", 3))


  def aParameterLessFunction(): Int = 42
  println(aParameterLessFunction())
  println(aParameterLessFunction)


  def aRepeatedFunction(aString: String, n: Int): String = {
    if(n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("hello", 3))


  // When you need loops, use Recursion


  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  aFunctionWithSideEffects("hello world!")


  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b
    aSmallFunction(n, n-1)
  }


  /*
    1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
    2. Factorial function 1 * 2 * 3 * ... * n
    3. A Fibonacci function
       f(1) = 1
       f(2) = 1
       f(n) = f(n-1) + f(n-2)
    4. Tests if a number is Prime
   */


  def greetFunc(name: String, age: Int): String = {
    s"Hi, my name is $name and I am $age years old."
  }
  println(greetFunc("David", 12))


  def aFactorial(n: Int): Int = {
    if(n <= 0) 1
    else n * aFactorial(n-1)
  }
  println(aFactorial(5))


  def fib(n: Int): Int = {
    if(n <= 2)1
    else fib(n-1) + fib(n-2)
  }
  println(fib(5))


  def isPrime(n: Int): Boolean = {

    def isPrimeUntil(t: Int): Boolean = {
      if(t <= 1) true
      else isPrimeUntil(t-1) && n % t != 0
    }
    isPrimeUntil(n/2)

  }
  println(isPrime(10))
}
