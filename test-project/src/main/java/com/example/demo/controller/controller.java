package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cars;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotNull;


@RestController
@RequestMapping("/cars")
public class controller {

	private static List<Cars> carDetails = new ArrayList<Cars>();
	
	@GetMapping(value = "/{CarName}")
	public List<Cars> getAllCars(@PathVariable String CarName,@RequestParam String year){
		System.out.println("carDetails::"+carDetails.size());
		return carDetails;
	}
	
	
	@Operation(
		    summary = "Add Car",
		    description = "Creates a new car"
		)
	@PostMapping
	public Cars addCarDetails(@RequestBody Cars cars, @RequestHeader String key  ) {
		
		System.out.println("carDetails::"+carDetails.size());
		System.out.println("cars::"+cars.getCarName());
		System.out.println("cars::"+cars.getYear());
		
		carDetails.add(cars);
		
		System.out.println("carDetails::"+carDetails.size());
		
		return cars;
	}
}
