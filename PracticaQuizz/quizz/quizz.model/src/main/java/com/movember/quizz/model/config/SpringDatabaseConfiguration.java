package com.movember.quizz.model.config;

import java.util.Properties;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

@Configuration
public class SpringDatabaseConfiguration extends SpringModelConfiguration {
	// JDBC CONFIGURATION
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	// HIBERNATE CONFIGURATION
	@Value("${hibernate.dialect}")
	private String dialect;
	@Value("${hibernate.show_sql}")
	private String showSql;
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2DDL;
	@Value("${hibernate.generate_statistics}")
	private String statitics;
	// Bean Mapeados
	@Value("${hibernate.mapping.usuario}")
	private String usuario;

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

	@Bean
	@Inject
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
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
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		factoryBean.setConfigurationClass(AnnotationConfiguration.class);
		factoryBean.setMappingResources(getBeansMapping());
		factoryBean.setHibernateProperties(getHibernateProperties());
		return factoryBean;
	}

	// <bean id="transactionManager"
	// class="org.springframework.orm.hibernate3.HibernateTransactionManager">
	// <property name="sessionFactory" ref="sessionFactory" />
	// </bean>
	@Bean
	@Inject
	public HibernateTransactionManager getFinalSessionFactory(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}

	@Bean
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.show_sql", showSql);
		properties.put("hibernate.hbm2ddl.auto", hbm2DDL);
		properties.put("hibernate.generate_statistics", statitics);
		return properties;
	}

	@Bean
	public String[] getBeansMapping() {
		String[] beans = new String[1];
		beans[0] = usuario;
		return beans;
	}
}
