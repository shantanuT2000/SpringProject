package com.Company.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Company.entity.UserModel;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<UserModel,Long> {

	@Override
	public List<UserModel> findAll();

	@Transactional
	@Modifying
	@Query("update UserModel set isDeleted=true where id=:id")
	public void deleteById(@Param("id") Long id);
	
	public List<UserModel> findByIsDeletedFalse();
}
