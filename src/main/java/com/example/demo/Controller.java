package com.example.demo;


import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	Map<Integer, Model> peopleDB = new HashMap<Integer,Model>();
	int count = 1;

	@GetMapping("/getAllPeople")
	public Map<Integer, Model> getPerson() {
		return peopleDB;
		
	}
	
	@PostMapping("/addPerson")
	public Map<Integer, Model> addPerson(@RequestBody Model newModel) {
		peopleDB.put(count, newModel);
		count++;
		return peopleDB;
	}
	
	@DeleteMapping("/deletePerson/{id}")
	public Map<Integer,Model> deletePerson(@PathVariable int id){
		
		if(peopleDB.containsKey(id)){
			peopleDB.remove(id);
			count--;
		}
		return peopleDB;
	}
	
	
	@PutMapping("/editPerson/{id}")
	public Map<Integer, Model> editPerson(@RequestBody Model newModel,@PathVariable int id){
		
		peopleDB.replace(id, newModel);
		
		return peopleDB;
	}
	
	
}