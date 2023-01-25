package com.ypkt.homemanager;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "employees")
public class Employee {
	
	public Employee() {} //instantiate
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
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
	
	
	@Column(name="availibility", nullable = false) //availibility ada tiga state, available, unavailable, in progress
	private String availability = "UNAVAILABLE";
	
	
	//constructor
	public Employee(String name, String ic, String age, String address, String phonenum, String phonenum2,
			String gender, String race, String marriage, String academic, String disease, String vehicle,
			String jobscope, String evaluation, String availability) {
		super();
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
		this.availability = availability;
	}

	//setters getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	
	
	

}
