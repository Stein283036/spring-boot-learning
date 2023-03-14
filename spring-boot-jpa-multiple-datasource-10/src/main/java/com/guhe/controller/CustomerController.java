package com.guhe.controller;

import com.guhe.secondary.pojo.Customer;
import com.guhe.secondary.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author njl
 * @date 2023/3/14
 */
@RequestMapping("/customers")
@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping
	public List<Customer> queryAll() {
		return customerRepository.findAll();
	}
}
