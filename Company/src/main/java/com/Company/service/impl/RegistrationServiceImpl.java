package com.Company.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.Company.entity.RegistrationModel;
import com.Company.repository.RegistrationRepository;
import com.Company.request.RegistrationRequest;

import com.Company.response.RegistrationResponse;
import com.Company.service.RegistrationService;

import com.Company.transformer.RequestConverter;
import com.Company.transformer.ResponseConverter;

@Component
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	RegistrationRepository regRepo;
	
	@Autowired
	RequestConverter toEntityConverter;
	
	@Autowired
	ResponseConverter toResponse;

	@Override
	public List<RegistrationResponse> getRegistrationdetails() {
		
		return toResponse.toRegistrationResponseList(regRepo.findByIsDeletedFalse());
	}

	@Override
	public String save(RegistrationRequest regrequest) {
		
		RegistrationModel regEntity = toEntityConverter.toRegistrationModel(regrequest);
		regRepo.save(regEntity);
		
		return "Saved";
	}
	
	@Override
	public RegistrationResponse getById(Long id) {
		
		RegistrationModel model = regRepo.getById(id);
				return toResponse.entityToRegResponse(model);
	}

	@Override
	public String deleteRegistartion(Long id) {
		
		Optional<RegistrationModel> model = regRepo.findById(id);
		if(model.isPresent()) {
			regRepo.deleteById(id);
			return "Deleted";
		}
		else {
			return "Entity not found error";
		}
				
	}
	
	
	
	
	
	
}
