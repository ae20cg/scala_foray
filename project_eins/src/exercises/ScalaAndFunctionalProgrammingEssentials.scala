package exercises

object ScalaAndFunctionalProgrammingEssentials {

  trait MyPredicate[-T] {
    def test(element: T): Boolean
  }
  trait MyTransformer[-A, B] {
    def transform(element: A): B
  }

}
