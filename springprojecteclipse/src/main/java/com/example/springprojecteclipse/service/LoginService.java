package com.example.springprojecteclipse.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springprojecteclipse.model.login;
import com.example.springprojecteclipse.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginrepository;

	@Autowired
	private BCryptPasswordEncoder PasswordEncoder;

	public Optional<login> verifyusername(String username) {

		System.out.println("Inside verifyusername Method");

		Optional<login> userdets = loginrepository.findByUsername(username);
		System.out.println("userdets::" + userdets);

		if (userdets.isEmpty()) {
			return null;
		}

		return userdets;

	}

	public Optional<String> verifyuserpassword(Optional<login> userdets, String password) {

		System.out.println("Inside verifyuserpassword Method");

		System.out.println("userdets.get().getPassword()::" + userdets.get().getPassword());

		if (PasswordEncoder.matches(password, userdets.get().getPassword())) {
			return Optional.ofNullable("Logged in successfully");
		}

		return Optional.ofNullable("Invalid Password");

	}

	public Optional<String> verifyLoginDetails(String username, String password) {

		System.out.println("Inside verifyLoginDetails Method");

		Optional<login> usernameRet = verifyusername(username);

		System.out.println("usernameRet::" + usernameRet);

		if (usernameRet == null) {
			return Optional.ofNullable("User Data Not Found");
		}

		System.out.println("usernameRet::" + usernameRet.get().getUsername());

		Optional<String> passwordRet = verifyuserpassword(usernameRet, password);
		System.out.println("passwordRet::" + passwordRet);

		return passwordRet;

	}
	
	
	public Optional<String> createNewUser(login Login){
		
		Optional<login> userstatus = verifyusername(Login.getUsername());
		
		if(userstatus != null) {
			return Optional.of("User name already exist");
		}
		
		String encodePassword = PasswordEncoder.encode(Login.getPassword());
		Login.setPassword(encodePassword);
		
		loginrepository.save(Login);
		
		
		return Optional.of("User created successfully");
	}
	
	
	
	
	
	
}
