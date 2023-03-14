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
		basePackages = "com.guhe.mybatis.primary.mapper",
		sqlSessionFactoryRef = "sqlSessionFactoryRefPrimary",
		sqlSessionTemplateRef = "sqlSessionTemplateRefPrimary"
)
@Configuration
public class PrimaryDataSourceConfiguration {
	@Autowired
	@Qualifier("primaryDataSource")
	private DataSource primaryDataSource;

	@Bean
	public SqlSessionFactory sqlSessionFactoryRefPrimary() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(primaryDataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage("com.guhe.mybatis.primary.pojo");
		ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resourceResolver.getResources("classpath:mapper/primary/*.xml");
		sqlSessionFactoryBean.setMapperLocations(resources);
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplateRefPrimary() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactoryRefPrimary());
	}
}
