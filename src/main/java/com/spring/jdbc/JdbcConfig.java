package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class JdbcConfig {

	@Bean("dsource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dsource = new DriverManagerDataSource();
		dsource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dsource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dsource.setUsername("root");
		dsource.setPassword("Pass@123word$");
		return dsource;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		
		return jdbcTemplate;
	}
	
}
