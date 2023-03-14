package com.guhe.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author njl
 * @date 2023/3/14
 */
@Configuration
public class DataSourceConfiguration {
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	@Bean("primaryDataSource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@ConfigurationProperties(prefix = "spring.datasource.secondary")
	@Bean("secondaryDataSource")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create().build();
	}
}
