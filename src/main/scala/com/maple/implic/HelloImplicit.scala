package com.maple.implic

import com.maple.implic.ImplicitFunc.int2Person

class HelloImplicit {
  val x: BigDecimal = BigDecimal(2) + 2


  def get(): Person = 4

  /**
    * 隐式值
    *
    * @param name
    */
  def implicitHello(implicit name: String): String = {
    println(s"sayHello $name")
    name
  }

  def implicitly[T](implicit e: T) = e

}

class LogClass {
  def wrap[T](implicit f: T): T = {
    println(s"log for process f : $f")
    f
  }
}

class World {

  def hello(name: String) = {
    s"你好: $name"
  }

}

object Main {

  def main(args: Array[String]): Unit = {
    implicit val name = "maple"

    val hello = new HelloImplicit
    val person: Person = hello.get()

    println(person)

    val s = hello.implicitHello
    println(s"s=> $s")

  }
}
