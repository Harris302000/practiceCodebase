package com.example.springprojecteclipse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	public List<String> getStudent() {
		
		System.out.println("Student Service Called");

		List<String> students = new ArrayList<>();
        students.add("Agnes");
        students.add("John");
        students.add("David");
        return students;
    }
}
