package com.Company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.Company.repository.CompanyRepository;
import com.Company.request.CompanyRequest;
import com.Company.response.CompanyResponse;
import com.Company.entity.CompanyModel;
import com.Company.projectUtils.Constants;
import com.Company.service.CompanyService;
import com.Company.transformer.RequestConverter;
import com.Company.transformer.ResponseConverter;
import java.util.List;
import java.util.Optional;
import org.slf4j.*;


@Component
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
    private ResponseConverter responseConverter;
	
	@Autowired
	private RequestConverter  requestConverter;
	
    Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Override
	public List<CompanyResponse> getAllCompanies() {
		
		List<CompanyModel> companyModelList = null;
		try {
			
			logger.info("Getting all active companies");
			
			 companyModelList = companyRepository.findByIsDeletedFalse();
			 
			logger.info("Fetched all active Companies");
			
		}
		catch(Exception e) {
			
		  e.getMessage();
		
		}
		
		return responseConverter.toCompanyResponseList(companyModelList);
		
	}



	@Override
	public String saveCompany(CompanyRequest companyRequest) {
		
		CompanyModel companyModel = null;
		try {
			
			companyModel = requestConverter.toCompanyEntity(companyRequest);

			logger.info("converted to responseEntity ");
			
			companyRepository.save(companyModel);
			
			logger.info("saved the entry");
			
			return Constants.savedMessage;
			
		}
		catch(Exception e) {
	      
			
			logger.error("cannot connnect to database");
			return e.getMessage();
			
		}
		
		
	}


	@Override
	public CompanyResponse getById(Long id) {
		
		try {
			
			CompanyModel model = companyRepository.getById(id);
			return responseConverter.entityToCompanyResponse(model);
			
			
		}
		catch(Exception e) {
			
			logger.error("Cannot connect to database");
			e.getMessage();
			return null;
			
		}
	}


	@Override
	public String deleteCompany(Long id) {
		
		try {
			
			logger.info("searching for the given id");
			Optional<CompanyModel> optionalCompanyModel = companyRepository.findById(id);
			
			
			if(optionalCompanyModel.isPresent()) {
				
				CompanyModel companyModel = optionalCompanyModel.get();
				
				logger.warn("deleting registration table entry");
				companyModel.getRegistration().setIsDeleted(true);
				
				logger.warn("Deleting address table entry");
				companyModel.getAddress().setIsDeleted(true);
				
				logger.warn("Deleting users related to the company");
				companyModel.getUsers().stream().forEach(user->user.setIsDeleted(true));
				
				logger.warn("Deleting company entry");
				companyModel.setIsDeleted(true);
				
				
				
				try {
					
					logger.info("trying to save the entity");
					companyRepository.save(companyModel);
					logger.info("Entity saved");
					
				}
				catch(Exception e){
					
					logger.error("Unable to save error");
					e.getMessage();
					
					}
			
				return Constants.deleteMessage;
			
			}
			
			return Constants.notFoundError ;
			
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
				
				try {
					companyRepository.save(companyModel);
				}
				catch(Exception e) {
					e.getMessage();
				}
				
				
				return Constants.updateSuccessMessage;
			}
			
			return Constants.notFoundError;
			
		}
		catch(Exception e) {
			
			return e.getMessage();
			
		}
	}


	

	

}
