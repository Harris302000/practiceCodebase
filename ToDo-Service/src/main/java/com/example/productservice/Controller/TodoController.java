package com.example.productservice.Controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.Service.TodoService;
import com.example.productservice.model.ToDoModel;

import jakarta.validation.Valid;

@CrossOrigin(value = {"http://localhost:5173/","http://localhost:5174/","https://harrisfdo-todo-app.vercel.app"})
@RestController
@RequestMapping("/Todo")
public class TodoController {

	@Autowired
	TodoService todoservice;
	
	
	@GetMapping
	public String checkApplication(){
		
		return "Hi, Welcome Home";
	}
	
	
	@GetMapping("/AllData")
	public List<ToDoModel> getAllData(){
		
		return todoservice.getAllData().stream().sorted(Comparator.comparing(ToDoModel::getId)).toList();
	}
	
	
	@DeleteMapping("/DeteleData/{id}")
	public void deleteData(@PathVariable int id) {
		
		todoservice.deleteData(id);
	}
	
	@PostMapping("/AddData")
	public ResponseEntity<?> addData(@Valid @RequestBody ToDoModel model) {
		
		return todoservice.addData(model);
	}
	
	
	@PatchMapping(value ="/Update/Description/{id}", consumes = "application/json")
	public ResponseEntity<?> updateDescription(@RequestBody ToDoModel model, @PathVariable int id) {
		
		return todoservice.updateData(model, id);
		
	}
	
	@PatchMapping(value ="/Update/CheckBox/{id}", consumes = "application/json")
	public ResponseEntity<?> updateCheckBox(@RequestBody ToDoModel model, @PathVariable int id) {
		
		return todoservice.updateData(model, id);
		
	}
	
	
	
	
}
