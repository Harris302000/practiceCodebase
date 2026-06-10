package com.example.springprojecteclipse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springprojecteclipse.model.login;

@Repository
public interface LoginRepository extends JpaRepository<login, Integer>{
	 
	Optional<login> findByUsername(String username);
}
