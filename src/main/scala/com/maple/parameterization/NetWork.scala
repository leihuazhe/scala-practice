package com.maple.parameterization

import scala.collection.mutable.ArrayBuffer

/**
  * 类型投影
  *
  * @author <a href=mailto:leihuazhe@gmail.com>maple</a> 
  * @since 2018-10-18 3:01 PM
  */
class NetWork {

  class Member(val name: String) {
    val contacts = new ArrayBuffer[NetWork#Member]()
    //    val contacts = new ArrayBuffer[Member]()
  }

  private val members = new ArrayBuffer[Member]()

  def join(name: String): Member = {
    val m = new Member(name)
    members += m
    m
  }
}

object NetWorkMain extends App {
  val company = new NetWork

  val home = new NetWork

  val maple = company.join("maple")

  val ty = home.join("tangyang")

  maple.contacts += ty


  println(s"maple $maple ")
  println(s"maple $ty ")


}
