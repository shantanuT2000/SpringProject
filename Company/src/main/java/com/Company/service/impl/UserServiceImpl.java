package com.Company.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Company.entity.UserModel;
import com.Company.repository.UserRepository;
import com.Company.request.UserRequest;
import com.Company.response.UserResponse;
import com.Company.service.UserService;
import com.Company.transformer.RequestConverter;
import com.Company.transformer.ResponseConverter;

@Component
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired 
	RequestConverter  toEntityConverter;
	
	@Autowired
	ResponseConverter responseConverter;

	@Override
	public List<UserResponse> getUsers() {
		
		List<UserModel> user = userRepo.findByIsDeletedFalse();
		
		return responseConverter.toUserResponseList(user);
		
	}
	
	@Override
	public String saveUser(UserRequest userRequest) {
		UserModel userEntity = toEntityConverter.toUserEntity(userRequest);
	    userRepo.save(userEntity);
		return "saved";
	}

	@Override
	public String updateUser(Long id,UserRequest userRequest) {
		Optional<UserModel> user = userRepo.findById(id);
		if(user.isPresent()) {
			UserModel savedEntity = user.get();
			savedEntity.setEmail(userRequest.getEmail());
			savedEntity.setFirstName(userRequest.getFirstname());
			savedEntity.setLastName(userRequest.getLastname());
			savedEntity.setPassword(userRequest.getPassword());
			savedEntity.setType(userRequest.getType());
			
			userRepo.save(savedEntity);
			return "Updated";
		}
		
		return "User Not found";
	}

	@Override
	public String deleteUser(Long id) {
		userRepo.deleteById(id);
		return "Deleted";
	}
	
	
	
	
	
	
	

}
