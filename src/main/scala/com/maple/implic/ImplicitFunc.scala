package com.maple.implic

import scala.language.implicitConversions

object ImplicitFunc {

  implicit def int2Person(x: Int): Person = Person(s"name-$x", x)


}

case class Person(name: String, age: Int)
