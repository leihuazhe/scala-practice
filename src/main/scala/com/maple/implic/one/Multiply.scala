package com.maple.implic.one

import scala.language.implicitConversions

/**
  *
  * @param m
  * @param n
  */
case class Multiply(m: Int, n: Int) {


  def multiply(other: Multiply): Multiply = {
    Multiply(other.m * m, other.n * n)
  }

}

object MultiplyImplicit {
  implicit def int2Multiply(n: Int): Multiply = Multiply(n, 2)

  implicit def int2Multiply2(n: Int): Multiply = Multiply(n, 3)
}

