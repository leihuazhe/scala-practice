package com.maple.implic

/**
  * 隐式视图
  * 隐式转换为目标类型：把一种类型自动转换到另一种类型
  */
class ImplicitViews {

  def foo(msg: String): Unit = {
    println(s"打印内容: $msg")
  }

}


object ImplicitViewsMain {

  implicit def intToString(x: Int) = x.toString

  def main(args: Array[String]): Unit = {
    val implicitViews = new ImplicitViews
    implicitViews.foo(2)


  }
}

/**
  * 隐式转换调用类中本不存在的方法
  */
class SwingType {
  def wantLearned(sw: String): Unit = println("兔子已经学会了" + sw)
}

object swimming {
  implicit def learningType(s: AnimalType) = new SwingType
}

class AnimalType

/**
  * 编译器在rabbit对象调用时发现对象上并没有wantLearning方法，此时编译器就会在作用域范围内查找能使其编译通过的隐式视图，
  * 找到learningType方法后，编译器通过隐式转换将对象转换成具有这个方法的对象，之后调用wantLearning方法
  *
  * 可以将隐式转换函数定义在伴生对象中，在使用时导入隐式视图到作用域中即可（如例4的learningType函数）
  *
  */
object AnimalType extends App {

  import com.maple.implic.swimming._

  val rabbit = new AnimalType

  rabbit.wantLearned("breaststroke") //蛙泳
}


/**
  * 还可以将隐式转换函数定义在包对象中，同样在使用时导入作用域即可，如例4
  */
/**
  * 像intToString，learningType这类的方法就是隐式视图，通常为Int => String的视图，定义的格式如下：
  * implicit def  originalToTarget (<argument> : OriginalType) : TargetType
  * 其通常用在于以两种场合中：
  * 1.如果表达式不符合编译器要求的类型，编译器就会在作用域范围内查找能够使之符合要求的隐式视图。如例2，当要传一个整数类型给要求是字符串类型参数的方法时，在作用域里就必须存在Int => String的隐式视图
  *
  * 2.给定一个选择e.t，如果e的类型里并没有成员t，则编译器会查找能应用到e类型并且返回类型包含成员t的隐式视图。如例3
  */
package swimmingPage {

  object swimming {
    implicit def learningType(s: AnimalType) = new SwingType //将转换函数定义在包中
  }

}

object AnimalTypeMain2 extends App {

  import com.maple.implic.swimmingPage.swimming._ //使用时显示的导入
  val rabbit = new AnimalType
  rabbit.wantLearned("breaststroke") //蛙泳
}

