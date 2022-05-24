package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{

	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		
		//insert query
        String query = "insert into student(sId,name,city) values(?,?,?)";
       int res = this.jdbcTemplate.update(query, student.getsId(), student.getName(),student.getCity());
		
		return res;
	}
	
	public int change(Student student) {
		// updating data
		String query = "update student set name=? , city=? where sId=?";
		int update = this.jdbcTemplate.update(query, student.getName(), student.getCity() , student.getsId());
		return update;
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	
}
