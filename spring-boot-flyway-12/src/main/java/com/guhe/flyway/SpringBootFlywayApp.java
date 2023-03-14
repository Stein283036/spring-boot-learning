package com.guhe.flyway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author njl
 * @date 2023/3/14
 */
@MapperScan("com.guhe.flyway.mapper")
@SpringBootApplication
public class SpringBootFlywayApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFlywayApp.class, args);
	}
}
