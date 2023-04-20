package com.Company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Company.repository.CompanyRepository;
import com.Company.request.CompanyRequest;
import com.Company.response.CompanyResponse;
import com.Company.entity.CompanyModel;
import com.Company.service.CompanyService;
import com.Company.transformer.RequestConverter;
import com.Company.transformer.ResponseConverter;

import java.util.List;
import java.util.Optional;


@Component
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	CompanyRepository companyRepo;
	
	@Autowired
    ResponseConverter toResponse;
	
	@Autowired
	RequestConverter toEntityConverter;
	

	@Override
	public List<CompanyResponse> getAllCompanies() {
		
		List<CompanyModel> entityList = companyRepo.findByIsDeletedFalse();
		return toResponse.toCompanyResponseList(entityList);
	}


	@Override
	public String saveCompany(CompanyRequest companyRequest) {
		
		CompanyModel entity = toEntityConverter.toCompanyEntity(companyRequest);
		companyRepo.save(entity);
		
		return "saved";
	}


	@Override
	public CompanyResponse getById(Long id) {
		
		CompanyModel model = companyRepo.getById(id);
		return toResponse.entityToCompanyResponse(model);
	}


	@Override
	public String deleteCompany(Long id) {
		
		Optional<CompanyModel> model = companyRepo.findById(id);
		if(model.isPresent()) {
			companyRepo.deleteById(id);
			return "Deleted";
		}
		return "Entity not found error cannot delete" ;
	}


	@Override
	public String updateCompany(Long id, CompanyRequest companyRequest) {
		
		Optional<CompanyModel> optionalModel = companyRepo.findById(id);
		if(optionalModel.isPresent()) {
			CompanyModel model = optionalModel.get();
			model.setAddress(companyRequest.getAddress());
			model.setCompanyId(companyRequest.getCompanyId());
			model.setLegalName(companyRequest.getLegalName());
			model.setPhoneNo(companyRequest.getPhoneNo());
			model.setRegistration(companyRequest.getRegistration());
			model.setUsers(companyRequest.getUsers());
			companyRepo.save(model);
			return "Updated";
		}
		return "Company Not found to update ";
	}


	

//	@Override
//	public String saveCompany() {
//		companyModel.setUsers(userModel);
//		companyRepo.save(companyModel);
//		return "saved";
//	}
	
	

}
