package Lectures.part2oop

import java.io.Writer

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.age)
  person.greet("Daniel")
  person.greet()

  val writer = new Writer("Edgar", "Poe", 1844)

  println(writer.fullname())

  val novel = new Novel("The Tell-Tale Heart", 1886, writer)

  println(novel.isWrittenBy(writer))
  println(novel.authorReleaseAge)

  val new_novel = novel.copy(1832)

  println(novel.releaseYear)
  println(new_novel.releaseYear)

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print

}

// CONSTRUCTOR
class Person(val name: String, val age: Int) {
  // Classes' body

  // Method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // Overloading: creating methods with same name but different signatures
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0) // Only allowed with reserved word "This"
}

/*
Novel and writer classes

Writer: first  name, surname, year
  - Method fullname -> Concatenation of name and surname

Novel: name, year of release, author
  - authorAge Method -> age of author at year of release
  - IsWrittenBy (Author)
  - copy (new year of release) = new Instance of Novel with new year of release

*/

class Writer(val name: String, val lname: String, val bornYear: Int) {
  def fullname(): String = s"$name $lname"
}

class Novel(name: String, val releaseYear: Int, author: Writer){
  def authorReleaseAge: Int = releaseYear - author.bornYear

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

/*
  Counter class
    - Receives an int value
    - Method current count
    - method to increment/decrement -> new counter
    - overload inc/dec to receive an amount
*/

class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(count + 1)  // immutability
  }

  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter =
    if (n <= 0) this
    else dec.dec(n-1)

  def print = println(count)
}

// class parameters are not fields (cannot be accessed as attributes) unless you convert a parameter into a field
// Using "val" as a preceding word