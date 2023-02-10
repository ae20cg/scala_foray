package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
  }
  class MyMap[Key, Value]


  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = {
      ???
    }
    val emptyListOfIntegers = MyList.empty[Int]
  }
  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ???
  // 2. No INVARIANCE
  class InvariantList[A]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]
  // bounded tyeps
  class Cage[A <: Animal](animal: A)
  // class Cage[A >: Animal] => supertype
  val cage = new Cage(new Dog)

  class Car
  val newCage = new Cage(new Cat)

  // expand MyList to be generic.






}
