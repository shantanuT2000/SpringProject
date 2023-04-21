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
	UserRepository userRepository;
	
	@Autowired 
	RequestConverter  requestConverter;
	
	@Autowired
	ResponseConverter responseConverter;

	@Override
	public List<UserResponse> getUsers() {
		
		List<UserModel> user = userRepository.findAll();
		
		return responseConverter.toUserResponseList(user);
		
	}
	
	@Override
	public String saveUser(UserRequest userRequest) {
		UserModel userEntity = requestConverter.toUserEntity(userRequest);
	    userRepository.save(userEntity);
		return "saved";
	}

	@Override
	public String updateUser(Long id,UserRequest userRequest) {
		Optional<UserModel> user = userRepository.findById(id);
		if(user.isPresent()) {
			UserModel savedEntity = user.get();
			savedEntity.setEmail(userRequest.getEmail());
			savedEntity.setFirstName(userRequest.getFirstname());
			savedEntity.setLastName(userRequest.getLastname());
			savedEntity.setPassword(userRequest.getPassword());
			savedEntity.setType(userRequest.getType());
			
			userRepository.save(savedEntity);
			return "Updated";
		}
		
		return "User Not found";
	}

	@Override
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		return "Deleted";
	}

	@Override
	public UserResponse getUserById(Long id) {
		
		UserModel model = userRepository.getById(id);
		
		return responseConverter.entityToUserResponse(model);
	}
	
	
	
	
	
	
	

}
