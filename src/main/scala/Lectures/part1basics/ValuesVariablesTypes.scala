package Lectures.part1basics

object  ValuesVariablesTypes  extends App {
  val x: Int = 42
  println(x)
  // VALS ARE IMMUTABLE
  // COMPILER CAN INFER TYPES

  val aString: String = "Hello"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613 // Up to 2 bytes of representation
  val aLong: Long = 5299992211020333443L
  val aFloat: Float = 2.0f
  val aDouble: Double = 2.0

  // Variables

  var aVariable: Int = 4
  aVariable = 5 // side effects

}
