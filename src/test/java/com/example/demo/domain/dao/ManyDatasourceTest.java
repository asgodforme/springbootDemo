package com.example.demo.domain.dao;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import com.example.demo.domain.s.Message;
import com.example.demo.domain.s.MessageRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyDatasourceTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MessageRepository messageRepository;

	@Test
	public void test() throws Exception {

		/*Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG);
		String formattedDate = dateFormat.format(date);

		userRepository.save(new User("aaa", "aa123456", "aa@126.com111", "aa1",
				formattedDate));
		userRepository.save(new User("bbb", "aa123456", "aa@126.com222", "aa2",
				formattedDate));
		userRepository.save(new User("ccc", "aa123456", "aa@126.com333", "aa3",
				formattedDate));
		userRepository.save(new User("ddd", "aa123456", "aa@126.com444", "aa4",
				formattedDate));
		userRepository.save(new User("eee", "aa123456", "aa@126.com555", "aa5",
				formattedDate));

		Assert.assertEquals(5, userRepository.findAll().size());*/

		/*messageRepository.save(new Message("o1", "aaaaaaaaaa"));
		messageRepository.save(new Message("o2", "bbbbbbbbbb"));
		messageRepository.save(new Message("o3", "cccccccccc"));*/

		Assert.assertEquals(3, messageRepository.findAll().size());

	}
}
