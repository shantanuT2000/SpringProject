package com.Company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import com.Company.entity.RegistrationModel;
//import jakarta.transaction.Transactional;

public interface RegistrationRepository extends JpaRepository<RegistrationModel, Long>{
	

	public List<RegistrationModel> findByIsDeletedFalse();
	
	
	
//	@Transactional
//	@Modifying
//	@Query("update RegistrationModel set isDeleted=true where id=:id")
//	public void deleteById(@Param("id") Long id);
	
	public RegistrationModel getById(Long id);
}
