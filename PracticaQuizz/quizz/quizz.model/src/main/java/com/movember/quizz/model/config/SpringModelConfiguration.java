package com.movember.quizz.model.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({ "com.movember.quizz.model" })
@PropertySource({ "classpath:/application.properties" })
@EnableTransactionManagement
public class SpringModelConfiguration {

	// Bean para importar el properties
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// HIBERNATE CONFIGURATION
	@Value("${hibernate.dialect}")
	private String dialect;
	@Value("${hibernate.show_sql}")
	private String showSql;
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2DDL;
	@Value("${hibernate.connection.CharSet}")
	private String charset;
	@Value("${hibernate.connection.characterEncoding}")
	private String characterEncoding;
	@Value("${hibernate.connection.useUnicode}")
	private String useUnicode;
	// JDBC CONFIGURATION DATASOURCE
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	// MAPPING BEANS
	@Value("${hibernate.mapping.packages}")
	private String packageBeans;

	// <bean id="dataSource"
	// class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	// <property name="driverClassName" value="${jdbc.driverClassName}" />
	// <property name="url" value="${jdbc.url}" />
	// <property name="username" value="${jdbc.username}" />
	// <property name="password" value="${jdbc.password}" />
	// </bean>

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource result = new DriverManagerDataSource();
		result.setDriverClassName(driverClassName);
		result.setUrl(url);
		result.setUsername(username);
		result.setPassword(password);
		return result;
	}

	// <bean id="transactionManager"
	// class="org.springframework.orm.hibernate3.HibernateTransactionManager">
	// <property name="sessionFactory" ref="sessionFactory" />
	// </bean>
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
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
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.show_sql", showSql);
		properties.put("hibernate.hbm2ddl.auto", hbm2DDL);
		properties.put("hibernate.connection.CharSet", charset);
		properties.put("hibernate.connection.characterEncoding", characterEncoding);
		properties.put("hibernate.connection.useUnicode", useUnicode);
		return properties;
	}

	@Bean
	public HibernateTemplate getHibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(getSessionFactory().getObject());
		return hibernateTemplate;
	}

	@Bean
	public AnnotationSessionFactoryBean getSessionFactory() {
		AnnotationSessionFactoryBean factoryBean = new AnnotationSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		factoryBean.setPackagesToScan(new String[] { packageBeans });
		factoryBean.setHibernateProperties(getHibernateProperties());
		return factoryBean;
	}
}
