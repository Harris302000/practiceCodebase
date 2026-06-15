package com.example.springprojecteclipse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

		return http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
			//.formLogin(Customizer.withDefaults())
			.httpBasic(Customizer.withDefaults())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.build();
    }
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		
//		UserDetails user = User.withUsername("user")
//				.password(passwordEncoder().encode("password"))
//				.roles("USER")
//				.build();
//		
		
		List<UserDetails> users = new ArrayList<>();
		
		UserDetails user1 = User.withDefaultPasswordEncoder()
				.username("").password("").roles("USER").build();
		
		UserDetails user2 = User.withDefaultPasswordEncoder()
				.username("").password("").roles("USER").build();
		
		UserDetails user3 = User.withDefaultPasswordEncoder()
				.username("").password("").roles("USER").build();
		
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		//return new InMemoryUserDetailsManager(users);
		return new InMemoryUserDetailsManager(user1,user2,user3);
	}
	
	
	
}
