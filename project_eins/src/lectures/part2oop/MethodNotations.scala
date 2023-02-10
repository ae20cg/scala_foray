package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, age: Int = 0) {
    def likes(movie:String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = {
      new Person(s"${this.name} + $nickname", this.favoriteMovie)
    }

    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(n: Int): String = s"$name watched $favoriteMovie movie $n times"
    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation --> only application for methods with a single parameter
  // "operators" in Scala

  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))
  println((mary + "the rockstar")())
  println(1.+(2))

  // ALL OPERATORS ARE METHODS

  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-


  println(!mary)
  println(mary.unary_!)

  println(mary.isAlive)

  println(mary isAlive)

  // apply is one of those built in methods
  println(mary.apply())
  println(mary())

  println(mary learnsScala)

  println(mary())
  println(mary(10))
  /*
  Exercises
  1. Overloading the + operator
    mary + "the rockstar" => new person "Mary (the rockstar)"
  2. Add an age to the Person class
    Add a unary + operator => new person with the age + 1
    +mary => mary with the age incrementer

  3. Add a "learns" method in the Person class => "Mary learns Scala"
    Add a learnsScala method, calls "learns" method with "Scala".
    Use it in postfix notation.
  4. Overload the apply method
    mary.apply(2) => "Mary watched Inception 2 times"
   */
}
