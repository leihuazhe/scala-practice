package com.maple.akka.hello.actorone

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

class TeacherActor extends Actor {

  override def receive: Receive = {
    case "1+1=?" ⇒
      sender ! "1 + 1 = 2"
    case "what's your name ?" ⇒
      sender ! "my name is maple"
    case _ ⇒
      sender ! "I can not solve this question"
  }
}

object TeacherService extends App {
  val config = ConfigFactory
    .parseResources("maple.conf")
    .getConfig("RemoteServerActor")

  val system = ActorSystem("TeacherService", config)

  val teacherActor: ActorRef = system.actorOf(Props[TeacherActor], "teacherActor")

  println(teacherActor)


}