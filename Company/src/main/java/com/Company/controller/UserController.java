package com.Company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Company.request.UserRequest;
import com.Company.response.UserResponse;
import com.Company.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

	
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserResponse>> get() {
	 
		 return ResponseEntity.ok(userService.getUsers());
	
		 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getUserWithId(@PathVariable Long id){
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@PostMapping(path="/save")
	public ResponseEntity<String> save(@RequestBody UserRequest userRequest) {
		return ResponseEntity.ok(userService.saveUser(userRequest));
	}
	
	@PutMapping(path="/update/{id}")
	public ResponseEntity<String> updateUserk(@PathVariable Long id,@RequestBody UserRequest userRequest){
		return ResponseEntity.ok(userService.updateUser(id, userRequest));
	}
    
	@DeleteMapping(path="/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "deleted";
	}
	
	
	
}
