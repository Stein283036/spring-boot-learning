package com.guhe.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author njl
 * @date 2023/2/7
 */
@EnableCaching // 开启缓存支持，通常使用一些第三方技术组件的时候都需要使用 @EnableXXX 这样的注解
@SpringBootApplication
public class SpringBootRedisApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisApp.class, args);
	}
}
