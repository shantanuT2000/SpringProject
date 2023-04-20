package com.Company.entity;

//import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.FetchType;
//
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;


@Entity
@Table(name="user_data")
public class UserModel {
  
	
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="firstname",length=26)
	private String firstName;
	
	

	@Column(name="lastname",length=26)
	private String lastName;


	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="type")
	private Type type;
	
	@Column(name="email")
	private String email;
	
	
	@Column(name="password",length=18)
	private String password;
	
//	@Column(name="is_deleted")
//	private Boolean isDeleted=false;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "company_id", insertable = false, updatable = false)
//	 @JsonBackReference
//    private CompanyModel companyUsers;
	
	
//	String compId = companyUsers.getCompanyId();
//	
//	public CompanyModel getCompanyUsers() {
//		return companyUsers;}
//
//	public void setCompanyUsers(CompanyModel companyUsers) {
//		this.companyUsers = companyUsers;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

//	public Boolean getIsDeleted() {
//		return isDeleted;
//	}
//
//	public void setIsDeleted(Boolean isDeleted) {
//		this.isDeleted = isDeleted;
//	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserModel(Long id, String firstName, String lastName, Type type, String email,String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
		this.email = email;
		this.password = password;
	}

	public UserModel() {
		super();
		
	}

	
	
	
}



