package com.maple.parameterization

/**
  *
  * @author <a href=mailto:leihuazhe@gmail.com>maple</a> 
  * @since 2018-10-18 2:26 PM
  */

object Title


class Person2 {
  private var str: Any = _

  def set(obj: Title.type): this.type = {
    str = obj
    this
  }

  def to(arg: String): this.type = {
    str = arg
    this
  }
}


/**
  * this.type
  *
  * boy.setName() ==> boy.type
  *
  *
  *
  *
  */
object Person2Main {
  def main(args: Array[String]): Unit = {
    val person = new Person2

    person set Title to "How are you "


  }
}
