package com.Company.request;

import com.Company.entity.CompanyModel;
import com.Company.entity.Type;

public class UserRequest {
	
	Long Id;
	
	public Long getId() {
		return Id;
	}
	String firstname;
	String lastname;
	String email;
	Type type;
	String password;

	CompanyModel company;
	
	
	

	public CompanyModel getCompany() {
		return company;
	}
	public void setCompany(CompanyModel company) {
		this.company = company;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	
	

}
