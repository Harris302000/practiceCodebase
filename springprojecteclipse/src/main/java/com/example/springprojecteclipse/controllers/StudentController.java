package com.example.springprojecteclipse.controllers;

import java.util.ArrayList;
import java.util.List;
import com.example.springprojecteclipse.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springprojecteclipse.model.Student;
import com.example.springprojecteclipse.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/student/add")
	public ResponseEntity<?> createStudent(@Valid @RequestBody List<Student> student, @RequestHeader("Authorization") String token) {
		
		
		if(!token.equals("123456")) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized Access");
		}
		
		
		List<Student> insertStudent = studentService.insertStudent(student);
		if (insertStudent == null) {
			return ResponseEntity.ok("Data already present with same ID");
		}
		
		return ResponseEntity.ok("Data inserted successfully");
	}

	@PutMapping("/student")
	public ResponseEntity<?> updateStudent(@Valid @RequestBody Student student) {

		Student updatedStudent = studentService.updateStudent(student);

		if (updatedStudent == null) {
			return ResponseEntity.ok("No data found");
		}

		return ResponseEntity.ok("Data Updated successfully");

	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable String id) {

		Student student = studentService.getStudentById(id);

		if (student == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data Found with ID::" + id);
		}

		String name = student.getName();

		studentService.deleteStudentById(id);

		String msg = "Student data got deleted successfully. Name:" + name + " ID:" + id;

		return ResponseEntity.ok(msg);
		
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable String id) {

		Student student = studentService.getStudentById(id);

		if (student == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(student);
	}
	
	
	@GetMapping("/student?id={id}&name={name}")
	public ResponseEntity<Student> getStudentByIdandName(@RequestParam String id, @RequestParam String name) {

		Student student = studentService.getStudentByIdandName(id, name);

		if (student == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(student);
	}

	@GetMapping("/students")
	public ResponseEntity<?> getAllStudents() {

		List<Student> data = studentService.getAllStudent();

		if (data.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data Found");
		}

		return ResponseEntity.ok(data);
	}
}
