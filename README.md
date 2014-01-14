rabbitmq-message-sender
=======================

Simple rabbitmq message producer

Requisitos
==========

  * Scala 2.9.1
  * sbt 0.12
  * rabbitmq server up and running
  
Get started
================

  * Clone the project

  * If you are using Intellij run the following command that generates the fields that will allow you to import the project:
      
      sbt gen-idea

  * To compile the project run:
        
      sbt compile

  * To run the project and send a message to the queue just type the following command:
  
      sbt run
