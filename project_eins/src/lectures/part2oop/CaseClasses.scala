package lectures.part2oop

object CaseClasses extends App {

  /*
  equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  val jim = new Person("Jim", 34)
  println(jim.toString)
  println(jim)

  // 3. Equals and hasCode implemented with case class

  val jim2 = new Person("Jim", 34)

  println(jim == jim2)

  // 4. Copy methods
  val jim3 = jim.copy(age=45)
  println(jim3)

  // 5. Case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. Case classes are serializable

  // 7. Case classes have extractor patterns = CCs can be used in Pattern Matching

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  print(UnitedKingdom)

}
