package lectures.part1basics

/**
 * Created by Andrej Erkelens
 *
 */
object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("go", 5))

  def aParameterLessFunction(): Int = 42
  println(aParameterLessFunction())
  println(aParameterLessFunction)

  def aRepeatedfunction(aString: String, n: Int): String = {
    if (n==1) "\n" + aString
    else aString + aRepeatedfunction(aString, n-1)
  }

  println(aRepeatedfunction("Hello", 3))

  def aFunctionWithSideEffects(aString: String): Unit = {
    println(aString)
  }

  aFunctionWithSideEffects("HelloWORLD")

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a:Int, b:Int): Int = a + b
    aSmallerFunction(n, n-1)
  }

  /*
    1. A greeting funciton (name, age) => "Hi, my name is $name and I am $age years old"
   */

  def aGreetingFunction(name: String, age: Int): Unit = {
    println("Hello my name is " + name + " and I am " + age + " years old.")
  }

  def aFactorial(n: Int): Long = {
    if (n<=0) 1
    else n * aFactorial(n-1)
  }

  val factTest: Long = aFactorial(20)
  println(factTest)

  val maxLong: Long = 9223372036854775807L

  def fibonacci(n: Int): Int = {
    if (n<=2) 1
    else fibonacci(n-1) + fibonacci(n-2)
  }





}
