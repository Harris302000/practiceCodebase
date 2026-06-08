package com.example.springprojecteclipse.model;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "students")
public class Student {

//	@Id
//	private String name;
//	
//	@Min(18)
//	private int age;
//
//	@NotBlank(message = "ID is mandatory")
//	private String id;
	

	@Id
	@NotBlank(message = "ID is mandatory")
    private String id;

    private String name;

    private Integer age;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}



	
	public Student () {
		System.out.println("Calling Student Constructor");
	}
	
	
	
}
