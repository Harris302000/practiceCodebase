package com.example.springprojecteclipse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springprojecteclipse.model.Student;


@SpringBootApplication
public class SpringprojecteclipseApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringprojecteclipseApplication.class);
	}

	public static void main(String[] args) {

		System.out.println("Hello World!");

		ApplicationContext context = SpringApplication.run(SpringprojecteclipseApplication.class, args);


	}

}
