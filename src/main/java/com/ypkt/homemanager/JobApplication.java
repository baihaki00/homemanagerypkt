package com.ypkt.homemanager;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


//this class create jobApplication obj, before an employer
//can be listed as official worker, the jobapplication made by employer must first be approved.

@Entity
@Table (name="jobApplication")
public class JobApplication {
	
	public JobApplication() {} //instantiate
	
	
	//important details for this class
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobApplication_id;
	
	
	@OneToOne
	@JoinColumn(name="employee_id")
	private Employee employee; //foreign key
	
	
	//private String jobScope_id;
	//private String request_date;
	
	@Column(name="jobApplicaationStatus", nullable = false)
	private String jobApplicationStatus = "NEW JOB APPLICATION";
	
	
	//employee details, will be stored here first, if the job application is approved all the data will be sent to employee obj.
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="ic")
	private String ic;
	
	@Column(name="age")
	private String age;

	@Column(name="address")
	private String address;
	
	@Column(name="phonenum")
	private String phonenum;
	
	@Column(name="phonenum2")
	private String phonenum2;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="race")
	private String race;
	
	@Column(name="marriage")
	private String marriage;
	
	@Column(name="academic")
	private String academic;
	
	@Column(name="disease")
	private String disease;
	
	@Column(name="vehicle")
	private String vehicle;
	
	@Column(name="jobscope")
	private String jobscope;
	
	@Column(name="evaluation")
	private String evaluation;
	
	//constructor
	public JobApplication(String employee_id, String jobApplicationStatus, String name, String ic, String age,
			String address, String phonenum, String phonenum2, String gender, String race, String marriage,
			String academic, String disease, String vehicle, String jobscope, String evaluation, Employee employee, String email) {
		super();
		this.jobApplicationStatus = jobApplicationStatus;
		this.name = name;
		this.ic = ic;
		this.age = age;
		this.address = address;
		this.phonenum = phonenum;
		this.phonenum2 = phonenum2;
		this.gender = gender;
		this.race = race;
		this.marriage = marriage;
		this.academic = academic;
		this.disease = disease;
		this.vehicle = vehicle;
		this.jobscope = jobscope;
		this.evaluation = evaluation;
		this.employee = employee;
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//setter getter
	public Long getJobApplication_id() {
		return jobApplication_id;
	}

	

	public void setJobApplication_id(Long jobApplication_id) {
		this.jobApplication_id = jobApplication_id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getJobApplicationStatus() {
		return jobApplicationStatus;
	}

	public void setJobApplicationStatus(String jobApplicationStatus) {
		this.jobApplicationStatus = jobApplicationStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIc() {
		return ic;
	}

	public void setIc(String ic) {
		this.ic = ic;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getPhonenum2() {
		return phonenum2;
	}

	public void setPhonenum2(String phonenum2) {
		this.phonenum2 = phonenum2;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getAcademic() {
		return academic;
	}

	public void setAcademic(String academic) {
		this.academic = academic;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getJobscope() {
		return jobscope;
	}

	public void setJobscope(String jobscope) {
		this.jobscope = jobscope;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	
	
	

}
