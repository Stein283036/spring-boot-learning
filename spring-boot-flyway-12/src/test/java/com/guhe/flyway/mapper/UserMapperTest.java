package com.guhe.flyway.mapper;

import com.guhe.flyway.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author njl
 * @date 2023/3/14
 */
@SpringBootTest
class UserMapperTest {
	@Autowired
	private UserMapper userMapper;

	@Test
	void selectUserByIdTest() {
//		userMapper.selectUserById()
	}

	@Test
	void insertUserTest() {
		User user = new User();
		user.setName("倪京龙");
		user.setAge(23);
		userMapper.insertUser(user);
	}
}