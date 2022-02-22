package com.bhavna.restdemo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories("com.bhavna.restdemo.repository")
@ComponentScan(basePackages = "com.bhavna.restdemo")
public class SimpleWebConfiguration {
//	@Bean
//	public JdbcTemplate mydataSource(){
//		String url = "jdbc:sqlserver://localhost\\BHAVNAWK738;databaseName=ML_DB;portNumber=1434";
//        String user = "sa";
//        String pass = "Bhavna@123";
//		
//	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	    dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//	    dataSource.setUrl(url);
//	    dataSource.setUsername(user);
//	    dataSource.setPassword(pass);
//
//
//	    JdbcTemplate jdbcTemplate = new JdbcTemplate();
//
//	    jdbcTemplate.setDataSource(dataSource);
//
//	    return jdbcTemplate;
//	}
	
    @Autowired
    private Environment environment;

    /************* Start Spring JPA config details **************/
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setJpaVendorAdapter(getJpaVendorAdapter());
        lcemfb.setDataSource(dataSource());
        lcemfb.setPersistenceUnitName("myJpaPersistenceUnit");
        lcemfb.setPackagesToScan("com.bhavna");
        lcemfb.setJpaProperties(hibernateProperties());
        return lcemfb;
    }

    @Bean
    public JpaVendorAdapter getJpaVendorAdapter() {
        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        return adapter;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager txManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(
            getEntityManagerFactoryBean().getObject());
        return jpaTransactionManager;
    }

    /************* End Spring JPA config details **************/

    @Bean
    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driver"));
//        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
//        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
//        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
    	
    	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost\\BHAVNAWK738;databaseName=ML_DB;portNumber=1434";
		String user = "sa";
		String pass = "Bhavna@123";
		
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(driver);
	    dataSource.setUrl(url);
	    dataSource.setUsername(user);
	    dataSource.setPassword(pass);
        return dataSource;
    }

    private Properties hibernateProperties() {
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
//        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
//        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
//        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
//    	hibernate.dialect=org.hibernate.dialect.SQLServerDialect
//    			hibernate.show_sql=true
//    			hibernate.format_sql=true
//    			hibernate.hbm2ddl.auto=update
        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.SQLServerDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "none");
        return properties;
    }
}
