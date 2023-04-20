package com.Company.response;

import java.util.List;

import com.Company.entity.AddressModel;
import com.Company.entity.RegistrationModel;
import com.Company.entity.UserModel;

public class CompanyResponse {
	
	 private Long id;

	   
	    private String companyId;

	    private String legalName;

	    private String phoneNo;

	    
	    private RegistrationModel registration;
	    
	  
	    private List<UserModel> users;
	    
	
	    private AddressModel address;


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getCompanyId() {
			return companyId;
		}


		public void setCompanyId(String companyId) {
			this.companyId = companyId;
		}


		public String getLegalName() {
			return legalName;
		}


		public void setLegalName(String legalName) {
			this.legalName = legalName;
		}


		public String getPhoneNo() {
			return phoneNo;
		}


		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}


		public RegistrationModel getRegistration() {
			return registration;
		}


		public void setRegistration(RegistrationModel registration) {
			this.registration = registration;
		}


		public List<UserModel> getUsers() {
			return users;
		}


		public void setUsers(List<UserModel> users) {
			this.users = users;
		}


		public AddressModel getAddress() {
			return address;
		}


		public void setAddress(AddressModel address) {
			this.address = address;
		}


	
	    
	    


}
