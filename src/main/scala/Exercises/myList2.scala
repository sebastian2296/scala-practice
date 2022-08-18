package Exercises

  // Expand MyList to be generic
abstract class MyList[+A] {
  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) => new list with this element added
    toString => a string representation of the list
   */

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  // polymorphic call
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object empty extends MyList[Nothing] {

  def head: Nothing  = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new cons(element, empty)
  def printElements: String = ""
}

class cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new cons(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"
}

  object ListTest2 extends App {
    val listOfIntegers: MyList[Int] = new cons(1, new cons(2, new Cons(3, empty)))
    val listOfStrings: MyList[String] = new cons("Hello", new cons("Scala", empty))

    println(listOfIntegers.toString)
    println(listOfStrings.toString)
  }


