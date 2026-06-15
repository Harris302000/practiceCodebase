package com.example.springprojecteclipse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sampleController {

	
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
