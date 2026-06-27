package com.example.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationProvider;

@Configuration
@EnableWebSecurity
public class securityConfig {

	@Autowired
	UserDetailsService userdetails;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http.cors(Customizer.withDefaults()).csrf(Customizer -> Customizer.disable()).authorizeHttpRequests(request -> request
				.requestMatchers("/admin/**").hasRole("ADMIN")
				
//				.requestMatchers("/user/**").permitAll()
//				.anyRequest().authenticated()
				.anyRequest().permitAll()
				)
				
//				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		
//		 UserDetails user =
//		            User.builder()
//		                .username("tester")
//		                .password(passwordEncoder().encode("dev@123"))
//		                .roles("USER")
//		                .build();
//		
//		
//		return new InMemoryUserDetailsManager(user);
//	}
//	

	@Bean
	public AuthenticationProvider authenticationprovider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userdetails);
		provider.setPasswordEncoder(passwordEncoder());

		return (AuthenticationProvider) provider;
	}

}
