package com.Company.response;

import com.Company.entity.CompanyModel;

public class AddressResponse {
	
	
	private Long id;
	

	private String city;
	

	private String state;
	

	private String pincode;
	
	private CompanyModel company;
	
	

	public AddressResponse(Long id,String city, String state, String pincode) {
		
		this.id=id;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		
	}
	
	

	public AddressResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public CompanyModel getCompany() {
		return company;
	}

	public void setCompany(CompanyModel company) {
		this.company = company;
	}
	
	

}
