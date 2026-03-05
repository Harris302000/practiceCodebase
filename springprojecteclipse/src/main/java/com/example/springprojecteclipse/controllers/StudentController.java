package com.example.springprojecteclipse.controllers;

import java.util.ArrayList;
import java.util.List;
import com.example.springprojecteclipse.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springprojecteclipse.model.Student;

@RestController
public class StudentController {

//    private final StudentService studentService;
//
//    StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
	 @Autowired
	  StudentService studentService;
	
	
//	http://localhost:8080/student
//    @PostMapping("/student")
//    public Student createStudent(@RequestBody Student student) {
//        return student;
//    }
	 @PostMapping("/student")
	 public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
	     return ResponseEntity.ok(student);
	 }
    
    @PutMapping("/student/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student) {
        return "Student updated with id " + id;
    }
    
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {
        return "Student deleted with id " + id;
    }
    
    @GetMapping("/students")
    public List<String> getStudents() {

       return studentService.getStudent();
    }

}
