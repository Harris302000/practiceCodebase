package com.example.springprojecteclipse.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentTest.Student;

@RestController
public class StudentController {

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return student;
    }

}
