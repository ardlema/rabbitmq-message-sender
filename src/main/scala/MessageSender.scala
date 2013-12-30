package ardlema.rabbitmqmessagesender

import com.rabbitmq.client.ConnectionFactory

object MessageSender {
  def main(args: Array[String]) {
    val hostName = "localhost"
    val queueName = "testqueue"
    val factory = new ConnectionFactory()
    factory.setHost(hostName)
    val connection = factory.newConnection()
    val channel = connection.createChannel()

    channel.queueDeclare(queueName, false, false, false, null)
    val message = "Hello World!"
    channel.basicPublish("", queueName, null, message.getBytes())
    System.out.println(" [x] Sent '" + message + "'")

    channel.close()
    connection.close()
  }
}
