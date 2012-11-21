package com.movember.quizz.model.config;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

@Configuration
@ComponentScan({ "com.movember.quizz.model" })
public class SpringModelConfiguration {

	// <bean id="dataSource"
	// class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	// <property name="driverClassName" value="${jdbc.driverClassName}" />
	// <property name="url" value="${jdbc.url}" />
	// <property name="username" value="${jdbc.username}" />
	// <property name="password" value="${jdbc.password}" />
	// </bean>

	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource result = new DriverManagerDataSource();
		result.setDriverClassName("com.mysql.jdbc.Driver");
		result.setUrl("jdbc:mysql://localhost:3306/db_quizz");
		result.setUsername("root");
		result.setPassword("root");
		return result;
	}

	// <bean id="sessionFactory"
	// class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
	// <property name="dataSource" ref="dataSource" />
	// <property name="configurationClass"
	// value="org.hibernate.cfg.AnnotationConfiguration"/>
	// <property name="configLocation">
	// <value>classpath:${hibernate.cfg.file}</value>
	// </property>
	// </bean>

	@Bean
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource, Resource resource) {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setConfigurationClass(AnnotationConfiguration.class);
		sessionFactoryBean.setConfigLocation(resource);
		return sessionFactoryBean;
	}

	// <bean id="transactionManager"
	// class="org.springframework.orm.hibernate3.HibernateTransactionManager">
	// <property name="sessionFactory" ref="sessionFactory" />
	// </bean>

	@Bean
	public HibernateTransactionManager getFinalSessionFactory(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
}
