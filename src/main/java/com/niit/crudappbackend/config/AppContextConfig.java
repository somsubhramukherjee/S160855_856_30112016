package com.niit.crudappbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan(basePackages="com.niit")
public class AppContextConfig {
	
	@Bean
	public DataSource getH2DataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/s160855_29112016");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
		
	}
	
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory()
	{
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getH2DataSource());
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setPackagesToScan(new String[] {"com.niit.crudappbackend.model"});
		
		return sessionFactory;
	}

	
	public Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		
		return transactionManager;
		
	}
	
	
}
