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

import com.Company.request.AddressRequest;
import com.Company.response.AddressResponse;
import com.Company.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	
	@Autowired
	AddressService addressService;
	
	
	@GetMapping
	public ResponseEntity<List<AddressResponse>> getAddress(){
		return ResponseEntity.ok(addressService.getAddress());
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveAddress(@RequestBody AddressRequest addressRequest){
		
		addressService.saveAddress(addressRequest);
		return ResponseEntity.ok("Saved");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AddressResponse> getAddressById(@PathVariable Long id){
		return ResponseEntity.ok(addressService.getById(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAdress(@PathVariable Long id){
		return ResponseEntity.ok(addressService.deleteAddress(id));
	}
	
}
