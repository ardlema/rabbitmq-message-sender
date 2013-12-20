name := "rabbitmq-message-sender"

organization := "ardlema"

version := "0.0.1"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
  "com.rabbitmq" % "amqp-client" % "3.2.1",
  "org.scalatest" % "scalatest_2.10" % "2.0" % "test" withSources() withJavadoc(),
  "org.scalacheck" %% "scalacheck" % "1.10.0" % "test" withSources() withJavadoc()
)

initialCommands := "import ardlema.rabbitmqmessagesender._"

