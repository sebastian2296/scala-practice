package Lectures.part1basics

object CallByNameAndValue extends App {
  def calledByValue(x: Long): Unit = {
    println("By Value: " + x)
    println("By Value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println ("By Name: " + x)
    println ("By Name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  // By value evaluates nanoTime at the start of the function call and preserves it throughout all the computations
  // By name evaluates nanoTime each time it's called within the function, hence evaluating to different values in each call
  // Delays the evaluation of the parameter until is used

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  printFirst(34, infinite())
}
