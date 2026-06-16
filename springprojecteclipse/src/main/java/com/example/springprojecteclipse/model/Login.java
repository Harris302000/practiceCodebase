package com.example.springprojecteclipse.model;

import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.grammars.hql.HqlParser.OffsetDateTimeWithMinutesContext;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "userdetails")
@Data
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userid;
	
	@NotBlank(message = "Username is mandatory")
	private String username;
	
	@NotBlank(message = "Password is mandatory")
	private String password;
	
	private String dob;
	
	@Pattern(
	        regexp = "^[0-9]{10}$",
	        message = "Mobile number must contain exactly 10 digits"
	    )
	private String mobileno;
	
	@Email(message = "Invalid email format")
	private String emailid;
	
	private String role;
	
	
	private LocalDateTime createdAt;
	
	private LocalDateTime lastLoginAt;
	
	

	
	public Login() {
		System.out.println("Calling login constructor");
	}
	

}
