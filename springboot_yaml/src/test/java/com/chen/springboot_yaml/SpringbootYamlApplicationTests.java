package com.chen.springboot_yaml;

import com.chen.springboot_yaml.pojo.Dog;
import com.chen.springboot_yaml.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootYamlApplicationTests {

	@Autowired
//	@Qualifier("")
	private Dog dog;
	@Autowired
	private User user;

	@Test
	void contextLoads() {

		System.out.println(user.toString());
	}

}
