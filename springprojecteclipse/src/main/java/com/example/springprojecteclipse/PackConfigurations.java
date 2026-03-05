package com.example.springprojecteclipse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springprojecteclipse.model.Student;

@Configuration
public class PackConfigurations {

	@Bean
	public Student student() {
		
		return new Student();
	}
}
