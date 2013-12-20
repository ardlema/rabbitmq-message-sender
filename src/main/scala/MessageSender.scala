package ardlema.rabbitmqmessagesender

import com.rabbitmq.client.ConnectionFactory

object MessageSender {
  def main(args: Array[String]) {
    val userName = "guest"
    val password = "guest"
    val hostName = "localhost"
    val exchangeName = "testChannel"
    val routingKey = "routingKey"
    val portNumber = 5672
    val factory = new ConnectionFactory()
    factory.setUsername(userName)
    factory.setPassword(password)
    //factory.setVirtualHost(virtualHost)
    factory.setHost(hostName)
    factory.setPort(portNumber)
    val conn = factory.newConnection()
    println("Connection created!!!!!!")

    val channel = conn.createChannel()
    channel.exchangeDeclare(exchangeName, "direct", true)
    val queueName = channel.queueDeclare().getQueue()
    channel.queueBind(queueName, exchangeName, routingKey)

    println("Publishing the hello world message...")
    val messageBodyBytes = "Hello, world!".getBytes()
    channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes)
  }
}
