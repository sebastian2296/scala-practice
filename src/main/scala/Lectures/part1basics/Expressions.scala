package Lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // EXPRESSION -> Evaluated to a value an have a type
  println(x)
  println(2 + 3 * 4)

  println(1 == x)

  println(!(1 == x))

  var aVariable = 2

  aVariable += 3 // also works with -= *= /= -> This only works with variables (side effects)
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE &&| TYPE)

  // IF expression

  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3 // This expression gives back a value (if expression not if instruction)
  println(aConditionValue)

  // Loops (DISCOURAGED TO USE)

  var i = 0
  while(i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN

  // EVERYTHING in Scala is an Expression

  val aWeirdValue: Unit = aVariable = 3 // Unit == Void -> Doesn't return anything meaningful -> In every case a side effect will return unit -> void ()
  println(aWeirdValue)

  // The above is an example of an expression returning unit

  // side effects examples: println(), whiles, reassigning variables -> return unit

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
  println(aCodeBlock)

  // 1. What's the difference between the string "hello world" vs println("hello world") -> First is a value, second one is an expression (that evaluates to Unit)
  // 2. What's the value of: Firs code-block == true, second code-block == 239

    val someValue = {
      2 < 3
    }

    val someOtherValue = {
    if (someValue) 239 else 986
      42
  }

  println(someOtherValue)
}
