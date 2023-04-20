package com.Company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Company.request.RegistrationRequest;
import com.Company.response.RegistrationResponse;
import com.Company.service.RegistrationService;

@RestController
@RequestMapping("/Registration")
public class RegistrationController {
 
	
	@Autowired
	RegistrationService registrationService;
	
	@GetMapping
	public ResponseEntity<List<RegistrationResponse>> getRegistrationdeets(){
		
		return ResponseEntity.ok(registrationService.getRegistrationdetails());
	}
	
	@GetMapping("/{id}")
     public ResponseEntity<RegistrationResponse> getregDeetsById(@PathVariable Long id){
		
		
		return ResponseEntity.ok( registrationService.getById(id)) ;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveRegDeets(@RequestBody RegistrationRequest regRequest){
		
		return ResponseEntity.ok(registrationService.save(regRequest));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRegDeets(@PathVariable Long id){
		
		return ResponseEntity.ok(registrationService.deleteRegistartion(id));
		
	}
	
}
