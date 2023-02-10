package lectures.part2oop

object Objects {

  // Scala does not have class level functionality ("static")
  object Person {
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    // instance-level functionality

  }

  def main(args: Array[String]): Unit = {

    // Companions
    println(Person.N_EYES)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    val bobbie = Person(mary, john)
    println(bobbie)

    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit
    //
  }


}
