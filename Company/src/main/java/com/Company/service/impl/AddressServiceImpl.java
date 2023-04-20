package com.Company.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Company.entity.AddressModel;
import com.Company.repository.AddressRepository;
import com.Company.request.AddressRequest;
import com.Company.response.AddressResponse;
import com.Company.service.AddressService;
import com.Company.transformer.RequestConverter;
import com.Company.transformer.ResponseConverter;

@Component
public class AddressServiceImpl implements AddressService{

	
	@Autowired
	RequestConverter toEntityConverter;
	
	@Autowired
	ResponseConverter toResponse;
	
	@Autowired
	AddressRepository addressRepo;
	
	@Override
	public List<AddressResponse> getAddress() {
		
		return toResponse.toAddressResponseList(addressRepo.findByIsDeletedFalse())   ;
		
	}

	@Override
	public String saveAddress(AddressRequest addressRequest) {
		
		
		AddressModel addressEntity = toEntityConverter.toAddressEntity(addressRequest);
		addressRepo.save(addressEntity);
		return "saved";
	}

	@Override
	public AddressResponse getById(Long id) {
		
		AddressModel model = addressRepo.getById(id);
				return toResponse.entityToAddressResponse(model);
	}

	@Override
	public String deleteAddress(Long id) {
		
		Optional<AddressModel> model = addressRepo.findById(id);
		if(model.isPresent()) {
			addressRepo.deleteById(id);
			return "Deleted";
		}
		else {
			return "Entity not found error";
		}
		
				
	}
	
	

	
	
	

}
