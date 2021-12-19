package exercises

import scala.annotation.tailrec

object OOBasicsExercises extends App {

  val author = new NovelWriter("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  val imposter = new NovelWriter("Charles", "Dickens", 1812)

  println(novel.authorAge()) // 49
  println(novel.isWrittenBy(author)) // true
  println(novel.isWrittenBy(imposter)) // false

  val counter = new Counter()
  counter.inc().print()
  counter.inc().inc().inc().print()
  counter.inc(10).print()

}


/*
    Novel and a Writer

    Writer: first name, surname, year of birth
      - method: fullname

    Novel: name, year of release, author
      - authorAge
      - isWrittenBy(author)
      - copy(new year of release) = new instance of Novel
 */


/*
    Counter class
      - receives an int value
      - method current count
      - method to increment/decrement => new Counter
      - overload inc/dec to receive an amount
 */


class NovelWriter(firstName: String, lastName: String, val yearOfBirth: Int){

  def fullName(): String = s"$firstName $lastName"

}


class Novel(name: String, yearOfRelease: Int, novelWriter: NovelWriter){

  def authorAge(): Int = yearOfRelease - novelWriter.yearOfBirth

  def isWrittenBy(author: NovelWriter): Boolean = novelWriter == author

  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, novelWriter)

}


class Counter(val cnt: Int = 0){

  def inc(): Counter = {                              // immutability
    println("Incrementing")
    new Counter(cnt + 1)
  }

  def dec(): Counter = {
    println("Decrementing")
    new Counter(cnt - 1)
  }

  @tailrec
  final def inc(amount: Int): Counter = {

    if(amount <= 0) this
    else inc().inc(amount - 1)

  }

  @tailrec
  final def dec(amount: Int): Counter = {

    if(amount <= 0)this
    else dec().dec(amount - 1)
  }

  def print(): Unit = println(cnt)
}
