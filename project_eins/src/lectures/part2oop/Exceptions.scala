package lectures.part2oop

// Skipped some of the exercises as they are fairly straight forward

object Exceptions extends App {

//  val x: String = null
//  println(x.length) // This will cause a null pointer exception

//  val aWeirdValue = throw new NullPointerException

  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42
  }

  try {
    getInt(true)
  }
  catch {
    case e: RuntimeException => println("Caught a runtime exception.")
  } finally {
    // code that will get executed no matter what
    println("finally")
  }

  /*

  Exercises:
  1. Crash program with OOM
  2. Crash with SOE
  3. PocketCalculator
   */

  // 1. OOM

//  val array = Array.ofDim(Int.MaxValue)

  // 2. SOE
//  def infinite: Int = 1 + infinite
//  val noLimit = infinite

  // 3.
  val pc = new PocketCalculator
  println(pc.add(1,2))



}

class OverflowException extends RuntimeException
class UnderflowException extends RuntimeException
class PocketCalculator {
  def add(e1: Int, e2: Int): Int = {
    val result = e1 + e2
    if (e1 > 0 && e2 > 0 && result < 0) throw new OverflowException
    else if (e1 < 0 && e2 < 0 && result > 0) throw new OverflowException
    else result
  }
  def subtract(e1: Int, e2: Int): Int = {
    val result = e1 - e2
    if (e1 > 0 && e2 < 0 && result < 0) throw new OverflowException
    else if (e1 < 0 && e2 > 0 && result > 0) throw new UnderflowException
    else result
  }

//  def multiply(e1: Int, e2: Int): Int = {
//    val result = e1 * e2
//  }
}