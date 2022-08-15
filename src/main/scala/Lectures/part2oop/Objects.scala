package Lectures.part2oop

object Objects  {
  // Class level functionality -> Access funcs/methods from a class without instantiating it
  // Scala does not have class-level functionality (Does not know the concept of "static")
  // it has objects

  object Person { // We define its type + its' only instance
    // "static"/class-level functionality
    val N_EYES = 2 // This is how Scala implements class-level functionality
    def canFly: Boolean = false

    // Factory method
    def apply(mother: Person, Father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) { // We can define a class in the same scope as well
    // Instance-level functionality

  }

  // Pattern of writing objects and classes with the same name in the same scope is called COMPANIONS
  def main(args: Array[String]): Unit = {

    println (Person.N_EYES)
    println (Person.canFly)

    // A Scala object is a singleton instance
    val mary = new Person ("Mary")
    val john = new Person ("John")

    println (mary == john) // These objects  don't point to the same instance, they are two different instances that point to different locations

    val person1 = Person
    val person2 = Person

    println (person1 == person2) // These objects point to the same instance, the object Person

    val bobby = Person (mary, john)
    println (bobby.name)

    // Scala applications -> Scala object with an important method
    // def main(args: Array[String]: Unit

  }
}
