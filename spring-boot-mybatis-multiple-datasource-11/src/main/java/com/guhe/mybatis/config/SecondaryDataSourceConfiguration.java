package com.guhe.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author njl
 * @date 2023/3/14
 */
@MapperScan(
		basePackages = "com.guhe.mybatis.secondary.mapper",
		sqlSessionFactoryRef = "sqlSessionFactoryRefSecondary",
		sqlSessionTemplateRef = "sqlSessionTemplateRefSecondary"
)
@Configuration
public class SecondaryDataSourceConfiguration {
	@Autowired
	@Qualifier("secondaryDataSource")
	private DataSource secondaryDataSource;

	@Bean
	public SqlSessionFactory sqlSessionFactoryRefSecondary() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(secondaryDataSource);
		sqlSessionFactoryBean.setDataSource(secondaryDataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage("com.guhe.mybatis.secondary.pojo");
		ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resourceResolver.getResources("classpath:mapper/secondary/*.xml");
		sqlSessionFactoryBean.setMapperLocations(resources);
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplateRefSecondary() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactoryRefSecondary());
	}
}
