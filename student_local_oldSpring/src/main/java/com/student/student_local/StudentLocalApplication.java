package com.student.student_local;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.student_local.service.StudentService;

public class StudentLocalApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");   
		StudentService studentService = context.getBean("studentServiceImpl", StudentService.class);
		studentService.getAllStudents().forEach(student -> {
			System.out.println("Student ID: " + student.getId());
		});
		context.close();
    }
}


