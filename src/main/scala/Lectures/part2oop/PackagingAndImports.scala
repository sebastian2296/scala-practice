package Lectures.part2oop

import Playground.{Cinderella => Princess, PrinceCharming}

// Import everything from a package
// import Playground._

object PackagingAndImports extends App {

  // Package members are accessible by their simple name
  val writer = new Writer("Sebastian", "Espinosa", 2018)

  // Import the package
  val princess = new Cinderella

  val princess2 = new Playground.Cinderella // fully qualified name

  val princessAlias = new Princess

  // Packages are ordered in hierarchy
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // default imports
  //java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???

}
