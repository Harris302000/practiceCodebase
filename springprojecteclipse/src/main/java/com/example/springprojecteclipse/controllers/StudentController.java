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
import org.springframework.web.bind.annotation.RestController;

import com.example.springprojecteclipse.model.Student;
import com.example.springprojecteclipse.repository.StudentRepository;

@RestController
public class StudentController {

	 @Autowired
	  StudentService studentService;
	 	
	 @PostMapping("/student")
	 public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
	     return ResponseEntity.ok(student);
	 }
    
    @PutMapping("/student/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student student) {
        
    	
    	Student updatedStudent =
                studentService.updateStudent(student);

        if(updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedStudent);
    	
//    	return "Student updated with id " + id;
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

	@GetMapping("/students")
	public ResponseEntity<?> getAllStudents() {
	    
		List<Student> data = studentService.getAllStudent();
		
		if (data.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data Found");
		}
		
		return ResponseEntity.ok(data);
	}
}
