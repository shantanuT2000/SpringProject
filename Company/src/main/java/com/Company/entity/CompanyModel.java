package com.Company.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="company_tbl")
public class CompanyModel {

	
//	,cascade=CascadeType.ALL
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_id")
    private String companyId;

    @Column(name="company_name")
    private String legalName;

    @Column(name = "phone_no")
    private String phoneNo;

    @OneToOne(mappedBy = "company",cascade=CascadeType.ALL)
    @JsonManagedReference
    private RegistrationModel registration;
    
    @OneToMany(mappedBy = "companyUsers",cascade=CascadeType.ALL)
    @JsonManagedReference
    private List<UserModel> users;
    
    @OneToOne(mappedBy="company",cascade=CascadeType.ALL)
    @JsonManagedReference
    private AddressModel address;
    
    @Column(name="is_deleted")
    private Boolean isDeleted=false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
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

	public CompanyModel(Long id, String companyId, String legalName, String phoneNo, RegistrationModel registration,List<UserModel>users) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.legalName = legalName;
		this.phoneNo = phoneNo;
		this.registration = registration;
		this.users = users;
	}

	public CompanyModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
