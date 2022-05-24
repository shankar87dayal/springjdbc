package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My program sterted................" );
        
        //spring jdbc=> jdbcTemplate
        
        ApplicationContext context=
        		new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
       /* 
        * basic configuration...........
        
        JdbcTemplate template = context.getBean("jdbcTemplate" , JdbcTemplate.class);
        
        //insert query
        String query = "insert into student(sId,name,city) values(?,?,?)";
        
        //fire query
        int result = template.update(query , 333, "Ranjan", "danapur");
        System.out.println("number of record inserted .." +  result);
        */
        
        StudentDao studentDao = context.getBean("studentDaoImpl", StudentDao.class);
        
        Student student = new Student();
        student.setsId(444);
        student.setName("Manjeet kumar");
        student.setCity("Patna");
        
        int result = studentDao.insert(student);
        System.out.println("student added" + result);
        
        
    }
}
