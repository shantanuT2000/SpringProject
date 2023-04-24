package com.Company.transformer;

import java.util.List;
import java.util.stream.Collectors;

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
        
		userEntity.setEmail(userRequest.getEmail());
		userEntity.setFirstName(userRequest.getFirstname());
        userEntity.setLastName(userRequest.getLastname());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setType(userRequest.getType());
        userEntity.setCompany(userRequest.getCompany());
        return userEntity;
	}
	
	public CompanyModel toCompanyEntity(CompanyRequest companyRequest) {
		
		CompanyModel companyModel = new CompanyModel();
		
		companyModel.setCompanyId(companyRequest.getCompanyId());
		companyModel.setLegalName(companyRequest.getLegalName());
		companyModel.setPhoneNo(companyRequest.getPhoneNo());
		companyModel.setRegistration(toRegistrationEntity(companyRequest.getRegistration()));
		companyModel.setUsers(toUserEntityList(companyRequest.getUsers()));
		companyModel.setAddress(toAddressEntity(companyRequest.getAddress()));
		
		return companyModel;
		
	}
	
	
	
	public AddressModel toAddressEntity(AddressRequest addressRequest) {
		
		AddressModel addressModel = new AddressModel();
		
//		addressModel.setId(addressRequest.getId());
		addressModel.setCity(addressRequest.getCity());
		addressModel.setPincode(addressRequest.getPincode());
		addressModel.setState(addressRequest.getState());
		
		return addressModel;
	}
	
	public RegistrationModel toRegistrationModel(RegistrationRequest regRequest) {
		
		RegistrationModel registrationModel = new RegistrationModel();
		
//		regModel.setId(regRequest.getId());
		registrationModel.setCompany(regRequest.getCompany());
		registrationModel.setDate(regRequest.getDate());
		registrationModel.setLegalName(regRequest.getLegalName());
		registrationModel.setRegistrationId(regRequest.getRegistrationId());
		
		return registrationModel;
		
	}
	
	public RegistrationModel toRegistrationEntity(RegistrationModel registrationModel) {
		
		RegistrationModel registrationEntity = new RegistrationModel();
		
		registrationEntity.setLegalName(registrationModel.getLegalName());
		registrationEntity.setDate(registrationModel.getDate());
		registrationEntity.setCompany(registrationModel.getCompany());
		registrationEntity.setRegistrationId(registrationModel.getRegistrationId());
		
		return registrationEntity;
	}
	
	public List<UserModel> toUserEntityList(List<UserModel> userList){
		
		return userList.stream().map(p-> new UserModel(p.getFirstName(),p.getLastName(),p.getType(),p.getEmail(),p.getPassword())).collect(Collectors.toList());
		
	}
	
	public AddressModel toAddressEntity(AddressModel addressModel) {
		
		AddressModel addressEntity = new AddressModel();
		addressEntity.setCity(addressModel.getCity());
		addressEntity.setPincode(addressModel.getPincode());
		addressEntity.setState(addressModel.getState());
		
		return addressEntity;
	}



}
