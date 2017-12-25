package com.example.demo.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.domain.User;

@Component
@RabbitListener(queues = "topic.messages")
public class HelloReceiver2 {

	@RabbitHandler
    public void process(String hello) {
        System.out.println(" topic.messages Receiver2  : " + hello);
    }

	@RabbitHandler
	public void process(Integer hello) {
		System.out.println("topic.messages Receiver2  : " + hello);
	}
	
	@RabbitHandler
	public void process(User user) {
		System.out.println("topic.messages Receiver2  : " + user);
	}
}
