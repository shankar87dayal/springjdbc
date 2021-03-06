package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDaoImpl")
public class StudentDaoImpl implements StudentDao{

	//@Autowired //@Autowired can also used in the setter of the class...
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

	public int delete(int studentId) {
		// delete operation
		 String query = "delete from student where sId=?";
		 int r = this.jdbcTemplate.update(query, studentId);
		 
		return r;
	}
	
	// RowMapperImpl class is used
	public Student getStudent(int studentId) {
		// select single student data
		String query = "select * from student where sId=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);

		return student;
	}

	//  anonymous class used
//	public Student getStudent(int studentId) {
//		// select single student data
//		String query = "select * from student where sId=?";
//		
//		Student student = this.jdbcTemplate.queryForObject(query, new RowMapper() {
//
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Student student = new Student();
//				student.setsId(rs.getInt(1));
//				student.setName(rs.getString(2));
//				student.setCity(rs.getString(3));
//				return student;
//			}
//			
//		}  , studentId);
//				
//		return student;
//	}
	
	public List<Student> getAllStudent() {
		// selecting multiple student data
		String query = "select * from student";
		List<Student> list = this.jdbcTemplate.query(query, new RowMapperImpl());
		return list;
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

	

	
	
}
