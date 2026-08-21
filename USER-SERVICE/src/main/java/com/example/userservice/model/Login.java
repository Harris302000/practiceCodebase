package com.example.userservice.model;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.hibernate.grammars.hql.HqlParser.OffsetDateTimeWithMinutesContext;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;

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
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	private String dob;
	
	@Pattern(
	        regexp = "^[0-9]{10}$",
	        message = "Mobile number must contain exactly 10 digits"
	    )
	private String mobileno;
	
//	@Email(message = "Invalid email format")
	@Pattern(
	        regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
	        message = "Invalid email format"
	    )
	private String emailid;
	
	private String role;
	
	
	private LocalDateTime createdAt;
	
	private LocalDateTime lastLoginAt;
	
//	@OneToMany(mappedBy = "login", cascade = CascadeType.ALL)
//	@ToString.Exclude
//	private List<AddressDetails> address;
	
	public Login() {
		System.out.println("Calling login constructor");
	}
	

}
