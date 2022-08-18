package Lectures.part2oop

object Generics extends App {
  class myList[+A] {
    // use type A inside class definition
    def add[B >: A](element: B): myList[B] = ???
    /*
    A = Cat
    B = Dog = Animal
    A + B = List of Animals
    */
  }
  val listOfIntegers = new myList[Int]
  val listOfStrings = new myList[String]

  class MyMap[Key, Value]

  // generic methods
  object myList {
    def empty[A]: myList[A] = ???
  }

  val emptyListOfIntegers = myList.empty[Int]

  // variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // animalList.add(new Dog) ???

  // 2. List[Cat] does not extend List[Animal] = Invariant
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. List[Cat] does not extend List[Animal] = CONTRAVARIANCE
  class ContravariantList[-A]
  val contravarianList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car // upper bounded type in animal
  // val newCage = new Cage(new Car)
  
}





