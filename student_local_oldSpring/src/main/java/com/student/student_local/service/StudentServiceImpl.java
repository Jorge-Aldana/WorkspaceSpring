package com.student.student_local.service;

import java.util.ArrayList;
import java.util.Collection;

import com.student.student_local.core.Student;

public class StudentServiceImpl implements StudentService {
	
	private Student student;

	@Override
	public Student get(long id) {
		return student;
	}

	@Override
	public Collection<Student> getAllStudents() {
		Collection<Student> students = new ArrayList<>();
		if (student != null) {			
			students.add(student);
		}
		return students;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
