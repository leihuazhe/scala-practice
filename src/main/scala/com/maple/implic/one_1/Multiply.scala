package com.maple.implic.one_1

import scala.language.implicitConversions

/**
  *
  * @param m
  * @param n
  */
class Multiply(val m: Int, val n: Int) {


  def multiply(other: Multiply): Multiply = {
    Multiply(other.m * m, other.n * n)
  }

  override def toString: String = s"m:$m,n:$n"

}

object Multiply {

  def apply(m: Int, n: Int): Multiply = new Multiply(m, n)


  implicit def int2Multiply(n: Int): Multiply = Multiply(n, 2)
}

