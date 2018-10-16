package com.maple.implic

/**
  * 隐式值
  */
class ImplicitValues {

  def person(implicit name: String): Unit = {
    println(s"获取隐式值name: $name")
  }
}

/**
  * 因为将p变量标记为implicit，所以编译器会在方法省略隐式参数的情况下去搜索作用域内的隐式值作为缺少参数。
  * 但是如果此时你又在REPL中定义一个隐式变量，再次调用方法时就会报错
  * notice
  * 匹配失败，所以隐式转换必须满足无歧义规则，在声明隐式参数的类型是最好使用特别的或自定义的数据类型，不要使用Int,String这些常用类型，避免碰巧匹配
  */
object ImplicitValuesMain {

  def main(args: Array[String]): Unit = {
    implicit val name: String = "maple"
    val implicitValues = new ImplicitValues
    implicitValues.person


  }
}