//package com.maple.akka.hello.actor
//
//import akka.actor.{Actor, Props}
//import akka.testkit.ImplicitSender
////import akka.testkit.{ImplicitSender, AkkaSpec}
//import akka.actor.Props
//
//
///**
//  * props
//  * Props is a configuration class to specify options for the creation of actors,
//  * think of it as an immutable and thus freely shareable recipe for creating an actor including associated deployment information
//  * (e.g. which dispatcher to use, see more below).
//  *
//  * Here are some examples of how to create a Props instance.
//  */
//class HelloProps extends Actor {
//
//  override def receive: Receive = {
//
//    val props1 = Props[HelloActor]
//    //      val props2 = Props(new HelloActor("arg")) // careful, see below
//    //      val props3 = Props(classOf[ActorWithArgs], "arg") // no support for value class arguments
//    //#creating-props
//
//    //#creating-props-deprecated
//    // NOT RECOMMENDED within another actor:
//    // encourages to close over enclosing class
//    //      val props7 = Props(new HelloActor)
//    //#creating-props-deprecated
//
//  }
//
//}
//
//
