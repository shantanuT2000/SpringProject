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
	private CompanyRepository companyRepository;
	
	@Autowired
    private ResponseConverter responseConverter;
	
	@Autowired
	private RequestConverter  requestConverter;
	

	@Override
	public List<CompanyResponse> getAllCompanies() {
		try {
			List<CompanyModel> entityList = companyRepository.findByIsDeletedFalse();
			return responseConverter.toCompanyResponseList(entityList);
		}
		catch(Exception e) {
			
		  e.getMessage();
		  return null;
		}
		
	}


	@Override
	public String saveCompany(CompanyRequest companyRequest) {
		
		CompanyModel companyModel;
		try {
			companyModel = requestConverter.toCompanyEntity(companyRequest);
			companyRepository.save(companyModel);
			return "saved";
		}
		catch(Exception e) {
	      
			return e.getMessage();
		}
		
		
		
		
	}
	
	//same converter for id
	


	@Override
	public CompanyResponse getById(Long id) {
		
		CompanyModel model = companyRepository.getById(id);
		return responseConverter.entityToCompanyResponse(model);
	}


	@Override
	public String deleteCompany(Long id) {
		
		try {
			Optional<CompanyModel> optionalCompanyModel = companyRepository.findById(id);
			if(optionalCompanyModel.isPresent()) {
				CompanyModel companyModel = optionalCompanyModel.get();
				companyModel.setIsDeleted(true);
				companyRepository.save(companyModel);
				return "Deleted";
			}
			return "Entity not found error cannot delete" ;
		
		
			
		}
		catch(Exception e) {
			
			return e.getMessage();
		}
		
}

	@Override
	public String updateCompany(Long id, CompanyRequest companyRequest) {
		
		try {
			Optional<CompanyModel> optionalModel = companyRepository.findById(id);
			
			if(optionalModel.isPresent()) {
				
				CompanyModel companyModel = optionalModel.get();
				companyModel.setAddress(companyRequest.getAddress());
				companyModel.setCompanyId(companyRequest.getCompanyId());
				companyModel.setLegalName(companyRequest.getLegalName());
				companyModel.setPhoneNo(companyRequest.getPhoneNo());
				companyModel.setRegistration(companyRequest.getRegistration());
				companyModel.setUsers(companyRequest.getUsers());
				companyRepository.save(companyModel);
				
				return "Updated";
			}
			
			return "Company Not found to update ";
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}


	

	

}
