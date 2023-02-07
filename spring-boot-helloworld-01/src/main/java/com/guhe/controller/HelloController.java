package com.guhe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author njl
 * @date 2023/2/7
 */
@RestController
public class HelloController/* 在该类上按 Alt+Ins 自动为该类生成测试类 */ {
	@RequestMapping({"/", "/index"})
	public String index() {
		return "Hello Spring Boot";
	}
}
