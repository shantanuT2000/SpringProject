package com.Company.service;

import java.util.List;


import com.Company.request.AddressRequest;
import com.Company.response.AddressResponse;

public interface AddressService {

	public List<AddressResponse> getAddress();
	
	public String saveAddress(AddressRequest addressRequest);
	
	public AddressResponse getById(Long id);
	
	public String deleteAddress(Long id);
	
}
