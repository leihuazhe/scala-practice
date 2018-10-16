package com.maple.implic

/**
  * 在scala2.10后提供了隐式类，可以使用implicit声明类，但是需要注意以下几点：
  * 1.其所带的 构造参数 有且只有一个
  * 2.隐式类必须被定义在类，伴生对象和包对象里
  * 3.隐式类不能是case class（case class在定义会自动生成伴生对象与2矛盾）
  * 4.作用域内不能有与之相同名称的标示符
  */
class ImplicitClass {

}

object StringUtils {

  implicit class StringImprovement(val x: String) {
    def increment = x.map(s ⇒ (s + 1).toChar)
  }

}

/**
  * 编译器在 mobin 对象调用increment时发现对象上并没有increment方法
  * 此时编译器就会在作用域范围内搜索隐式实体，
  * 发现有符合的隐式类可以用来转换成带有 increment方法的StringImprovement类，
  * 最终调用increment方法。
  */
object StringUtilsMain {

  def main(args: Array[String]): Unit = {
    import com.maple.implic.StringUtils._
    println("mobin".increment)
  }
}

/*
隐式转换的时机：

1.当方法中的 参数的类型 与目标类型不一致时


2.当对象调用类中 不存在的方法或成员 时，编译器会自动将对象进行隐式转换




 */