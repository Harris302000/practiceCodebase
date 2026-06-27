package com.example.userservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.userservice.model.Student;

@Configuration
public class PackConfigurations {

	@Bean
	public Student student() {
		
		return new Student();
	}
}
