package com.Company.service;
import java.util.List;


import org.springframework.stereotype.Service;

import com.Company.request.CompanyRequest;
import com.Company.response.CompanyResponse;

@Service
public interface CompanyService {
	
	public List<CompanyResponse> getAllCompanies();
	
	public String saveCompany(CompanyRequest companyRequest);
	
	public String updateCompany(Long id,CompanyRequest companyRequest);
	
    public CompanyResponse getById(Long id);
	
	public String deleteCompany(Long id);

}
