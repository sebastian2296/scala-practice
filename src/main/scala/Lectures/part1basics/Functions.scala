package Lectures.part1basics

object Functions extends App {
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }
  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int) : String = {
    if (n==1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("Hello", 3))

  // WHEN YOU NEED LOOPS USE RECURSION

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n-1)
  }

  println(aBigFunction(2))

  /*
  1. A greeting function (name, age) => Hi my name is $name and I am $age years old
  2. Factorial function 1 * 2 * 3 ... * n
  3. Fibonacci function f(1) = 1, f(2) = 1, f(n) = f(n-1) + f(n-2)
  4. Tests if a number is prime
  */

  def introduction(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old"
  }

  println(introduction("Sebastián", 26))

  def Factorial(n: Int): Int = {
    if (n>1) n * Factorial(n - 1) else n
  }

  println(Factorial(8))

  def Fibonacci(n: Int): Int = {
    if (n<=2) 1
    else Fibonacci(n-1) + Fibonacci(n-2)
  }

  println(Fibonacci(3))
  def is_prime(n: Int): Boolean = {
    if (n % 2 == 0) false else true
  }

  println(is_prime(1))
}
