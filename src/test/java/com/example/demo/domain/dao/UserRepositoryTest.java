package com.example.demo.domain.dao;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Address;
import com.example.demo.domain.AddressRepository;
import com.example.demo.domain.PersonInfo;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Test
	public void testPersonInfo() {
		PersonInfo personInfo = addressRepository.findPersonInfo();
		System.out.println(personInfo.getAddress() + " | " + personInfo.getUserName() + "|" + personInfo.getEmail());
	}
	
	@Test
	public void testAdd() {
		addressRepository.save(new Address("王巧红", "湖南长沙宁乡龙凤"));
	}
	
	@Test
	public void test() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		
		/*userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
		userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
		userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));*/
		for (int i = 0 ; i < 100; i++) {
			userRepository.save(new User("姜杰" + i, "775048934@qq.com", "cc" + i, "cc123456" + i,formattedDate));
		}
		/*Assert.assertEquals(3, userRepository.findAll().size());
		Assert.assertEquals("bb2", userRepository.findByUserNameOrEmail("bb2", "77@qq.com"));*/
//		userRepository.delete(userRepository.findByUserName("aa1"));
	}
	
	@Test
	public void testPageQuery() {
		int page = 1, size = 10;
		Sort sort = new Sort(Direction.DESC, "id");
		
		Pageable pageable = new PageRequest(page, size ,sort);
		Page<User> p = userRepository.findAll(pageable);
		List<User> users = p.getContent();
		for (User user : users) {
			System.out.println(user);
		}
		p =  userRepository.findByUserNameLike("%姜杰%", pageable);
		users = p.getContent();
		for (User user : users) {
			System.out.println(user);
		}
		
	}
	
	@Test
	public void testModify() {
		userRepository.modifyByIdAndUserId("王巧红", new Long(2));
		userRepository.deleteByUserId(new Long(3));
		System.out.println(userRepository.findByEmail("aa"));
	}
}
