package com.maple.parameterization

/**
  *
  * @author <a href=mailto:leihuazhe@gmail.com>maple</a> 
  * @since 2018-10-18 2:26 PM
  */
class Person {

  def setName(): this.type = {
    println("setName")
    this
  }

  def setAge(): this.type = {
    println("setAge")
    this
  }
}

class Boy extends Person {

  def addGender(): Boy = {
    println("addGender")
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
object Person {
  def main(args: Array[String]): Unit = {
    val person = new Person
    person.setAge().setName()

    val boy = new Boy
    //    boy.addGender().setAge().setName()
    val boy1: boy.type = boy.setName()


    boy.setName().setAge().addGender()


  }
}
