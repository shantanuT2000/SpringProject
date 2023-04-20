package com.Company.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "registration_tbl")
public class RegistrationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="registration_id")
	private String registrationId;
	
	@Column(name="legal_name")
	private String legalName;
	
	@Column(name="date")
    private Date date;	
	
	@OneToOne(mappedBy = "registration")
	@JsonBackReference
	private CompanyModel company;
	
//	@Column(name="is_deleted")
//	private Boolean isDeleted = false;

	
	
	
	public Long getId() {
		return id;
	}

	public RegistrationModel(Long id, String registrationId, String legalName, Date date, CompanyModel company) {
		super();
		this.id = id;
		this.registrationId = registrationId;
		this.legalName = legalName;
		this.date = date;
		this.company = company;
	}

	
	public RegistrationModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(Long id) {
		this.id = id;
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
