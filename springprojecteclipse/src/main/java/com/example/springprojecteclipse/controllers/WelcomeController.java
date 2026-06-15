package com.example.springprojecteclipse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class WelcomeController {

	@GetMapping("/test")
	public String test() {
	    return "WildFly + Spring Boot working!";
	}
	
	@GetMapping("/")
	public String wecome(HttpServletRequest obj) {
	    return "Welcome To My Page--->Session ID is "+obj.getSession().getId();
	}
	
	@GetMapping("/hello")
    public String hello() {
        return "Spring Boot working";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Boot";
    }
}
