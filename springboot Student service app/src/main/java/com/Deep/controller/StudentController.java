package com.Deep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Deep.model.Student;
import com.Deep.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/students")
	public ResponseEntity<Student> saveStudentDetailsHandler(@RequestBody Student student){
		
		
		Student savedStudent= studentService.saveStudentDetails(student);
		
		return new ResponseEntity<>(savedStudent,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentHandler(){
		
		List<Student> students=  studentService.getAllStudentDetails();
		
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentByRollHandler(@PathVariable("roll") Integer roll){

		Student student= studentService.getStudentByRoll(roll);
		
		return new ResponseEntity<>(student,HttpStatus.OK);
		
	}
	
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student){
	
		Student updatedStudent= studentService.updateStudentDetails(student);
		
		return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
