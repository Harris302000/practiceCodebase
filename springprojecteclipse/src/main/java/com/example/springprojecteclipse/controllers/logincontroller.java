package com.example.springprojecteclipse.controllers;

import java.awt.PageAttributes.MediaType;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.springprojecteclipse.genericfunctions.ResponseCreator;
import com.example.springprojecteclipse.model.login;
import com.example.springprojecteclipse.service.LoginService;

@RestController
@Validated
public class logincontroller {
	
	@Autowired
	LoginService loginservice;
	 
	
	@GetMapping("/user/verifylogin")
	public ResponseEntity<?> verifyLoginData(@RequestHeader String username,
			@RequestHeader("X-Password") String password) {

		System.out.println("Inside verifyLoginData call");

		Optional<String> logindets = loginservice.verifyLoginDetails(username, password);
		System.out.println("logindets::" + logindets);

		if (logindets == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseCreator("Error in fetch login details", HttpStatus.NOT_FOUND.value()));
		}

		return ResponseEntity.status(HttpStatus.OK).body(new ResponseCreator(logindets.get(), HttpStatus.OK.value()));
	}
	
	
	@PostMapping(value = "/user/createuser",
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<?> createuserRequest(@RequestBody login Login) {

		Optional<String> reponse = loginservice.createNewUser(Login);
		
		if(reponse == null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseCreator("Error while creating user", HttpStatus.NOT_FOUND.value()));
		}

		return ResponseEntity.status(HttpStatus.OK).body(new ResponseCreator(reponse.get(), HttpStatus.OK.value()));
	}
	
	
	

}
