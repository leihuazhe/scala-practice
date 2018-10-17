package com.maple.implic.one


object MultiplyMain {

  import com.maple.implic.one.MultiplyImplicit.{int2Multiply ⇒ _, _}

  def main(args: Array[String]): Unit = {
    val x: Multiply = 3.multiply(Multiply(2, 1))

    println(x.toString)

  }
}
