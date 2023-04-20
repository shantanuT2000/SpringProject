package com.Company.response;

import java.sql.Date;

import com.Company.entity.CompanyModel;

public class RegistrationResponse {
	
	Long id;
	
    public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}

	private String registrationId;
	
	private String legalName;
	
    private Date date;	
	
	private CompanyModel company;
	
	

	public RegistrationResponse(Long id,String registrationId, String legalName, Date date, CompanyModel company) {
		super();
		this.id=id;
		this.registrationId = registrationId;
		this.legalName = legalName;
		this.date = date;
		this.company = company;
	}
	
	
	

	public RegistrationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}




	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CompanyModel getCompany() {
		return company;
	}

	public void setCompany(CompanyModel company) {
		this.company = company;
	}
	
	

}
