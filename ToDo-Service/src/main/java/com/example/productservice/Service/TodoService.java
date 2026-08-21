package com.example.productservice.Service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.productservice.Repository.ToDoRepository;
import com.example.productservice.model.ToDoModel;

@Service
public class TodoService {

	@Autowired
	ToDoRepository todorepository;
	
	
	public List<ToDoModel> getAllData(){
		
		return todorepository.findAll() ;
	}
	
	
	public void deleteData(int id) {
		todorepository.deleteById(id);
	}
	
	
	public ResponseEntity<?>  addData(ToDoModel model) {

		todorepository.save(model);
		
		
//		return todorepository.findAll().stream().sorted(Comparator.comparing(ToDoModel::getId)).toList();
		
		
		return ResponseEntity.accepted().body("Addedd Successfully");
	}
	
	
	public ResponseEntity<?> updateData(ToDoModel model, int id) {
		
		
		System.out.println("model::"+model);
		
		ToDoModel to =  todorepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo data not found"));
		
		
		if(model.getDescription() != null) {
			to.setDescription(model.getDescription());
		}
		
		
		if(model.getDescription() == null) {
			to.setChecked(model.isChecked());
		}
		
		
		return ResponseEntity.ok(todorepository.save(to));
		
	}
	
}
