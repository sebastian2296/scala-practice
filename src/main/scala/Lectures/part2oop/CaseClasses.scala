package Lectures.part2oop

object CaseClasses extends App {
  /*
    Usually we need to reimplement equals for classes and companion
    equals, hasCode, toString

  */

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance,toString) // syntactic sugar
  println(jim.toString)
  println(jim)

  // 3. equals and hasCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. Case classes have handy copy methods

  val jim3 = jim.copy(age = 45)
  println(jim3.age)

  // 5. Case classes have companion objects
  val thePerson = Person // Creates the the companion Object automatically
  val mary = Person.apply("Mary", 23) // This implies that in practice we don't use the word new to instantiate a class

  // 6. Case classes are serializable
  // Akka

  // 7. Case classes have extractor patterns = can be used in pattern matching

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI" // Main difference between CO and CC is that CO don't have companion classes created automatically

  /*
  change whatever is possible in the MyList exercise to CC
  */
  }


}
