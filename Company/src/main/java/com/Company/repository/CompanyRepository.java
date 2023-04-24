package com.Company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Company.entity.CompanyModel;




public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {

	public List<CompanyModel> findByIsDeletedFalse();
	
	
//	@Query("update CompanyModel set isDeleted=true where id=:id")
//	public int deleteById(@Param("id") Long id);
	
//	@Transactional
//	@Modifying
//	@Query("select id,legalName from CompanyModel where isDeleted=false and id=:id")
	
	public CompanyModel getById(Long id);
	
}
