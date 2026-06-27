package com.example.userservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userservice.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	 
	Optional<Login> findByUsername(String username);
	
	
	List<Login> findByemailid(String emailid);
	
	
	List<Login> findBymobileno(String mobileno);
}
