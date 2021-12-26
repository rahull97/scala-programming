package lectures.part4pm

import exercises.mylist.Lec_29_MyList.{Cons, Empty, MyList}


object AllThePatterns extends App {

  // 1 - constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a Number"
    case "Scala" => "The Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"
  }

  // 2 - match anything
  // 2.1 wildcard
  val matchAnything = x match {
    case _ => "hello"
  }

  // 2.2 variable
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1, 1) => 1
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case(_, (2, v)) => v
  }
  // PMs can be NESTED!

  // 4 - case classes - constructor pattern
  // PMs can be NESTED with CCs as well
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty => 0
    case Cons(head, tail) => head
    case Cons(head, Cons(subhead, subtail)) => subhead
  }

  println(matchAList)

  // 5 - list patterns
  val aStandardList = List(1,2,3,42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => 0 // extractor - advanced
    case List(1, _*) => 0 // list of arbitrary length - advanced
    case 1 :: List(_) =>  0 // infix pattern
    case List(1,2,_) :+ 42 => "lala"// infix pattern
  }

  // 6 - type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => 0 // explicit type specifier
    case _ => 0
  }

  // 7 - name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) => 0  // name binding => use the name later(here)
    case Cons(1, rest @ Cons(2, _)) => 0 // name binding inside nested patterns
  }

  // 8 - multi-patterns
  val multipattern = aList match {
    case Empty | Cons(0, _) => 0 // compound pattern (multi-pattern)
    case _ => 0
  }

  // 9 - if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 => 0
  }

  val anything: Any = new RuntimeException
  anything match {
    case _: RuntimeException | _:NullPointerException => ""
  }

  // ALL.

  /*
    Question.
   */

  val numbers = List(1,2,3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => ""
  }

  println(numbersMatch) // a list of strings
  // JVM trick question
}
