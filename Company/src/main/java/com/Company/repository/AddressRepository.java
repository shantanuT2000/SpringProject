package com.Company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.Company.entity.AddressModel;


//import jakarta.transaction.Transactional;

public interface AddressRepository extends JpaRepository<AddressModel, Long> {

	public List<AddressModel> findAll();
	
//	@Transactional
//	@Modifying
//	@Query("update AddressModel set isDeleted=true where id=:id")
//	public void deleteById(@Param("id") Long id);
	
	@Override
	public AddressModel getById(Long id);
	
	
	
}
