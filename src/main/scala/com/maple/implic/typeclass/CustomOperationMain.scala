package com.maple.implic.typeclass

/**
  *
  * @author <a href=mailto:leihuazhe@gmail.com>maple</a> 
  * @since 2018-10-17 6:09 PM
  */
object CustomOperationMain {

  implicit class CustomImplicitClass[T: CustomOperation](v: T) {

    def multiply(x: T, y: T): String = {
      val custom = implicitly[CustomOperation[T]]
      custom.multiply(v, x) + custom.multiply(v, y).toString
    }

    def plus(x: T, y: T): String = {
      val custom = implicitly[CustomOperation[T]]
      custom.plus(v, x) + custom.plus(v, y).toString
      //      custom.plus(x, y)
    }
  }


  def main(args: Array[String]): Unit = {
    //    import com.maple.implic.typeclass.CustomOperation._

    val str: String = 3.5.plus(2.2, 3.3)

    println(str)


  }
}
