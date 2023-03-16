package com.guhe.logback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author njl
 * @date 2023/3/16
 */

@Slf4j
@SpringBootApplication
public class SpringBootLogbackApp {
	// private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SpringBootLogbackApp.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLogbackApp.class, args);
		log.trace("trace 日志");
		log.debug("debug 日志");
		log.info("info 日志");
		log.warn("warn 日志");
		log.error("error 日志");
	}
}
