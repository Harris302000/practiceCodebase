package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cars;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/cars")
public class controller {

	private static List<Cars> carDetails = new ArrayList<Cars>();
	
	@GetMapping
	public List<Cars> getAllCars(){
		System.out.println("carDetails::"+carDetails.size());
		return carDetails;
	}
	
	@PostMapping
	public Cars addCarDetails(@RequestBody Cars cars) {
		
		System.out.println("carDetails::"+carDetails.size());
		System.out.println("cars::"+cars.getCarName());
		System.out.println("cars::"+cars.getYear());
		
		carDetails.add(cars);
		
		System.out.println("carDetails::"+carDetails.size());
		
		return cars;
	}
}
