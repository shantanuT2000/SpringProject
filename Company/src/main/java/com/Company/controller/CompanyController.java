package com.Company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Company.request.CompanyRequest;
import com.Company.response.CompanyResponse;
import com.Company.service.CompanyService;
import com.Company.service.UserService;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	UserService userService;
	
	@GetMapping(path="/")
	public ResponseEntity<List<CompanyResponse>> get(){
		
		return ResponseEntity.ok(companyService.getAllCompanies());
	}
	
	@PostMapping(path="/save")
	public String saveCompany(@RequestBody CompanyRequest companyRequest) {
		return companyService.saveCompany(companyRequest);
	}
	
	@PutMapping(path="/update/{id}")
	public ResponseEntity<String> update(@PathVariable Long id,@RequestBody CompanyRequest companyRequest){
		
		return ResponseEntity.ok(companyService.updateCompany(id, companyRequest));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CompanyResponse> getCompanyById(@PathVariable Long id){
		return ResponseEntity.ok(companyService.getById(id)) ;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		return ResponseEntity.ok(companyService.deleteCompany(id));
	}


}
