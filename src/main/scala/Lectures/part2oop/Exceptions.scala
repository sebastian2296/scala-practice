package Lectures.part2oop

import scala.reflect.ClassTag

object Exceptions extends App {

  val x: String = null
  // println(x.length) -> This will crash with a null pointer exception

  // throwing and catching exceptions

  // 1. throwing exceptions
  // val aWeirdValue = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions?
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No Int for you!")
    else 42

  try {
    // code that might fail
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught a Runtime exception")
  } finally {
    // code that will get executed no matter what
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects (logging)
    println("Finally")

  }

  // 3. how to define your own exceptions
  class MyException extends Exception

  val exception = new MyException

  // throw exception

  /*
  1. crash your program with an OutOfMemoryError
  2. Crash with StackOverflow
  3. PocketCalculator
     - add(x,y)
     - subtract(x,y)
     - multiply(x,y)
     - divide(x,y)

      throw
      - OverflowException if add(x,y) exceeds int.MAX_VALUE
      - UnderflowException if subtract exceeds Int.MIN_VALUE
      - MathCalculatorException for division by 0

  */
  // 1. OOM error
  // val array = Array.ofDim(Int.MaxValue)

  // 2. SO

  // def infinite: Int = 1 + infinite
  // val noLimit = infinite

  // Pocket Calculator


  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if (x>0 && y>0 && result>0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y==0) throw new MathCalculationException
      else x / y
    }
  }

  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))

}
