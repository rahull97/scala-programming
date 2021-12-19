package lectures.part1basics

object CBNvsCBV extends App {


  def calledByValue(x: Long): Unit = {
    println("call by value: " + x)
    println("call by value: " + x)
  }


  def calledByName(x: => Long): Unit = {
    println("call by name: " + x)
    println("call by name: " + x)
  }


  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())


  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit =  println(x)


  // printFirst(infinite(), 34) throws stack overflow error


  printFirst(34, infinite())
}
