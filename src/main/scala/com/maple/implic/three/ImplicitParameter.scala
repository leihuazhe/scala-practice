package com.maple.implic.three

object ImplicitParameter {

  def smaller[T](a: T, b: T)(implicit order: T ⇒ Ordered[T]): T = {
    if (order(a) < b) a else b
  }

  /**
    * converts a T to an Ordered[T]
    */
  def maxListUpBound[T <: Ordered[T]](elements: List[T]): T = {
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListUpBound(rest)
        if (x > maxRest) x
        else maxRest
    }
  }

  def maxListUpBound2[T](elements: List[T])(implicit orders: T ⇒ Ordered[T]): T = {
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListUpBound2(rest)
        if (x > maxRest) x
        else maxRest
    }
  }


}

object ImplicitParameter2 {

  import com.maple.implic.three.ImplicitParameter._

  def main(args: Array[String]): Unit = {

    val i = smaller(2, 10)

    println(i)

    val result = maxListUpBound2(List[Int](1, 2, 3))

    println(result)


  }
}

case class Person(age: Int)
