package com.example.userservice.controllers;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.DTO.UserResponse;
import com.example.userservice.genericfunctions.ResponseCreator;
import com.example.userservice.model.Login;
import com.example.userservice.service.LoginService;

import jakarta.validation.Valid;

@RestController
@Validated
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:5173"})

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
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseCreator("Error in fetch login details", HttpStatus.NOT_FOUND.value()));
		}
		
		
		if(!logindets.get().equalsIgnoreCase("Login successfully")) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseCreator(logindets.get(), HttpStatus.FORBIDDEN.value()));
		}
		

		return ResponseEntity.status(HttpStatus.OK).body(new ResponseCreator(logindets.get(), HttpStatus.OK.value()));
	}
	
	

	@PostMapping(value = "/user/createuser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createuserRequest(@Valid @RequestBody Login Login) {

		Optional<String> reponse = loginservice.createNewUser(Login);

		if (reponse == null) {
			ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseCreator("Error while creating user", HttpStatus.NOT_FOUND.value()));
		} else if(!reponse.get().contains("success")) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseCreator(reponse.get(), HttpStatus.FOUND.value()));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseCreator(reponse.get(), HttpStatus.OK.value()));
		}
		
		return null;

	}

	
	@DeleteMapping("/admin/deleteuser")
	public ResponseEntity<?> deleteuserRequest(@RequestParam String username) {

		String reponse = loginservice.deleteuser(username);

		if (reponse == null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseCreator("Error while deleting user", HttpStatus.NOT_FOUND.value()));
		}

		return ResponseEntity.status(HttpStatus.OK).body(new ResponseCreator(reponse, HttpStatus.OK.value()));
	}
	
	
	
	@GetMapping("/admin/all-users")
	public List<UserResponse> getallusers() {

		return loginservice.getallusers();
	}

}
