package com.maple.parameterization

/**
  *
  * @author <a href=mailto:leihuazhe@gmail.com>maple</a> 
  * @since 2018-10-18 2:50 PM
  */
class TypeOfProjection {

}

/**
  * Created by hlf on 2016/8/9 for learn TypeProjection.
  * 类型投影主要用在有外部类和内部类，并且外部类有方法是需要传入内部类作
  * 参数的时候用的，而这个传入的参数要求除了可以是自己这个对象的内部类，
  * 也可以是其他实例对象的内部类，只要都是实例化这个类就行了。
  */
object TypeProjection extends App {

  val outter1 = new OutterClass

  outter1.setName("电脑")

  val inner1 = new outter1.InnerClass

  inner1.setName("主机")

  println(outter1)

  val outter2 = new OutterClass

  outter2.setName("洗衣机")

  val inner2 = new outter2.InnerClass

  inner2.setName("滚筒")

  println(outter2)
  println("==============无类型投影=================")

  //如果我想把洗衣机的滚筒这个内部类放到电脑这里的getInner方法里
  outter1.setInner(inner1) //放自己的没问题，也没意义的样子
  //outter1.getInner(inner2)会报错，提示不匹配
  println("==============类型投影=================")
  outter1.setInner2(inner2) //新添加一个类型投影就可以了

}

/**
  * 外部类,内部类其实是外部类的一个成员，不像JAVA一样
  */
class OutterClass {
  outter =>
  var name: String = _

  def setName(getname: String): Unit = {
    this.name = getname
  }

  def setInner(innerClass: InnerClass) = {
    println("innerClass'name is " + innerClass.name) //调用内部类成员
    println("I'm a " + name + "!!!I'm aloof")
  }

  def setInner2(innerClass: OutterClass#InnerClass) = {
    println("innerClass'name is" + innerClass.name) //调用内部类成员
    println("I'm a " + name + " !!!I'm aloof")
  }

  /**
    * 内部类
    */
  class InnerClass {
    inner =>
    var name: String = _

    def setName(getname: String): Unit = {
      this.name = getname
    }

    def say: Unit = {
      println("outterClass is  " + outter.name) //调用外部类成员
      print("I'm a Innerclass!!!I'm proud")
    }
  }

  //这里想把内部类名字也写上的，但是水平有限调不出来 :(
  override def toString: String = "outterClass is: " + name
}
