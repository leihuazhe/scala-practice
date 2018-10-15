package com.maple.akka.hello.actorone

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory


class StudentActor extends Actor {

  //  val path = "akka.tcp://teacherSystem@127.0.0.1:4999/user/teacherActor"
  val pats = "akka.tcp://TeacherService@127.0.0.1:4998/user/teacherActor"

  val remoteServiceRef = context.actorSelection(pats)

  var counter = 0

  override def receive: Receive = {
    case res: String ⇒
      counter += 1
      println(s"老师回复String：$res $counter")
    case time: Long ⇒
      //      print(s"老师回复Long ：$time")
      //      sender ! "what's your name ?"
      remoteServiceRef ! "what's your name ?"
    case _ ⇒
      remoteServiceRef ! "I can not solve this question"
  }
}

object StudentSimulator extends App {
  val config = ConfigFactory
    .parseResources("maple.conf")
    .getConfig("RemoteClientActor")

  val system = ActorSystem("StudentClient", config)

  val studentActor: ActorRef = system.actorOf(Props[StudentActor])

  while (true) {
    studentActor ! 7.toLong

    Thread.sleep(5000)
  }


}
