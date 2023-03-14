package com.guhe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
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
		entityManagerFactoryRef = "entityManagerFactoryPrimary",
		transactionManagerRef = "transactionManagerPrimary",
		basePackages = "com.guhe.primary.repository"
)
public class PrimaryDataSourceConfiguration {
	@Autowired
	@Qualifier("primaryDataSource")
	private DataSource primaryDataSource;

	@Autowired
	private JpaProperties jpaProperties;

	@Bean
	public HibernateProperties hibernateProperties() {
		return new HibernateProperties();
	}

	// 配置 PlatformTransactionManager
	@Primary
	@Bean("transactionManagerPrimary")
	public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryPrimary(builder).getObject()));
	}

	@Primary
	@Bean(name = "entityManagerPrimary")
	public EntityManager entityManagerPrimary(EntityManagerFactoryBuilder builder) {
		return Objects.requireNonNull(entityManagerFactoryPrimary(builder).getObject()).createEntityManager();
	}

	// 配置 EntityManagerFactory
	@Primary
	@Bean("entityManagerFactoryPrimary")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(primaryDataSource)
				.packages("com.guhe.primary.pojo")
				.properties(properties())
				.persistenceUnit("primaryPersistenceUnit")
				.build();
	}

	private Map<String, Object> properties() {
		return hibernateProperties().determineHibernateProperties(
				jpaProperties.getProperties(),
				new HibernateSettings()
		);
	}
}
