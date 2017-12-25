package com.example.demo.mongodbDao;

import com.example.demo.mongodb.MongodbUserEntity;

public interface UserDao {

	public void saveUser(MongodbUserEntity user);

	public MongodbUserEntity findUserByUserName(String userName);

	public void updateUser(MongodbUserEntity user);

	public void deleteUserById(Long id);
}
