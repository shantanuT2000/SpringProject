package com.Company.request;

import com.Company.entity.CompanyModel;



public class AddressRequest {
	
	private Long id;
	

	private String city;
	

	private String state;
	

	private String pincode;
	
	private CompanyModel company;
	

	public Long getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPincode() {
		return pincode;
	}

	public CompanyModel getCompany() {
		return company;
	}
	
	

}
