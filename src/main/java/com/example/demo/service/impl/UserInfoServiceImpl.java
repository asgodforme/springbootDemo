package com.example.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dao.UserInfoDao;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
    private UserInfoDao userInfoDao;
	
	@Override
	public UserInfo findByUsername(String username) {
		System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
	}

}
