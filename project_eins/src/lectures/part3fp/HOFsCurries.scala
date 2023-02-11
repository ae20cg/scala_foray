package lectures.part3fp

object HOFsCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  // Int + Function2 // chunk 0
  //       String + Function1     \\\\ chunk 1
  //                Int => Boolean ////  chunk 1
  // chunk0 + chunk1 both of type int to return int

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n<=0) x
    else nTimes(f, n-1, f(x))
  val plusOne = (x: Int) => x + 1

  println(nTimes(plusOne, 10, 1))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n<=0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

  val plusTen = nTimesBetter(plusOne, 10)
  println(plusTen)
  println(plusTen(1))

  // curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)
  println(add3(10))

  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(math.Pi))
  println(preciseFormat(math.Pi))

  /*
    1. Expand MyList
        - foreach method A => Unit
        [1,2,3].foreach(x => println(x)) // should print each element on a new line

        - sort function ((A, A) => Int) => MyList
        [1,2,3].sort((x,y) => y - x) => [3,2,1]

        - zipWith (list, (A, A) => B) => MyList[B]
        [1,2,3].zipWith([4,5,6], x*y) => [4, 10, 18]

        - fold(start)(function) => a value
        [1,2,3].fold(0)(x + y) = 6

    2. toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
       fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int

    3. compose(f, g) => x => f(g(x))
       andThen(f,g) => x => g(f(x))
   */
}