package com.Company.transformer;

import org.springframework.stereotype.Component;

import com.Company.entity.AddressModel;
import com.Company.entity.CompanyModel;
import com.Company.entity.RegistrationModel;
import com.Company.entity.UserModel;
import com.Company.request.AddressRequest;
import com.Company.request.CompanyRequest;
import com.Company.request.RegistrationRequest;
import com.Company.request.UserRequest;

@Component
public class RequestConverter {
	
	public UserModel toUserEntity(UserRequest userRequest) {
		
		UserModel userEntity = new UserModel();
        
		userEntity.setId(userRequest.getId());
		userEntity.setEmail(userRequest.getEmail());
		userEntity.setFirstName(userRequest.getFirstname());
        userEntity.setLastName(userRequest.getLastname());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setType(userRequest.getType());
//        userEntity.setCompanyUsers(userRequest.getCompany());
       return userEntity;
	}
	
	public CompanyModel toCompanyEntity(CompanyRequest companyRequest) {
		
		CompanyModel companyModel = new CompanyModel();
		
		companyModel.setId(companyRequest.getId());
		companyModel.setCompanyId(companyRequest.getCompanyId());
		companyModel.setLegalName(companyRequest.getLegalName());
		companyModel.setPhoneNo(companyRequest.getPhoneNo());
		companyModel.setRegistration(companyRequest.getRegistration());
		companyModel.setUsers(companyRequest.getUsers());
		companyModel.setAddress(companyRequest.getAddress());
		
	return companyModel;
	}
	
	public AddressModel toAddressEntity(AddressRequest addressRequest) {
		
		AddressModel addressModel = new AddressModel();
		
		addressModel.setId(addressRequest.getId());
		addressModel.setCity(addressRequest.getCity());
		addressModel.setPincode(addressRequest.getPincode());
		addressModel.setState(addressRequest.getState());
		
		return addressModel;
	}
	
	public RegistrationModel toRegistrationModel(RegistrationRequest regRequest) {
		
		RegistrationModel regModel = new RegistrationModel();
		
		regModel.setId(regRequest.getId());
		regModel.setCompany(regRequest.getCompany());
		regModel.setDate(regRequest.getDate());
		regModel.setLegalName(regRequest.getLegalName());
		regModel.setRegistrationId(regRequest.getRegistrationId());
		
		return regModel;
		
	}


}
