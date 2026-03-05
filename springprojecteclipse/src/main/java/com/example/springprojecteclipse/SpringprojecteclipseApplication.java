package com.example.springprojecteclipse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.StudentTest.Student;


//@SpringBootApplication
public class SpringprojecteclipseApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringprojecteclipseApplication.class, args);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(PackConfigurations.class);
		
		Student student = (Student) context.getBean("student");
		
	}

}
