package com.example.userservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userservice.model.Student;
import com.example.userservice.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	

	public Student getStudentById(String id) {

		Optional<Student> student = studentRepository.findById(id);

		return student.orElse(null);
	}
	
	
	public Student getStudentByIdandName(String id,String Name) {

		Optional<Student> student = Optional.ofNullable(studentRepository.findStudentByIDandName(id, Name).orElse(null));

		return student.orElse(null);
	}

	public List<Student> getAllStudent() {

		List<Student> student = studentRepository.findAll();

		return student;
	}

	public void deleteStudentById(String id) {

		studentRepository.deleteById(id);

	}

	public Student updateStudent(Student student) {

		Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
		

		if (existingStudent == null) {
			return null;
		}
		

		if (student.getName() != null) {
			existingStudent.setName(student.getName());
		}

		if (student.getAge() != null) {
			existingStudent.setAge(student.getAge());
		}

		return studentRepository.save(existingStudent);
	}
	
	
	public List<Student> insertStudent(List<Student> student) {

		
		for (Student s : student) {
			if (studentRepository.existsById(s.getId())) {
				return null;
			}
		}

		return studentRepository.saveAll(student);
	}

}
