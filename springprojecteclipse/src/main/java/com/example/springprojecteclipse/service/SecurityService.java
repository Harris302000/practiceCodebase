package com.example.springprojecteclipse.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springprojecteclipse.model.Login;
import com.example.springprojecteclipse.model.UserPrincipal;
import com.example.springprojecteclipse.repository.LoginRepository;

@Service
public class SecurityService implements UserDetailsService{

	@Autowired
	private LoginRepository loginrepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Login> userdetail = loginrepository.findByUsername(username);
		
		if(userdetail.isEmpty()) {
			throw new UsernameNotFoundException("User Not Found");
		}
		
		return new UserPrincipal(userdetail);
	}


}
