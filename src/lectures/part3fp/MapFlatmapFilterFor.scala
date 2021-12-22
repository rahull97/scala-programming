package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1,2,3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map( _ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // print all the combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("Blue", "Red")
  // List("a1", "a2", ... "d4")

  // way of looping using functional programming
  val combinations = chars.flatMap(c => numbers.map(n => c + "" + n))
  println(combinations)

  val anotherCombination = chars.flatMap(c => numbers.flatMap(n => colors.map(col => c + "" + n + "-" + col)))
  println(anotherCombination)

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield c + "" + n + "-" + color

  println(forCombinations)

  val anotherForCombinations = for {
    n <- numbers if n % 2 == 0          // guard
    c <- chars
    color <- colors
  } yield c + "" + n + "-" + color

  println(anotherForCombinations)

  for {
    n <-numbers
  } println(n)

  // syntax overload - another way of calling map function

  list.map { x =>
    x * 2
  }

  /*
    Exercise:

    A small collection of at most ONE element = Maybe[+T]
    - map, flatMap, filter
   */

  


}
