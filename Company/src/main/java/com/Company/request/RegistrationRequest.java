package com.Company.request;

import java.sql.Date;

import com.Company.entity.CompanyModel;


public class RegistrationRequest {
	
private Long id;
	
	
	private String registrationId;
	
	private String legalName;
	
    private Date date;	
	
	private CompanyModel company;


	public Long getId() {
		return id;
	}


	public String getRegistrationId() {
		return registrationId;
	}


	public String getLegalName() {
		return legalName;
	}


	public Date getDate() {
		return date;
	}


	public CompanyModel getCompany() {
		return company;
	}
	
	

}
