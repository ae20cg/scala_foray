package lectures.part3fp

object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"

  val aTuple = new Tuple2[Int, String](2, "Hello Scala")
  println(aTuple)
  println(aTuple._1)
  println(aTuple.copy(_2 = "goodBye Java"))
  println(aTuple.swap)

  // Maps = Keys -> Values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), ("Daniel", 789)).withDefaultValue(-1)
  // or
  val phonebook2 = Map("Jim" -> 111, "Daniel" -> 222)
  println(phonebook2)
  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))

  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phonebook.filterKeys(x => x.startsWith("J")).toMap)
  println(phonebook.mapValues(number => "0245-" + number).toMap)

  val tMap = Map("Jim" -> 555, "JIM" -> 900, "Jim" -> 600)
  println(tMap)

  /*
   1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900
   2. Overly simplified social netwrok bsaed on maps
      Person = String
      - add a person to the network
      - remove
      - unfriend
      - number of a friends of a given person
      - person with most friends
      - how many people have no friends
      - if there is a social connection between two people
   */
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())
  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))
}
