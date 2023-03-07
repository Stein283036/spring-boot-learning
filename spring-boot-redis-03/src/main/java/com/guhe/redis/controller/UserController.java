package com.guhe.redis.controller;

import com.guhe.redis.pojo.User;
import com.guhe.redis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author njl
 * @date 2023/3/8
 */
@RequestMapping("/users")
@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> queryAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User queryUserById(@PathVariable("id") Long id) {
		User user = userRepository.findUserById(id);
		return user;
	}

	@DeleteMapping("{id}")
	public void removeUserById(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
	}
}
