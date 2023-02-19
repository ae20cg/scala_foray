package lectures.part3fp

import exercises.{Cons, MyList, Empty}

object MapFlatmapFilterFor extends App {

  val list = List(1,2,3)
  println(list)
  println(list.head)
  println(list.tail)

  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  println(list.filter(_ % 2 == 0))

  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // print all combinations between two lists

  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  // iterations
  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

  // foreach
  combinations.foreach(println)

  // for-comprehensions --> more readable than chaining together funcitons as above.
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
  } yield "" + c + n

  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  // syntax overload

  list.map {
    x =>
      x * 2
  }

  /*

  1. MyList supports for comprehensions?
  2. Small collection of at most ONE element - Maybe[+T]
      - map, flatMap, filter
   */
  println("\nExercises")
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(listOfIntegers)

  val listOfStrings: MyList[String] = new Cons("Andrej", new Cons("Kylie", Empty))

  val combs = for {
    n <- listOfIntegers
    c <- listOfStrings
  } yield n + "-" + c

  println(combs)


}
