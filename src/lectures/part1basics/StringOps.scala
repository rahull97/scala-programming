package lectures.part1basics

object StringOps extends App {


  val str: String = "Hello, I am learning Scala"


  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)


  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') // a2z
  println(str.reverse)
  println(str.take(2))


  // Scala-specific: String interpolators


  // S-interpolators


  val name = "David"
  val age = 10
  val greeting =  s"Hi, my name is $name and I am $age years old."
  println(greeting)
  val anotherGreeting = s"Hi, my name is $name and I will be turning ${age + 1} years old"
  println(anotherGreeting)


  // F-interpolators


  /*
      F formatted string: They are similar to S formatted, in addition they also support
      format specifiers.
      Example: %d, %s, %2.2f etc
   */


  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth) // David can eat 1.20 burgers per minute


  // raw interpolators


  /*
      raw interpolated strings are also similar to S interpolated string,
      except that they print all the characters literally
   */


  println(raw"This is a \n newline") // This is a \n newline
  val escaped = "This is a \n newline"
  println(raw"$escaped")
  /*
    This is a
      newline

    Injected variables are not affected in the raw format string.
  */
}
