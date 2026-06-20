package com.example.springprojecteclipse.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springprojecteclipse.model.AddressDetails;
import com.example.springprojecteclipse.model.Login;
import com.example.springprojecteclipse.repository.LoginRepository;


@Service
public class LoginService {

	@Autowired
	private LoginRepository loginrepository;

	@Autowired
	private BCryptPasswordEncoder PasswordEncoder;
	
	LocalDateTime datetime =  LocalDateTime.now();

	public Optional<Login> verifyusername(String username) {

		System.out.println("Inside verifyusername Method");

		Optional<Login> userdets = loginrepository.findByUsername(username);
		System.out.println("userdets::" + userdets);

		if (userdets.isEmpty()) {
			return null;
		}

		return userdets;

	}
	
	public List<Login> verifyemailid(String emailid) {

		System.out.println("Inside verifyemailid Method");

		List<Login> emaildets = loginrepository.findByemailid(emailid);
		System.out.println("emaildets::" + emaildets);

		if (emaildets.isEmpty()) {
			return null;
		}

		return emaildets;

	}
	
	public List<Login> verifyMobileNo(String mobileno) {

		System.out.println("Inside verifyMobileNo Method");

		List<Login> mobiledets = loginrepository.findBymobileno(mobileno);
		System.out.println("mobiledets::" + mobiledets);

		if (mobiledets.isEmpty()) {
			return null;
		}

		return mobiledets;

	}

	public Optional<String> verifyuserpassword(Optional<Login> userdets, String password) {

		System.out.println("Inside verifyuserpassword Method");

		System.out.println("userdets.get().getPassword()::" + userdets.get().getPassword());

		if (PasswordEncoder.matches(password, userdets.get().getPassword())) {
			return Optional.ofNullable("Login successfully");
		}

		return Optional.ofNullable("Invalid Password");

	}

	public Optional<String> verifyLoginDetails(String username, String password) {

		System.out.println("Inside verifyLoginDetails Method");

		Optional<Login> usernameRet = verifyusername(username);

		System.out.println("usernameRet::" + usernameRet);

		if (usernameRet == null) {
			return Optional.ofNullable("User Data Not Found");
		}

		System.out.println("usernameRet::" + usernameRet.get().getUsername());

		Optional<String> passwordRet = verifyuserpassword(usernameRet, password);
		System.out.println("passwordRet::" + passwordRet);

		
		
		usernameRet.get().setLastLoginAt(datetime);
		loginrepository.save(usernameRet.get());
		
		return passwordRet;

	}

	public Optional<String> createNewUser(Login login) {

		Optional<Login> userstatus = verifyusername(login.getUsername());

		if (userstatus != null) {
			return Optional.of("User name already exist");
		}
		
		List<Login> emailstatus = verifyemailid(login.getEmailid());

		if (emailstatus != null) {
			return Optional.of("Email ID already exist");
		}
		
		List<Login> mobilestatus = verifyMobileNo(login.getMobileno());
		if (mobilestatus != null) {
			return Optional.of("Mobile Number already exist");
		}

		String encodePassword = PasswordEncoder.encode(login.getPassword());
		login.setPassword(encodePassword);
		
		if (login.getRole() == null || login.getRole().isBlank()) {
			login.setRole("USER");
		}
		
		
		if (login.getAddress() != null) {
		    for (AddressDetails address : login.getAddress()) {
		        address.setLogin(login);
		    }
		}
		
		
		login.setCreatedAt(datetime);

		loginrepository.save(login);

		return Optional.of("User created successfully");
	}

	public List<Login> getallusers() {

		return loginrepository.findAll();
	}
	
	public String deleteuser(String username) {
		
		System.out.println("deleteuser::username::"+username);
	    Optional<Login> userdets =  verifyusername(username);
		
	    if(userdets == null || userdets.isEmpty()) {
	    	return "No user data found for deletion";
	    }
		
	    loginrepository.delete(userdets.get());
		
		return "User delete successfully";
	}

}
