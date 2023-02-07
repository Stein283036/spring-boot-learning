package com.guhe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author njl
 * @date 2023/2/7
 */
// Boot 最核心的注解，复合了三个注解：@EnableAutoConfiguration、@SpringBootConfiguration、@ComponentScan，
// 在启动类上标识，标识这个类是 Boot 应用的启动类，此时就需要按照良好的 Boot 推荐的应用工程结构组织代码，默认只扫描该
// 应用类所在包及其所有子包的 Spring Bean。
@SpringBootApplication
public class HelloSpringBootApp {
	public static void main(String[] args) {
		// 通过 SpringApplication.run(HelloSpringBootApp.class, args); 启动 Boot 应用，该方法
		// 返回 Boot 应用的 环境上下文对象
		ConfigurableApplicationContext ctx = SpringApplication.run(HelloSpringBootApp.class, args);
	}
}
