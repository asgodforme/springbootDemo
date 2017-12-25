package com.example.demo.rabbit;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender1 {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hello " + new Date();
		System.out.println("Sender1 : " + context);
		this.rabbitTemplate.convertAndSend("hello", context);
	}
	
	public void send(Integer i) {
		this.rabbitTemplate.convertAndSend("hello", i);
	}

}
