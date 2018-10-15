package com.maple.akka

import akka.actor.{ActorRef, ActorSystem, Props}
import com.maple.scala.actor.HelloActor

object ActorMain {
  //在Akka中，一个ActorSystem是一个重量级的结构，他需要分配多个线程，所以在实际应用中，按照逻辑划分的每个应用对应一个ActorSystem实例。

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("maple")
    val actorRef: ActorRef = system.actorOf(Props(new HelloActor))

  }
}
