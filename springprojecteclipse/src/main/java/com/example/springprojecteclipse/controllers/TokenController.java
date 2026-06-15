package com.example.springprojecteclipse.controllers;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class TokenController {
	
	
	@GetMapping("/csrf-token")
	public CsrfToken getCSRFToken(CsrfToken token) {
		
		return token;
	}
	

}
