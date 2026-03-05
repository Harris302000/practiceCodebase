package com.example.springprojecteclipse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springprojecteclipse.model.Student;


@SpringBootApplication
public class SpringprojecteclipseApplication {

	public static void main(String[] args) {
		
		 System.out.println( "Hello World!" );
		 
		ApplicationContext context = SpringApplication.run(SpringprojecteclipseApplication.class,args);
		
		
		
//		Student s1 = (Student) context.getBean("student");
//		s1.setName("Agnes Harris");
//		s1.setAge(25);
//		
//		System.out.println(s1.getName()+" - "+s1.getAge());
		
		
	}

}
