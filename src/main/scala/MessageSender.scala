package ardlema.rabbitmqmessagesender

import com.rabbitmq.client.ConnectionFactory

object MessageSender {
  def main(args: Array[String]) {
    val userName = "guest"
    val password = "guest"
    val hostName = "localhost"
    val portNumber = 5672
    val factory = new ConnectionFactory()
    factory.setUsername(userName)
    factory.setPassword(password)
    //factory.setVirtualHost(virtualHost)
    factory.setHost(hostName)
    factory.setPort(portNumber)
    val conn = factory.newConnection()

    println("Connection created!!!!!!")
  }
}
