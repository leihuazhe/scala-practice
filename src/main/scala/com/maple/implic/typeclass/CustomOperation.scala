package com.maple.implic.typeclass

/**
  *
  * @author <a href=mailto:leihuazhe@gmail.com>maple</a> 
  * @since 2018-10-17 5:50 PM
  */
trait CustomOperation[T] {
  def plus(x: T, y: T): T

  def multiply(x: T, y: T): T


}

object CustomOperation {

  implicit object StringCustomOperation extends CustomOperation[String] {
    override def plus(x: String, y: String): String = x + y


    override def multiply(x: String, y: String): String = x + "*" + y
  }

  implicit object DoubleCustomOperation extends CustomOperation[Double] {
    override def plus(x: Double, y: Double): Double = x + y

    override def multiply(x: Double, y: Double): Double = x * y
  }


}
