package com.example.userservice.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userservice.DTO.UserResponse;
import com.example.userservice.feignclient.OrderFeignClient;
import com.example.userservice.model.AddressDetails;
import com.example.userservice.model.Login;
import com.example.userservice.repository.LoginRepository;


@Service
public class LoginService {

	@Autowired
	private LoginRepository loginrepository;

	@Autowired
	private BCryptPasswordEncoder PasswordEncoder;
	
	@Autowired
    private OrderFeignClient orderFeignClient;
	
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

	public List<UserResponse> getallusers() {

		
		List<Login> users = loginrepository.findAll();

        List<UserResponse> response = new ArrayList<>();
		
        for(Login user : users) {

            UserResponse dto = new UserResponse();

            dto.setUserid(user.getUserid());
            dto.setUsername(user.getUsername());
//            dto.setPassword(user.getPassword());
            dto.setDob(user.getDob());
            dto.setMobileno(user.getMobileno());
            dto.setEmailid(user.getEmailid());
            dto.setRole(user.getRole());
            dto.setCreatedAt(user.getCreatedAt());
            dto.setLastLoginAt(user.getLastLoginAt());
            dto.setAddress(user.getAddress());

            // Feign Client Call
            Long count = orderFeignClient.getallordercountByUserID(user.getUserid(),"PLACED");
            dto.setTotalOrders(count);
            response.add(dto);

        }

        return response;
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
