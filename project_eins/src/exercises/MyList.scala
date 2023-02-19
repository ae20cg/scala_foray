package exercises

//import ScalaAndFunctionalProgrammingEssentials.{MyTransformer, MyPredicate}


abstract class MyList[+A] {
  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = is this list empty (bool)
    add(int) => new list with this element added
    toString => a string representation of the list
   */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

  // hofs
  def forEach(f: A => Unit): Unit

//  sort function ((A, A) => Int) => MyList
  def sort(compare: (A, A) => Int): MyList[A]

  def zipWith[B,C](list: MyList[B], zip:(A,B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  // Higher order functions
  def map[B](transformer: Nothing => B): MyList[B] = Empty

  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  // hofs

  def forEach(f: Nothing => Unit): Unit = ()

  def sort(compare: (Nothing, Nothing) => Int) = Empty

  def zipWith[B,C](list: MyList[B], zip:(Nothing, B) => C): MyList[C] =
    if (!list.isEmpty) throw new RuntimeException("List do not have the same length")
    else Empty

  def fold[B](start: B)(operator: (B, Nothing) => B): B = start

}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
  def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }
  def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }
  //hofs
  def forEach(f: A => Unit): Unit = {
    f(h)
    t.forEach(f)
  }

  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }
    val sortedTail = t.sort(compare)
    /*
      Illustrate what happens. Recursive function.

      1. t.sort(compare) : t = [2,3]
        1a. t.sort(compare): t = [3]
          1aa. t.sort(compare): t = []

     2. sortedTail = [] from 1aa
        2a. sortedTail = [3]


     */
    println("Sorted tail")
    println(sortedTail)
    println("H")
    println(h)
    insert(h , sortedTail)
  }

  def zipWith[B,C](list: MyList[B], zip: (A,B) => C): MyList[C] =
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))


  /*
  [1,2,3].fold(0)(+) =
  [2,3].fold(1)(+) =
  [3].fold(3)(+) =
  6
   */
  def fold[B](start: B)(operator: (B,A) => B): B =
    t.fold(operator(start, h))(operator)
}


object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val newListOfIntegers = listOfIntegers.add(10)
  println(newListOfIntegers)
  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("World", Empty))

  println(listOfStrings.toString)
  println(listOfIntegers.toString)

//  println(listOfIntegers.map(new Function1[Int, Int] {
//    override def apply(element: Int): Int = (element*3)
//  }).toString)

  println(listOfIntegers.map(elem => elem * 2).toString)



//  println(listOfIntegers.filter(new Function1[Int, Boolean] {
//    override def apply(element: Int): Boolean = (element % 2) == 0
//  }))

  println(listOfIntegers.filter(elem => elem % 2 == 0).toString)

  println(listOfIntegers ++ anotherListOfIntegers)
//  println(listOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
//    override def apply(element: Int): MyList[Int] = new Cons(element, new Cons(element + 1, Empty))
//  }).toString)


  // These lambda functions are shortened versions of the above call
  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons(elem + 1, Empty))).toString)

  println(cloneListOfIntegers == listOfIntegers)

  // test foreach
  listOfIntegers.forEach(x => println(x))
  //or
  listOfIntegers.forEach(println)

  // test sort
  println(listOfIntegers.sort((x, y) => y - x))

  println(anotherListOfIntegers.zipWith[String, String](listOfStrings, _ + "-" + _))

  println(listOfIntegers.fold[Int](0)(_ + _))

}
