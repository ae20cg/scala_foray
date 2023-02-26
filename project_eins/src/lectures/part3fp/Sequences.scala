package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  val aSequence = Seq(1,2,3,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)

  val aRange: Seq[Int] = 1 until 10
  aRange.foreach(println)

  (1 to 10).map(x => x * 10).foreach(println)

  val aList = List(1,2,3)
  val prepended = 42 :: aList
  println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)

  println(aList.mkString("-|-"))

  val numbers = Array(1,2,3,4)
  val treeElements = Array.ofDim[String](3)

  treeElements.foreach(println)

  numbers(2) = 0
  println(numbers.mkString(" "))

  val numbersSeq: Seq[Int] = numbers

  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  val maxRuns: Int = 1000
  val maxCapacity: Int = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns

  }

  val numbersList = (1 to maxCapacity).toList

  val numbersVector = (1 to maxCapacity).toVector

  println(numbersList(10))

  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector))



}
