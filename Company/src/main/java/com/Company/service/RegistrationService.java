package com.Company.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Company.request.RegistrationRequest;
import com.Company.response.RegistrationResponse;

@Service
public interface RegistrationService {
	
	public List<RegistrationResponse> getRegistrationdetails();
	
	public String save(RegistrationRequest regrequest);
	
	public RegistrationResponse getById(Long id);
	
	public String deleteRegistartion(Long id);

}
