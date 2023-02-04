package lectures.part1basics

object ValuesVariablesTypes extends App {

  // 'val's are immutable
  // explicit type specification is not necessary, compiler can infer types
  val x: Int = 42
  println(x)

  // Strings
  val aString: String = "Hello World!"
  println(aString)

  val aBoolean: Boolean = true
  System.out.println(aBoolean) // same as java
  val aChar: Char = 'a'
  val aShort: Short = 4111 // 2 byte max int is 4 bytes
  val aLong: Long = 5010123012312312321L // 8 byte max -> need the L at the end
  val aFloat: Float = 1.2341f // Need the f at the end
  val aDouble: Double = 1.231212 // if no f -> defulat is a double

  // variables
  var aVariable: Int = 4
  aVariable = 5 // 'var's can be re-assigned

  // functional programming prefers vals over vars



}
