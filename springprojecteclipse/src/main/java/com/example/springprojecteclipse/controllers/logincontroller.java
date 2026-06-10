package com.example.springprojecteclipse.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.springprojecteclipse.genericfunctions.ResponseCreator;
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
	
	
	

}
