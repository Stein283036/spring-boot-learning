package com.guhe.log4j2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author njl
 * @date 2023/3/16
 */
@Slf4j
@SpringBootApplication
public class SpringBootLog4j2App {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLog4j2App.class, args);
		log.info("Logger name - {}", log.getName());
		log.info("info 日志");
		log.error("error 日志");
	}
}
