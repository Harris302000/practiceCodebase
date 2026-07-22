package com.example.demo.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	
	
	
	@Bean
	public OpenAPI openapi(@Value("${API-Version}") String version) {
		
		
		List<String> tagss = Arrays.asList("Open");
		return new OpenAPI().info(new Info()
				.title("Car Details API")
				.version(version)
				.description("Perform RestApi for Car Details")
				.summary("Car Restful API")
				.contact(new Contact().email("harrisfernando30@gmail.com").name("Agnes Harris"))
				);
		
	}
	
}
