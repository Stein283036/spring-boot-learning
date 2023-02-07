package com.guhe.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author njl
 * @date 2023/2/7
 */
//@EnableJpaRepositories("com.guhe.web.repository") // 这个注解也可以没有，很神奇
//@EntityScan("com.guhe.web.pojo") // 这个注解可有可无，SpringBoot 默认也会去扫描 @Entity 注解，配合使用 AutoConfigurationPackages 一起扫描
@SpringBootApplication
public class SpringBootWebApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApp.class, args);
	}
}
