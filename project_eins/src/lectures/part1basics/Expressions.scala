package lectures.part1basics

object Expressions extends App {
  val x = 1+2
  println(x)

  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)
  println(1+3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  var aVariable = 3
  aVariable += 3
  println(aVariable)
  // EVERYTHING IN Scala IS AN EXPRESSION!

  val aWeirdValue = (aVariable = 3) // Unit == void
  println(aWeirdValue)

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }

  println(aCodeBlock)


}
