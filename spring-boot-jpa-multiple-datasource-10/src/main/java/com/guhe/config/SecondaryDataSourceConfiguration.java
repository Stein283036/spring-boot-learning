package com.guhe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Objects;

/**
 * @author njl
 * @date 2023/3/14
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "entityManagerFactorySecondary",
		transactionManagerRef = "transactionManagerSecondary",
		basePackages = "com.guhe.secondary.mapper"
)
public class SecondaryDataSourceConfiguration {
	@Autowired
	@Qualifier("secondaryDataSource")
	private DataSource secondaryDataSource;

	@Autowired
	private JpaProperties jpaProperties;

	@Autowired
	private HibernateProperties hibernateProperties;

	// 配置 PlatformTransactionManager
	@Bean("transactionManagerSecondary")
	public PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactorySecondary(builder).getObject()));
	}

	// 配置 EntityManagerFactory
	@Bean("entityManagerFactorySecondary")
	public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(secondaryDataSource)
				.packages("com.guhe.secondary.pojo")
				.properties(properties())
				.persistenceUnit("secondaryPersistenceUnit")
				.build();
	}

	private Map<String, Object> properties() {
		return hibernateProperties.determineHibernateProperties(
				jpaProperties.getProperties(),
				new HibernateSettings()
		);
	}
}
