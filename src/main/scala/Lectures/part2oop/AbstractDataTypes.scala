package Lectures.part2oop

object AbstractDataTypes extends App {
  //  abstract: unimplemented fields in a class

  abstract class Animal { // An abstract class cannot be instantiated
    val creatureType: String = "Wild"
    def eat: Unit
  }

  // We define the attributes/methods in Dog class (that inherits from the Animal class)
  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("Yummy!")
  }

  // traits

  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating a ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile

  croc.eat(dog)

  //traits vs abstract classes (both support abstract and non abstract methods/fields)
  // What's the difference?

  // 1. Traits do not have constructor parameters
  // 2. You can extend just one class but use multiple traits by the same class
  // 3. Traits are for behaviors, abstract classes are for types of things




}
