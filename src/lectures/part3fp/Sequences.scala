package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  /*
     Sequences

     trait Seq[+A] {
      def head: A
      def tail: Seq[A]
     }

     A (very) general interface for data structures that have:
     1. a well defined order
     2. can be indexed

     Supports various operations:
     - apply, iterator, length, reverse for indexing and iterating
     - concatenation, appending, prepending
     - map, flatMap, filter, grouping, sorting, zipping, searching, slicing.

   */

  val aSequence: Seq[Int] = Seq(1,2,3,4)
  println(aSequence) // List(1,2,3,4)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5,6,7))
  println(Seq(2,3,4,1).sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println) // prints numbers from 1 to 10

  val anotherRange: Seq[Int] = 1 until 10
  anotherRange.foreach(println) // prints numbers from 1 to 9

  /*
    List:

    sealed abstract class List[+A]
    case object Nil extends List[Nothing]
    case class ::[A](val hd: A, val tl: List[A]) extends List[A]

    It is LinearSeq immutable linked list
    - head, tail, isEmpty methods are fast: O(1)
    - most operations are O(n): length, reverse

    It has two subtypes:
     - object Nil (empty)
     - class ::
   */

  val aList = List(1,2,3)
  val prepended = 42 :: aList
  println(prepended)
  val prependAndAppend = 42 +: aList :+ 89
  println(prependAndAppend)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-|-")) // 1-|-2-|-3

  /*
     Array:

     final class Array[T] extends java.io.Serializable with java.lang.Cloneable

     They are equivalent of simple Java arrays
     - can be manually constructed with predefined lengths
     - can be mutated(updated in place)
     - are interoperable with Java's native Arrays
     - indexing is fast
   */


  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3) // Array of type Int and Size 3
  threeElements.foreach(println)


  /*
    update method is also special method in Scala.
    It is mainly used with mutable collections.
  */
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" ")) // 1 2 0 4

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq) // WrappedArray(1, 2, 0, 4)

  /*
    Vector

    final class Vector[+A]

    The default implementation for immutable sequences
    - effectively constant indexed read and write: O(log32(n))
    - fast element addition: append/prepend
    - implemented as a fixed-branch trie(branch factor 32)
    - good performance for large sizes
   */

  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vector vs list

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {

    val r = new Random()

    val times = for{
      it <- 1 to maxRuns
    } yield {
      val startTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - startTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // advantage - keeps reference to tail
  // disadvantage- updating an element in the middle takes long time
  println(getWriteTime(numbersList))

  // depth of the tree is small
  // needs to replace an entire 32-element chunk.
  println(getWriteTime(numbersVector))

}
