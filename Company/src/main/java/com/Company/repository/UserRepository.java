package com.Company.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Company.entity.UserModel;


public interface UserRepository extends JpaRepository<UserModel,Long> {

	@Override
	public List<UserModel> findAll();
	
	@Override
	public UserModel getById(Long id);
	
	public List<UserModel> findByIsDeletedFalse();

}
