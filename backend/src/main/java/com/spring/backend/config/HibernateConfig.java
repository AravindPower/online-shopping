package com.spring.backend.config;

import java.util.Properties;

import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.backend.commons.Commons;
import com.spring.backend.dto.Category;

@Configuration
@ComponentScan(basePackages = {"com.spring.backend.dto"})
@EnableTransactionManagement
public class HibernateConfig
 {
   
	private final Logger log = Logger.getLogger(HibernateConfig.class);
	
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		log.info("loading data base details");
		ds.setDriverClassName(Commons.DATABSE_CLASSNAME);
		ds.setUrl(Commons.DATABASE_URL);
		ds.setUsername(Commons.DATABASE_NAME);
		ds.setPassword(Commons.DATABASE_PASSWORD);
		log.info("data base loaded");
		return ds;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean session = new LocalSessionFactoryBean();
		session.setDataSource(dataSource());
		session.setAnnotatedClasses(Category.class);
		session.setPackagesToScan("com.spring.backend.dto");
		session.setHibernateProperties(getHibernateProperties());
		return session;

	}

	@Bean
	public Properties getHibernateProperties() {

		Properties property = new Properties();
		log.info("hibernate loading");
		property.put("hibernate.htm2ddl", "update");
		property.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		property.put("hibernate.show_sql", "true");
		property.put("hibernate.format_sql", "true");
		log.info("hibernate loaded");
		return property;

	}

	@Bean
	public HibernateTransactionManager hibernateTransaction() {
		HibernateTransactionManager hibernateTrasactionManager = new HibernateTransactionManager();
		LocalSessionFactoryBean localSession = sessionFactory();
		hibernateTrasactionManager.setSessionFactory(localSession.getObject());
		return hibernateTrasactionManager;

	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistanceException() {
		PersistenceExceptionTranslationPostProcessor ref = new PersistenceExceptionTranslationPostProcessor();
		return ref;

	}

}
