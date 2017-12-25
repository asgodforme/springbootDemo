package com.example.demo.rabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

	@Autowired
	private HelloSender helloSender;

	@Autowired
	private HelloSender1 helloSender1;

	@Test
	public void hello() throws Exception {
		helloSender.send3();
	}

	@Test
	public void oneToMany() throws Exception {
		for (int i = 0; i < 100; i++) {
			helloSender.send(i);
		}
	}

	@Test
	public void manyToMany() throws Exception {
		for (int i = 0; i < 100; i++) {
			helloSender.send(i);
			helloSender1.send(i);
		}
	}
	
	@Test
	public void user() throws Exception {
			helloSender.send(new User("姜杰", "jiangjie", "jj", "jj", "Jj"));
	}

}
