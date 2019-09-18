package com.metacube.StudentJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.StudentJPA.Dao.StudentRepository;
import com.metacube.StudentJPA.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public void addStudent(Student student) {
		studentRepository.save(student);
	}
	
	@Transactional
	public List<Student> showStudents() {
		return studentRepository.findAll();
	}
}
