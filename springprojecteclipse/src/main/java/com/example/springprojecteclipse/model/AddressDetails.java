package com.example.springprojecteclipse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "addressdetails")
@Data
public class AddressDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int addressid;
	
	private String addresstype;
	
	private String addressline1;
	
	private String addressline2;
	
	private String addressline3;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String pincode;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	@ToString.Exclude
	@JsonIgnore
    private Login login;
}
