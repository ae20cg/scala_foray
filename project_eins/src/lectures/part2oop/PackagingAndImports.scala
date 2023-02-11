package lectures.part2oop

import java.util.Date
import java.sql.{Date => sqlDate}
object PackagingAndImports extends App {

  sayHello
  println(SPEED_OF_LIGHT)

  val date = new Date
  val sqlDate = new sqlDate(2022, 2, 11)


  // Default import
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Preddeff - println, ???



}
