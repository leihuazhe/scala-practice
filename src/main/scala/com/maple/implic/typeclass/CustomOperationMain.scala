package com.maple.implic.typeclass

import com.maple.implic.typeclass.CustomOperation._


/**
  *
  * @author <a href=mailto:leihuazhe@gmail.com>maple</a> 
  * @since 2018-10-17 6:09 PM
  */
object CustomOperationMain {


  def main(args: Array[String]): Unit = {

    val str: String = "maple".plus("<", ">")

    println(str)

    val doubleValue = 5.5.multiply(2.0, 3.0)
    println(doubleValue)

  }
}
