package com.maple.implic.one_1

object MultiplyMain {

  import com.maple.implic.one_1.Multiply._

  def main(args: Array[String]): Unit = {
    val x: Multiply = 3.multiply(Multiply(2, 1))

    println(x.toString)

  }
}
