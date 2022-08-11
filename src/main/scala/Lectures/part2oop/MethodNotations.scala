package Lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, val favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck!?"
    def isAlive: Boolean = true
    def apply(): String = s"Hi my name is $name and I like $favoriteMovie"
    def +(nickname: String) : Person = new Person(s"$name $nickname", favoriteMovie)
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def learns(subject: String): String = s"$name learns $subject"
    def learnsScala: String = this learns "Scala"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"

  }

  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception"))
  println(mary likes "Inception") // This and the above are the same
  // infix notation = operator notation (just for methods with one parameter)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  println(mary.hangOutWith(tom))

  println(1 + 2)
  println(1.+(2)) // + method that takes another number as input -> infix notation for sum operator
  // All operators are methods

  // Infix notation is also known as Syntactic Sugar

  // Prefix notation -> Unary operators
  val x = -1 // equivalent to 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())

  /*
    1. Overload the + operator
    Mary + "the rockstar" => new person with name "Mary (the rockstar)

    2. Add an age to the Person class
        Add a unary + operator => new person with the age + 1
        + mary => mary with the age incremented

    3. Add a "learns" method in the person class with a string as input  => outputs "Mary learns scala"
      Add a "learnsScala" method without params that calls learns methods with "Scala"
      use it in postfix notation

    4. overload the apply method to receive a number and receive a string
      mary.apply(2) => "Mary watched inception 2 times"

  */

  println((mary + "the rockstar").apply())
  println((+mary).age)

  println(mary learnsScala)
  println(mary.apply(2))

}
