package lectures.part3fp

object AnonymousFunctions extends App {

  // anonymous function OR lambda function
  // Lambda functions must be called with parenthesis as oopposed to methods
  val doubler: Int => Int = x => x * 2
  println(doubler(20))

  val adder: (Int, Int) => Int = (a, b) => a + b

  val justDoSomething: () => Int = () => 3

  println(justDoSomething)
  println(justDoSomething())


  val stringToInt = { (str:String) =>
    str.toInt
  }

  // MORE syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // "_ + 1" equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b


  /*
  Exercises
    1. MyList: replace all FuncitonX calls with lambdas
    2. Rewrite the "special" adder as an anonymous function
   */

  val adderAnon = (x: Int) => (y: Int) => x + y
  println(adderAnon(3)(4))
}
