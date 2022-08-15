package Lectures.part2oop

import java.time.DayOfWeek

object InheritanceAndTraits {
  def main(args: Array[String]): Unit = {

    // single class inheritance
    class Animal {
      val creatureType = "Wild"
      /*private*/ /*protected*/ /*final*/ def eat = println("Yummy!")
    }

    class Cat extends Animal {
      def crunch = {
        eat // Protected allows the use of the eat method withing the crunch method
            // But it's not accessible outside the subclass (As with the private method)
        println("Crunch")
      }
    }

    val cat = new Cat
    cat.crunch

    // Constructors
    class Person(name: String, age: Int)
    class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

    // overriding
    class Dog(override val creatureType: String /*Overrides val in the constructor*/) extends Animal {
      override def eat = {
        super.eat
        println("asdfuhmmm")
      }
    }

    val dog = new Dog("K9")
    dog.eat
    println(dog.creatureType)

    // Type substitution (broad: polymorphism)

    val unknownAnimal: Animal = new Dog("K9")
    unknownAnimal.eat

    // Distinction between overriding (supply different implementation in derived classes) and overloading (multiple methods with different signatures but with the same name within the same class)

    // super: used to refer to a method or attribute from a parent class

    // preventing overrides
    // 1. use "final" on member
    // 2. use "final" on class
    // 3. "sealed" the class = allows extend classes in this file, but prevents extension in other files









  }

}
