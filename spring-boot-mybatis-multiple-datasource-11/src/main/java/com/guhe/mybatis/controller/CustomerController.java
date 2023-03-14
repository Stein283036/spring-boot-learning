package com.guhe.mybatis.controller;

import com.guhe.mybatis.secondary.mapper.CustomerMapper;
import com.guhe.mybatis.secondary.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author njl
 * @date 2023/3/14
 */
@RequestMapping("/customers")
@RestController
public class CustomerController {
	@Autowired
	private CustomerMapper customerMapper;

	@GetMapping("/{id}")
	public Customer findById(@PathVariable("id") Long id) {
		return customerMapper.selectById(id);
	}
}
