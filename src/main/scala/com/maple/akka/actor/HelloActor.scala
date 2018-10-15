package com.maple.scala.actor

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, PoisonPill, Props, Terminated}
import akka.event.Logging
import com.maple.akka.actor.Pinger

/**
  * Defining an Actor class
  */
class HelloActor extends Actor {

  val log = Logging(context.system, this)

  /**
    * @author <a href="https://blog.csdn.net/lyyybz/article/details/53257245"/>
    * @return
    * 请注意，Akka Actor 接收消息循环是详尽的，与 Erlang 和已故的 Scala Actors相比有所不同。
    * 这意味着您需要为它可以接受的所有消息提供模式匹配，如果您希望能够处理未知消息，那么您需要具有默认情况，如上例所示。
    * 否则，将向ActorSystem的EventStream发布akka.actor.UnhandledMessage（消息，发件人，收件人）。
    */
  override def receive: Receive = {
    case "test" ⇒ log.info("received test")
    case _ ⇒ log.info("received unknown message")
  }


}

object HelloActorTest {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("hello")
    val helloActor: ActorRef = system.actorOf(Props[HelloActor], "helloActor")

    helloActor.tell("dalao", helloActor)

    helloActor.tell("test", helloActor)


  }
}

