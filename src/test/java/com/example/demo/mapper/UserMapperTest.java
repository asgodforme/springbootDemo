package com.example.demo.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserSexEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private com.example.demo.mapperx.UserMapper userMapper;
	
	@Test
	public void testInsert() throws Exception {
		/*userMapper.insert(new UserEntity(new Long(1), "aa", "a123456", UserSexEnum.BOY));
		userMapper.insert(new UserEntity(new Long(2),"bb", "b123456", UserSexEnum.GIRL));
		userMapper.insert(new UserEntity(new Long(3),"cc", "b123456", UserSexEnum.GIRL));*/

		Assert.assertEquals(3, userMapper.getAll().size());
	}
	
	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = userMapper.getAll();
		System.out.println(users.toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		UserEntity user = userMapper.getOne(new Long(1));
		System.out.println(user.toString());
		user.setNickName("neo111");
		userMapper.update(user);
		Assert.assertTrue(("neo".equals(userMapper.getOne(new Long(1)).getNickName())));
	}
}
