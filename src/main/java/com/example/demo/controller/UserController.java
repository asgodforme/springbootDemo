package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.test1.User1Mapper;
import com.example.demo.mapper.test2.User2Mapper;

@RestController
public class UserController {
	
	@Autowired
	private User1Mapper user1Mapper;
	
	@Autowired
	private User2Mapper user2Mapper;
	
	@RequestMapping("/getUser1s")
	public List<UserEntity> getUser1s() {
		List<UserEntity> users = user1Mapper.getAll();
		return users;
	}
	
	@RequestMapping("/getUser2s")
	public List<UserEntity> getUser2s() {
		List<UserEntity> users = user2Mapper.getAll();
		return users;
	}

}
