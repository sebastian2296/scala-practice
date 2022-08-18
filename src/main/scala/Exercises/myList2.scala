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
  def map[B](transformer: MyTransformer[A, B]) : MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]
}

object empty extends MyList[Nothing] {

  def head: Nothing  = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new cons(element, empty)
  def printElements: String = ""
  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = empty
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = empty

}

class cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new cons(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"
  def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new cons(transformer.transform(h), t.map(transformer))
  def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(h)) new cons(h, t.filter(predicate))
    else t.filter(predicate)
  def ++[B >: A](list: MyList[B]): MyList[B] = new cons(h, t ++ list)

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)
}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}

  object ListTest2 extends App {
    val listOfIntegers: MyList[Int] = new cons(1, new cons(2, new cons(3, empty)))
    val listOfStrings: MyList[String] = new cons("Hello", new cons("Scala", empty))

    println(listOfIntegers.toString)
    println(listOfStrings.toString)

    /*
    1.  Create generic trait MyPredicate[-T] that has a method to test whether a value of T passes a condition
        method test(T) => Boolean
    2. Generic trait MyTransformer[-A, B] -> Method to transform A into B -> Method transform(A) => B
    3. MyList:
      - map(MyTransformer) => MyList
      - filter(predicate) => MyList
      - flatMap(transformer from A to MyList[B] => MyList[B]

        class EvenPredicate extends MyPredicate[Int]
        class StringToIntTransformer extends MyTransformer[String, Int]

      [1, 2, 3].map(n *) = [2, 4, 6]
      [1, 2, 3, 4].filter(n % 2) = [2, 4]
      [1, 2, 3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
    */
    println(listOfIntegers.map(new MyTransformer[Int, Int] {
      override def transform(elem: Int): Int = elem * 2
    }).toString)

    println(listOfIntegers.filter((new MyPredicate[Int] {
      override def test(elem: Int): Boolean = elem % 2 == 0
    })).toString)

    val anotherListOfIntegers: MyList[Int] = new cons(4, new cons(5, empty))

    println(listOfIntegers ++ anotherListOfIntegers)
    println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] =
      new cons(elem, new cons(elem + 1, empty))
    }).toString)

  }


