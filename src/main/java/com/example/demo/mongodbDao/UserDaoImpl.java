package com.example.demo.mongodbDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.example.demo.mongodb.MongodbUserEntity;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void saveUser(MongodbUserEntity user) {
		mongoTemplate.save(user);
	}

	@Override
	public MongodbUserEntity findUserByUserName(String userName) {
		Query query = new Query(Criteria.where("userName").is(userName));
		MongodbUserEntity user = mongoTemplate.findOne(query, MongodbUserEntity.class);
		return user;
	}

	@Override
	public void updateUser(MongodbUserEntity user) {
		Query query = new Query(Criteria.where("id").is(user.getId()));
		Update update = new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
		mongoTemplate.updateFirst(query, update, MongodbUserEntity.class);
		mongoTemplate.updateMulti(query, update, MongodbUserEntity.class);
	}

	@Override
	public void deleteUserById(Long id) {
		Query query = new Query(Criteria.where("id").is(id));
		mongoTemplate.remove(query, MongodbUserEntity.class);
	}
}
