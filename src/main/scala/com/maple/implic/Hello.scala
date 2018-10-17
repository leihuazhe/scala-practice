package com.maple.implic

import java.sql.Timestamp

import akka.japi

/**
  * Created by wangzx on 2016/11/29.
  */
object Implicits {

  /**
    * "hello" in List("hello", "world")
    */
  /**
    * 隐式类
    *
    * @param v
    * @tparam T
    */
  implicit class CommonEx[T](v: T) {

    def in(seq: Seq[T]) = seq.contains(v)

    def notIn(seq: Seq[T]) = !in(seq)

  }

  /**
    * for summoning implicit values from the nether world -- TODO:
    * when dependent method types are on by default, give this result type `e.type`,
    * so that inliner has better chance of knowing which method to inline in calls like `implicitly[MatchingStrategy[Option]].zero`
    *
    * 从幽冥世界召唤 implicit values
    * 当依赖方法类型默认打开时,
    * 这样 inliner 就有更好的机会知道哪些方法可以内联调用，例如 `implicitly[MatchingStrategy[Option]].zero`
    */
  implicit class OrderedExt[T: Ordering](v: T) {

    def between(min: T, max: T) = {
      val ordering = implicitly[Ordering[T]]
      ordering.lteq(min, v) && ordering.lteq(v, max)
    }

  }

  implicit class OrderedExt2[T](v: T)(implicit ordering: Ordering[T]) {

    def between2(min: T, max: T) = {
      ordering.lteq(min, v) && ordering.lteq(v, max)
    }
  }

  /**
    * 10 between (10,20)
    *
    * def implicitly[T](implicit e: T) = e
    */

  implicit class SortedExt[T: Ordering](v: T) {

    def between1(begin: T, end: T)(implicit order: T ⇒ Ordering[T]) = {
      begin.lteq(begin, v) && end.lteq(v, end)
    }

  }


  /*implicit class SQLStringContext(sc: StringContext) {
    def sql(args: String) = sc.parts.mkString("sql")
  }*/


  implicit class SqlBooleanImplicit(b: Boolean) {

    import wangzx.scala_commons.sql._

    def default(): SQLWithArgs = sql""

    // call by name
    def optional(left: => SQLWithArgs, right: => SQLWithArgs = null): SQLWithArgs =
      if (b) left
      else {
        val r = right
        if (r != null) r
        else default
      }

    def optional(f: => SQLWithArgs): SQLWithArgs = if (b) f else default
  }

  /**
    * val query = sql " SELECT * FROM user WHERE 1=1 "
    * val name:Option[String] = None
    * val optionSql = name.optional( str => s" and name = ${str}")
    */
  /*implicit class SqlOptionEx[T](opt: Option[T]) {

    import wangzx.scala_commons.sql._

    def optional(op: T => SQLWithArgs): SQLWithArgs = opt match {
      case Some(value) => op(value)
      case None => SQLWithArgs("", Seq.empty)
    }

  }*/

  implicit class OptionEx[T](opt: Option[T]) {

    def optional(op: T => String): String = opt match {
      case Some(value) => op(value)
      case None => "不存在"
    }

  }


  /**
    * timestamp => Long
    */
  implicit def timestamp2Long(x: java.sql.Timestamp): Long = x.getTime

  /**
    * Long => date
    */
  implicit def long2Date(x: Long) = new java.sql.Timestamp(x)

  /**
    * BigDecimal => Double
    */
  implicit def bigDecimal2Double(x: scala.math.BigDecimal): Double = x.toDouble

}


class Hello {


}

object TestImplicit {

  import com.maple.implic.Implicits._

  def main(args: Array[String]): Unit = {
    val name = "maple"
    val bool = name.in(Array("maple", "struy"))
    println(s"是否存在: $bool")

    val isBetween = 10.between(2, 20)

    println(s"是否在范围内 $isBetween")

    val list = List[String]("hello", "world", "thanks", "you")

    // 隐式类 implicitly class
    val optionArg = Some("maple")
    val str = optionArg.optional(s ⇒ s"是否存在 $s")

    val optionArg1 = Option.empty[String]
    val str1 = optionArg1.optional(s ⇒ s"是否存在 $s")


    println(str)
    println(str1)

    //def
    // implicitly method
    val time: Timestamp = long2Date(20000L)
    val time1: Timestamp = 1550232131252L

    println(time)
    println(time1)

  }
}

