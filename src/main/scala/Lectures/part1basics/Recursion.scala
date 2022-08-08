package Lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int =
    if (n>1) {
      println("Computing factorial of " + n + " - I need factorial of " + (n-1))
      val result: Int =  n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    } else n

  println(factorial(10)) // This works for iterating over small numbers, but with bigger numbers this generates a stackoverflow

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator) // Tail recursion = use recursive call as the last expression

    factorialHelper(n, 1)
    }
  println(anotherFactorial(5000))

  // When you need loops, use tail recursion

  /*
  1. Func that concatenates n times with tail recursion
  2. IsPrime function tail recursive
  3. Fibonacci function, tail recursive
  */

  @tailrec
  def ConcatenateTail(s: String, n: Int, accumulator: String): String =
    if (n>1) ConcatenateTail(s, n-1, accumulator + s)
    else accumulator


  println(ConcatenateTail("Hello", 3, ""))


  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTail(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTail(t - 1, n % t != 0 && isStillPrime)

    isPrimeTail(n / 2, true)
  }
  println(isPrime(2003))

  def fibonacciTail(n: Int): Int = {
    def fibonacciHelper(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fibonacciHelper(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else (fibonacciHelper(2, 1, 1))
  }

  println(fibonacciTail(8))

}
