package Lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // Anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("Surprise!")
  }

  println(funnyAnimal.getClass) // This shows class Lectures.part2oop.AnonymousClasses$$anon$1 -> Scala creates an anonymous class
  /* class AnonymousClasses$$anon$1 extends Animal {
  override def eat: Unit = println("Surprise")
  } */

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help you?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
  }

  /*
  1.  Create generic trait MyPredicate[-T] that has a method to test whether a value of T passes a condition
      method test(T) => Boolean
  2. Generic trait MyTransformer[-A, B] -> Method to transform A into B -> Method transform(A) => B
  3. MyList:
    - map(MyTransformer) => MyList
    - filter(predicate) => MyList
    - flatMap(transformer from A to MyList[B] => MyList[B]

      class EvenPredicate extends MyPredicate[Int]
      class StringToIntTransformer extends MyTransformer[String, Int]

    [1, 2, 3].map(n *) = [2, 4, 6]
    [1, 2, 3, 4].filter(n % 2) = [2, 4]
    [1, 2, 3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
  */
}
