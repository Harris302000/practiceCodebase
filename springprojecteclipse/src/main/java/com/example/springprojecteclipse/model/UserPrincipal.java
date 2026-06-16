package com.example.springprojecteclipse.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserPrincipal implements UserDetails{

	
	private Login login;
	
	
	public UserPrincipal(Optional<Login> login) {
		this.login = login.get();
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return  Collections.singleton(new SimpleGrantedAuthority("ROLE_"+login.getRole()));
	}

	@Override
	public @Nullable String getPassword() {
		// TODO Auto-generated method stub
		return login.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login.getUsername();
	}

	

}
