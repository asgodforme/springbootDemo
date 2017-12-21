package com.example.demo.mapperx;

import java.util.List;

import com.example.demo.entity.UserEntity;

public interface UserMapper {

	List<UserEntity> getAll();

	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);
}
