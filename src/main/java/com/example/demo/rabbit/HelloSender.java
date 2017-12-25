package com.example.demo.rabbit;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.User;

@Component
public class HelloSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hello " + new Date();
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("hello", context);
	}
	
	public void send(Integer i) {
		this.rabbitTemplate.convertAndSend("hello", i);
	}
	
	public void send(User user) {
		this.rabbitTemplate.convertAndSend("hello", user);
	}
	
	public void send1() {
		String context = "hi, iam message 1";
		System.out.println("Sender: " + context);
		this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
	}
	
	public void send2() {
		String context = "hi, iam message 2";
		System.out.println("Sender: " + context);
		this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
	}
	
	public void send3() {
		String context = "hi, fanout msg ";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
}

}
