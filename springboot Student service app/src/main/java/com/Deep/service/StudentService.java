package com.Deep.service;

import java.util.List;

import com.Deep.model.Student;

public interface StudentService {
	
	public Student saveStudentDetails(Student student);
	
	public List<Student> getAllStudentDetails();
	
	public Student getStudentByRoll(Integer roll);
	
	public Student updateStudentDetails(Student student);

}
