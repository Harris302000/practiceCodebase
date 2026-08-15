package com.example.productservice.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productservice.model.ToDoModel;

@Repository
public interface ToDoRepository  extends JpaRepository<ToDoModel, Integer>{
	
//	List<ToDoModel> findByIdOrderById(int id);

}
