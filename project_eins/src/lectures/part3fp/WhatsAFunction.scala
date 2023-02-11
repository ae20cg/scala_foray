package lectures.part3fp

object WhatsAFunction extends App {

  // DREAM: use functions as first class elements
  // problem: OOP

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element^2
  }

  println(doubler(2))

  val stringToIntConverterCuber = new Function1[String, Int] {
    override def apply(element: String): Int = {
      element.toInt ^ 3
    }
  }

  println(stringToIntConverterCuber("4"))

  val adder: ((Int, Int) => Int) = new Function2[Int, Int,Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  println(adder(10, 20))

  // Function Types Function2[A, B, R] = (A,B) => R

  // ALL SCALA FUCNTIONS ARE OBJECTS

  /*
  Exercises:
  1. Take 2 strings and concatenate them
  2. transform the MyPredicate and MyTransformer into function types
  3. Define a function which takes an int and returns another function which takes an int and returns an int
      - whats the type of this function
   */

  // 1.
  val concatString: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(concatString("string", "crazy"))

  // 2. Implemented in MyList.scala

  // 3.
  val intModeler: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = intModeler(3)
  println(adder3(4))
  print(intModeler(3)(4)) // curried function



}


trait MyFunction[A ,B] {
  def apply(element: A): B
}