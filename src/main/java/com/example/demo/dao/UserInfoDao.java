package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.UserInfo;

public interface UserInfoDao extends CrudRepository<UserInfo,Long> {

	public UserInfo findByUsername(String username);
}
