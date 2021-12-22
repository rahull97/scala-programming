package lectures.part3fp

object AnonymousFunctions extends App {

  /*
    val doubler = new Function1[Int, Int] {
      override def apply(v1: Int): Int = v1 * 2
    }
  */

  /*
    equivalent implementation of above piece of code.

    Also called as anonymous function(LAMBDA).
    It is basically a syntactic sugar for the above
    piece of code.

    val doubler = (x: Int) => x * 2
            or
    as shown below:
   */
  val doubler: Int => Int =
    x => x * 2


  // multiple params in lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b


  // no params
  val justDoSomething: () => Int = () => 3

  // careful
  println(justDoSomething) // lectures.part3fp.AnonymousFunctions$$$Lambda$22/0x0000000840085840@2669b199
  println(justDoSomething()) // 3


  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }


  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1   // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _  // equivalent to (a, b) => a + b


  /*
     1. MyList: replace all the FunctionX calls with lambda
     2. Rewrite the "superAdder" as an anonymous function.
   */

  val superAdder: Int => Int => Int = x => y => x + y
  println(superAdder(3)(4))

}
