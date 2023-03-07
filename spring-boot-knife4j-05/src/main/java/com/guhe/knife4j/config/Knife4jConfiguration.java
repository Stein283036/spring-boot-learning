package com.guhe.knife4j.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author njl
 * @date 2023/3/8
 */
@EnableKnife4j
@Configuration
public class Knife4jConfiguration {
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.OAS_30)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.guhe.knife4j.web"))
				// spring 2.6 后需要配置配置 spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER，因为
				// Springboot 2.6 以后将 SpringMVC 默认路径匹配策略从 AntPathMatcher 更改为 PathPatternParser
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("我的 Web 应用")
				.description("使用 Knife4j 2 管理 Web 应用的接口文档并可视化地查看接口信息")
				.version("1.0.0")
				.contact(
						new Contact(
								"倪京龙",
								"https://bellaciao.gitbook.io/inspiration/",
								"stein283036@gmail.com"
						)
				)
				.license("Apache License")
				.build();

	}
}
