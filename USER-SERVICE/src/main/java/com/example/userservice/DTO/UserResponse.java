package com.example.userservice.DTO;

import java.time.LocalDateTime;
import java.util.List;

import com.example.userservice.model.AddressDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;

@Data
public class UserResponse {

	private int userid;

	private String username;

//	private String password;

	private String dob;

	private String mobileno;

	private String emailid;

	private String role;

	private LocalDateTime createdAt;

	private LocalDateTime lastLoginAt;

	private List<AddressDetails> address;
	
	private Long totalOrders;

}