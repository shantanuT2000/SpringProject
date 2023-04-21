package com.Company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;


import com.Company.entity.CompanyModel;

import jakarta.transaction.Transactional;


public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {

	public List<CompanyModel> findByIsDeletedFalse();
	
	@Transactional
	@Modifying
//	@Query("update CompanyModel set isDeleted=true where id=:id")
//	public int deleteById(@Param("id") Long id);
	
	public CompanyModel getById(Long id);
	
}
