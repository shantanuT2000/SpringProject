package com.Company.transformer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.Company.entity.AddressModel;
import com.Company.entity.CompanyModel;
import com.Company.entity.RegistrationModel;
import com.Company.entity.UserModel;
import com.Company.response.AddressResponse;
import com.Company.response.CompanyResponse;
import com.Company.response.RegistrationResponse;
import com.Company.response.UserResponse;

@Component
public class ResponseConverter {
	
   public UserResponse entityToUserResponse(UserModel userEntity) {
	   
	   UserResponse userResponse = new UserResponse();
	   
	   userResponse.setId(userEntity.getId());
//	   userResponse.setCompany(userEntity.getCompanyUsers());
	   userResponse.setEmail(userEntity.getEmail());
	   userResponse.setFirstname(userEntity.getFirstName());
	   userResponse.setLastname(userEntity.getLastName());
	   userResponse.setType(userEntity.getType());
	   userResponse.setPassword(userEntity.getPassword());
	   return userResponse;
   }
   
   public List<UserResponse> toUserResponseList(List<UserModel> userEntityList){
	   
	   return userEntityList.stream().map(user-> entityToUserResponse(user)).collect(Collectors.toList());
   }
   
   
   public CompanyResponse entityToCompanyResponse(CompanyModel companyEntity) {
	   CompanyResponse companyResponse = new CompanyResponse();
	   
	   companyResponse.setCompanyId(companyEntity.getCompanyId());
	   companyResponse.setAddress(companyEntity.getAddress());
	   companyResponse.setLegalName(companyEntity.getLegalName());
	   companyResponse.setPhoneNo(companyEntity.getPhoneNo());
	   companyResponse.setRegistration(companyEntity.getRegistration());
	   companyResponse.setUsers(companyEntity.getUsers());
	   companyResponse.setId(companyEntity.getId());
	   
	   return companyResponse;
	   
   }
   
   public AddressResponse entityToAddressResponse(AddressModel addressEntity) {
	   
	   AddressResponse addressResponse = new AddressResponse();
	   
	   addressResponse.setCity(addressEntity.getCity());
	   addressResponse.setPincode(addressEntity.getPincode());
	   addressResponse.setState(addressEntity.getState());
	   addressResponse.setId(addressEntity.getId());
	   
	   return addressResponse;
   }
   
   public RegistrationResponse entityToRegResponse(RegistrationModel regEntity) {
	   
	   RegistrationResponse regResponse = new RegistrationResponse();
	   
	   regResponse.setId(regEntity.getId());
	   regResponse.setCompany(regEntity.getCompany());
	   regResponse.setDate(regEntity.getDate());
	   regResponse.setLegalName(regEntity.getLegalName());
	   
	   regResponse.setRegistrationId(regEntity.getRegistrationId());
	   return regResponse;
   }
   
   public RegistrationResponse eTorModel(RegistrationModel regEntity) {
	   
	   
	   return null;
   }
   
   
   
 public List<CompanyResponse> toCompanyResponseList(List<CompanyModel> companyEntityList){
	   
	   return companyEntityList.stream().map(company-> entityToCompanyResponse(company)).collect(Collectors.toList());
   }
 
 
 public List<AddressResponse> toAddressResponseList(List<AddressModel> addressModelList){
	 
	 return addressModelList.stream().map(p->new AddressResponse(p.getId(),p.getCity(),p.getState(),p.getPincode())).collect(Collectors.toList());
	 
 }
 
 public List<RegistrationResponse> toRegistrationResponseList(List<RegistrationModel> registrationModelList){
	 
	 return registrationModelList.stream().map(p->new RegistrationResponse(p.getId(),p.getRegistrationId(),p.getLegalName(),p.getDate(),p.getCompany())).collect(Collectors.toList());
 }
   
   }
