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

    channel.queueDeclare(queueName, false, false, false, getPropsWithMessageTtlSetTo4Minutes())
    val message = "Hello world!!"
    channel.basicPublish("", queueName, null, message.getBytes())
    println(" [x] Sent '" + message + "'")

    channel.close()
    connection.close()
  }

  def getPropsWithMessageTtlSetTo4Minutes() = {
    val props = new java.util.HashMap[String, Object]()
    props.put("x-message-ttl", java.lang.Integer.valueOf(240000))
    props
  }
}
