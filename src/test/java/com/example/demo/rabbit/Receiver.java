package com.example.demo.rabbit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * consumer(消费者)端步骤：
     (1)：创建ConnectionFactory，并且设置一些参数，比如hostname,portNumber等等
     (2)：利用ConnectionFactory创建一个Connection连接
     (3)：利用Connection创建一个Channel通道
     (4)：将queue和Channel进行绑定，注意这里的queue名字要和前面producer创建的queue一致
     (5)：创建消费者Consumer来接收消息，同时将消费者和queue进行绑定
 * @author admin
 *
 */
public class Receiver {

	 private final static String QUEUE_NAME = "MyQueue";  
     
	    public static void main(String[] args) {  
	    	while (true) {
	    		receive();  
	    	}
	    }  
	      
	    public static void receive()  
	    {  
	        ConnectionFactory factory = null;  
	        Connection connection = null;  
	        Channel channel = null;  
	          
	        try {  
	            factory = new ConnectionFactory();  
	            factory.setHost("localhost");  
	            connection = factory.newConnection();  
	            channel = connection.createChannel();  
	            channel.queueDeclare(QUEUE_NAME, false, false, false, null);  
	            Consumer consumer = new AConsumer(channel);  
	            channel.basicConsume(QUEUE_NAME, true,consumer);  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } catch (TimeoutException e) {  
	            e.printStackTrace();  
	        }finally{  
	            try {  
	                //关闭资源  
	                channel.close();  
	                connection.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            } catch (TimeoutException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
}

class AConsumer extends DefaultConsumer {

	public AConsumer(Channel channel) {
		super(channel);
	}
	
	@Override
	public void handleDelivery(String consumerTag, Envelope envelope,
			com.rabbitmq.client.AMQP.BasicProperties properties, byte[] body)
			throws IOException {
		System.out.println("11111111111");  
        String message = new String(body, "UTF-8");  
        System.out.println("收到消息....."+message); 
	}
	
}
