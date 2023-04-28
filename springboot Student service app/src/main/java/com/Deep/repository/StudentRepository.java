package com.Deep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Deep.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{

}
