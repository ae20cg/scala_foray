package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Long = {
    if (n<=1) 1
    else {
      println("Computing factorial of " + n + " - I first need the factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }
  }

  println(factorial(10))

  // WHEN YOU NEED LOOPS, USE TAIL RECURSION

  /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function, tail recursive
   */

  def concatString(aString: String, n: Int): String = {
    // if no tail recursion -> if (n==1) string else concatString(aString+aString, n-1)
    @tailrec
    def strHelper(n:Int, accumulator: String, aString: String): String = {
      if (n<1) accumulator
      else strHelper(n-1, accumulator+aString, aString)
    }
    strHelper(n, "", aString)
  }

  def regularStringRecursion(aString: String, n: Int): String = {
    if (n<=1) aString
    else aString + regularStringRecursion(aString, n-1)
  }

  println(concatString("Hello", 10))
  println(regularStringRecursion("Hello", 10))

}
