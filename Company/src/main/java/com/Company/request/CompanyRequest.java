package com.Company.request;

import java.util.List;

import com.Company.entity.AddressModel;
import com.Company.entity.RegistrationModel;
import com.Company.entity.UserModel;


public class CompanyRequest {
	
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


		public String getCompanyId() {
			return companyId;
		}


		public String getLegalName() {
			return legalName;
		}


		public String getPhoneNo() {
			return phoneNo;
		}


		public RegistrationModel getRegistration() {
			return registration;
		}


		public List<UserModel> getUsers() {
			return users;
		}


		public AddressModel getAddress() {
			return address;
		}
	    
	    

}
