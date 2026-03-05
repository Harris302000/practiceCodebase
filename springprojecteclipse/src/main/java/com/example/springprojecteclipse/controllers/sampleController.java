package com.example.springprojecteclipse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sampleController {

	
//	Simple REST API (GET)
//	http://localhost:8080/hello
//		http://localhost:8080/welcome
	@GetMapping("/hello")
    public String hello() {
        return "Spring Boot working";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Boot";
    }
    
//    Path Variable
//    http://localhost:8080/user/10
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable int id) {
        return "User id is " + id;
    }
    
    
//    Request Parameter
//    http://localhost:8080/add?a=10&b=20
    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

}
