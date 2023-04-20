package com.Company.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Company.request.UserRequest;
//import com.Company.entity.UserModel;
import com.Company.response.UserResponse;

@Service

public interface UserService {

	public List<UserResponse> getUsers();
	
	public String saveUser(UserRequest userRequest);
	
	public String updateUser(Long id,UserRequest userRequest);
	
	public String deleteUser(Long id);
}
