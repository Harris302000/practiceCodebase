package com.example.springprojecteclipse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springprojecteclipse.model.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

}
