package org.soumya.narayan.aiqs.config.db;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.dialect.H2Dialect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableJpaRepositories(basePackages = { "org.soumya.narayan.aiqs.repo" })
public class AppDatabaseContext {
	
	@Bean(name = "aiqsDataSource")
	public ComboPooledDataSource datasource() throws PropertyVetoException {
		final ComboPooledDataSource dataSource = new ComboPooledDataSource();

		dataSource.setUser("sa");
		dataSource.setPassword("");
		dataSource.setJdbcUrl("jdbc:h2:~/Desktop/aiqs;DB_CLOSE_DELAY=-1;");// AUTO_SERVER=TRUE
		dataSource.setDriverClass(org.h2.Driver.class.getName());
		dataSource.setInitialPoolSize(5);
		dataSource.setMinPoolSize(5);
		dataSource.setMaxPoolSize(10);

		return dataSource;
	}

	@Bean(name = "aiqsJpaVendorAdapter")
	public JpaVendorAdapter jpaVendorAdapter() {
		final HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setDatabase(Database.H2);
		return jpaVendorAdapter;
	}

	@Bean(name = "aiqsEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManager(
			@Qualifier("aiqsDataSource") ComboPooledDataSource aiqsDataSource,
			@Qualifier("aiqsJpaVendorAdapter") JpaVendorAdapter aiqsJpaVendorAdapter) {
		final LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setPackagesToScan("org.soumya.narayan.aiqs.entity");
		entityManager.setDataSource(aiqsDataSource);
		entityManager.setJpaVendorAdapter(aiqsJpaVendorAdapter);
		return entityManager;
	}

	@Bean(name = "aiqsSessionFactory")
	public LocalSessionFactoryBean sessionFactory(
			@Qualifier("aiqsDataSource") ComboPooledDataSource aiqsDataSource) {
		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(aiqsDataSource);
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.hbm2ddl.auto", "create");
		hibernateProperties.put("hibernate.dialect", H2Dialect.class.getName());
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}

	@Bean(name = "aiqsTransactionManager")
	public HibernateTransactionManager transactionManager(
			@Qualifier("aiqsSessionFactory") SessionFactory aiqsSessionFactory) {
		final HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(aiqsSessionFactory);
		return transactionManager;
	}

}
