package com.example.springprojecteclipse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.springprojecteclipse.model.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

	
	//@Query("SELECT s FROM Student s WHERE s.id = :id AND s.name = :name")
	@Query(value = "SELECT * FROM student WHERE id = :id AND name = :name", nativeQuery = true)
	Optional<Student> findStudentByIDandName(@Param("id") String id, @Param("name") String name);
	
	
}
