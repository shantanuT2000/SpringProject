package com.Company.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Company.entity.CompanyModel;
import com.Company.entity.UserModel;
import com.Company.repository.CompanyRepository;
import com.Company.repository.UserRepository;
import com.Company.request.UserRequest;
import com.Company.response.UserResponse;
import com.Company.service.UserService;
import com.Company.transformer.RequestConverter;
import com.Company.transformer.ResponseConverter;

@Component
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired 
	private RequestConverter  requestConverter;
	
	@Autowired
	private ResponseConverter responseConverter;

	@Override
	public List<UserResponse> getUsers() {
		
		List<UserModel> userModelList = null;
		
		try {
			userModelList = userRepository.findByIsDeletedFalse();
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		return responseConverter.toUserResponseList(userModelList);
		
	}
	
	@Override
	public String saveUser(UserRequest userRequest) {
		
		try 
		{
			UserModel userEntity = requestConverter.toUserEntity(userRequest);
		    userRepository.save(userEntity);
		    return "saved";
		    
		}
		catch(Exception e) {
			
			return e.getMessage();
			
		}
		
	}
	
	@Override
	public List<UserResponse> getUsersByCompanyId(Long id){
		
		try {
			  Optional<CompanyModel> optionalCompanyModel= companyRepository.findById(id); 
			    if(optionalCompanyModel.isPresent()) {
			    	CompanyModel companyModel = optionalCompanyModel.get();
			    	List<UserModel> userModelList = companyModel.getUsers();
			    	return responseConverter.toUserResponseList(userModelList);
			    }
			    return null;
		}
		catch(Exception e) {
			e.getMessage();
			return null;
		}
		
	  
		
	}

	@Override
	public String updateUser(Long id,UserRequest userRequest) {
		
		try {
			Optional<UserModel> user = userRepository.findById(id);
			if(user.isPresent()) {
				UserModel savedEntity = user.get();
				savedEntity.setEmail(userRequest.getEmail());
				savedEntity.setFirstName(userRequest.getFirstname());
				savedEntity.setLastName(userRequest.getLastname());
				savedEntity.setPassword(userRequest.getPassword());
				savedEntity.setType(userRequest.getType());
				
				try {
					userRepository.save(savedEntity);

				}
				catch(Exception e) {
					e.getMessage();
				}
				return "Updated";
			}
			
			return "User Not found";
		}
		catch(Exception e) {
			return e.getMessage();
		}

	}

	@Override
	public String deleteUser(Long id) {
		
		try {
			Optional<UserModel> optionalUserModel = userRepository.findById(id);
			
			if(optionalUserModel.isPresent()) {
				UserModel newUserModel = optionalUserModel.get();
				newUserModel.setIsDeleted(true);
				
				try {
					userRepository.save(newUserModel);
				}
				
				catch(Exception e) {
					e.getMessage();
				}
				return "Deleted";
			}
			else {
				return "User Not found error";
			}
			
			
		}
		catch(Exception e) {
			return e.getMessage();
		}
		
		
	}

	@Override
	public UserResponse getUserById(Long id) {
		
		UserModel userModel = null;
		
		try {
			 userModel = userRepository.getById(id);
		}
		catch(Exception e) {
			e.getMessage();
		}
		
	 return responseConverter.entityToUserResponse(userModel);
	}
	
	
	
	
	
	
	

}
