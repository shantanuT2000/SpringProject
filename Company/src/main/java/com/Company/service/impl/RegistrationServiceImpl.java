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
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private RequestConverter requestConverter;
	
	@Autowired
	private ResponseConverter responseConverter;

	@Override
	public List<RegistrationResponse> getRegistrationdetails() {
		
		return responseConverter.toRegistrationResponseList(registrationRepository.findByIsDeletedFalse());
	}

	@Override
	public String save(RegistrationRequest regrequest) {
		
		RegistrationModel regEntity = requestConverter.toRegistrationModel(regrequest);
		
		registrationRepository.save(regEntity);
		
		return "Saved";
	}
	
	@Override
	public RegistrationResponse getById(Long id) {
		
		RegistrationModel model = registrationRepository.getById(id);
				return responseConverter.entityToRegResponse(model);
	}

	@Override
	public String deleteRegistartion(Long id) {
		
		Optional<RegistrationModel> model = registrationRepository.findById(id);
		if(model.isPresent()) {
//			registrationRepository.deleteById(id);
			
			return "Deleted";
		}
		else {
			return "Entity not found error";
		}
				
	}
	
	
	
	
	
	
}
