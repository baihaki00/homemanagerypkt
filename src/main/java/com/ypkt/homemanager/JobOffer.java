package com.ypkt.homemanager;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="JobOffer")
public class JobOffer {
	
	public JobOffer() {} //instantiate
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long jobOffer_id;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@Column(name="JobOfferStatus", nullable = false)
	private String JobOfferStatus = "NEW JOB OFFER";

	public Long getJobOffer_id() {
		return jobOffer_id;
	}
	
	//constructor
	public JobOffer(Employee employee, String jobOfferStatus, Employer employer) {
		super();
		this.employee = employee;
		this.employer = employer;
		JobOfferStatus = jobOfferStatus;
	}
	
	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	//setter getter
	public void setJobOffer_id(Long jobOffer_id) {
		this.jobOffer_id = jobOffer_id;
	}



	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getJobOfferStatus() {
		return JobOfferStatus;
	}

	public void setJobOfferStatus(String jobOfferStatus) {
		JobOfferStatus = jobOfferStatus;
	}
	
	
	
	

}
