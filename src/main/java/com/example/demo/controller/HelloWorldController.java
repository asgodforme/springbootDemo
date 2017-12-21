package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;

@RestController
public class HelloWorldController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/hello")
	public String hello() {
		return "hello world!";
	}
	
	@RequestMapping("/getUser")
	@Cacheable(value = "user-key")
	public User getUser() {
		User user = userRepository.findByUserName("bb2");
		System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
		return user;
	}
	
	@RequestMapping("/getUsers")
	public List<User> getUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	@RequestMapping("/uid")
	public String uid(HttpSession session) {
		UUID uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
	}
}
