package com.newland.mongodb;

import com.alibaba.fastjson.JSONObject;
import com.newland.mongodb.bean.Status;
import com.newland.mongodb.bean.User;
import com.newland.mongodb.repository.UserRepository;
import com.newland.mongodb.service.InsertService;
import com.newland.mongodb.service.QueryIndexService;
import com.newland.mongodb.service.QueryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class BootMongodbApplicationTests {

	@Autowired
	private InsertService insertService;
	@Autowired
	private QueryIndexService queryIndexService;
	@Autowired
	private QueryService queryService;
	@Autowired
	private UserRepository userRepository;
	@Test
	void insert() {
		insertService.insert();
	}
	@Test
	void insertMany() {
		insertService.insertMany();
	}
	@Test
	void getIndexAll() {
		Object result = queryIndexService.getIndexAll();
		System.out.println(JSONObject.toJSONString(result));
	}
	@Test
	void findAll() {
		Object result = queryService.findAll();
		System.out.println(JSONObject.toJSONString(result));
	}
	@Test
	void findById() {
		Object result = queryService.findById();
		System.out.println(JSONObject.toJSONString(result));
	}
	@Test
	void test(){
		System.out.println(userRepository.findAll());
		userRepository.findByNameAndAge("nam",18);
	}
	@Test
	void insertREpositry(){
		User user=new User();
		user.setId("123");
		user.setAge(23);
		user.setBirthday(new Date());
		user.setSalary(234);
		user.setRemake("234234234wrwer");
		userRepository.insert(user);
	}

}
