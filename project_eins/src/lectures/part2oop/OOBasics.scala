package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Andrej", 24)
  println
  person.greet("Daniel")


  val counter = new Counter(10)
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

// constructor
class Person(name: String, age: Int) {

  val x = 2

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  // If no argument is overwriting the implied argument
  def greet(): Unit = println(s"Hi, I am ${this.name}")
  // Overloading is allowed so long that the two methods do not have the same signatures

  // scala allows multiple constructors
  def this(name: String) = this(name, 0)


}

class Counter(val count: Int) {

  def inc = {
    println("Incrementing")
    new Counter(count + 1)
  } // immutability, instances are fixed and cannot be modified inside
  def dec = {
    println("Decrementing")
    new Counter(count - 1)

  }

  def inc(n: Int): Counter = {
    if (n<=0) this
    else inc.inc(n-1)
  }
  def dec(n: Int): Counter = {
    if (n<=0) this
    else dec.dec(n-1)
  }

  def print = println(count)

}


