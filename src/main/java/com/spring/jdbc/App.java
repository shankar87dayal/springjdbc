package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        		new AnnotationConfigApplicationContext(JdbcConfig.class);
       /* 
        * basic configuration and insert student details...........
        
        JdbcTemplate template = context.getBean("jdbcTemplate" , JdbcTemplate.class);
        
        //insert query
        String query = "insert into student(sId,name,city) values(?,?,?)";
        
        //fire query
        int result = template.update(query , 333, "Ranjan", "danapur");
        System.out.println("number of record inserted .." +  result);
        */
        
        StudentDao studentDao = context.getBean("studentDaoImpl", StudentDao.class);
        
        //INSERTING
//        Student student = new Student();
//        student.setsId(555);
//        student.setName("Rahul kumar");
//        student.setCity("madhubani");
//        
//        int result = studentDao.insert(student);
//        System.out.println("student added" + result);
        
        //UPDATE
//        Student student = new Student();
//        student.setsId(555);
//        student.setName("Rahul kumar singh");
//        student.setCity("saharghat"); 
//        
//        int result = studentDao.change(student);
//        System.out.println("Data change" + result);
        
        //DELETION
//        int result = studentDao.delete(555);
//        System.out.println("delete " + result);
        
//        Student student = studentDao.getStudent(222);
//        System.out.println(student);
        
        
        List<Student> students = studentDao.getAllStudent();
        for(Student s:students)
        {
        	System.out.println(s);
        }
        
        
    }
}
