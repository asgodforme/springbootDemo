package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserSexEnum;

public interface UserMapper {

	@Select("select * from users")
	@Results({ @Result(property = "userSex", column = "userSex", javaType = UserSexEnum.class),
			@Result(property = "nickName", column = "nickName") })
	List<UserEntity> getAll();

	@Select("select * from users where id = #{id}")
	@Results({ @Result(property = "userSex", column = "userSex", javaType = UserSexEnum.class),
			@Result(property = "nickName", column = "nickName") })
	UserEntity getOne(Long id);

	@Insert("INSERT INTO users(id, userName,passWord,userSex) VALUES(#{id}, #{userName}, #{passWord}, #{userSex})")
	void insert(UserEntity user);

	@Update("UPDATE users SET userName=#{userName},nickName=#{nickName} WHERE id =#{id}")
	void update(UserEntity user);

	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);
}
