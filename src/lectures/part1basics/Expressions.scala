package lectures.part1basics

object Expressions extends App {


  val x = 1 + 2 // EXPRESSION
  println(x)


  println(2 + 3 * 4) // arithmetic operators
  // + - * / % & | ^ << >> >>> (right shift with zero extension)


  println(1 == x) // relational operators
  // == != > >= < <=


  println(!(1 == x)) // logical operators
  // ! && ||


  var aVariable = 2
  aVariable += 3 // also works with -= *= /= .... side effects
  println(aVariable)


  // Instructions (DO) vs Expressions (VALUE)


  // IF expression
  val aCondition = true
  val aConditionedValue =  if(aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)


  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }


  // EVERYTHING IN SCALA IS AN EXPRESSION
  // ONLY DEFINITIONS SUCH AS VAL, VAR, CLASS ETC ARE NOT EXPRESSION BUT EVERYTHING ELSE IS AN EXPRESSION


  val aWeirdValue: Unit = (aVariable = 3) // Unit === void
  println(aWeirdValue) // ()


  // Side effects in Scala are actually expressions returning Unit value. Example: println(), while, reassigning


  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
  println(aCodeBlock) // hello


  // VALUE OF A CODE BLOCK IS THE VALUE OF ITS LAST EXPRESSION
}
