package com.student.student_local.service;

import java.util.Collection;

import com.student.student_local.core.Student;

public interface StudentService {
	
	Student get(long id);
	Collection<Student> getAllStudents();

}
