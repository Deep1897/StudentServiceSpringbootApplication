package com.Deep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Deep.model.Student;
import com.Deep.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

//	public StudentServiceImpl(StudentRepository studentRepo) {
//		this.studentRepo = studentRepo;
//	}

	@Override
	public Student saveStudentDetails(Student student) {

		Student savedStudent = studentRepo.save(student);
		return savedStudent;
	}

	@Override
	public List<Student> getAllStudentDetails() {

		return studentRepo.findAll();

	}

	@Override
	public Student getStudentByRoll(Integer roll) {

//		Optional<Student> opt= studentRepo.findById(roll);
//		
//		if(opt.isPresent())
//		{
////			Student student= opt.get();
////			return student;
//			
//			return opt.get();
//			
//		}else
//			throw new IllegalArgumentException("Student does not exist with roll :"+roll);

		return studentRepo.findById(roll)
				.orElseThrow(() -> new IllegalArgumentException("Student does not exist with roll " + roll));

	}

	@Override
	public Student updateStudentDetails(Student student) {

		//check the availabilty of existing student
		 Student existingStudent= studentRepo.findById(student.getRoll()).orElseThrow(() -> new IllegalArgumentException("Invalid Student supplied"));

		//this save method will act as a saveOrUpdate
		 return studentRepo.save(student);
		
		
		
		
		
	}

}
