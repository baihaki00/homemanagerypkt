package com.ypkt.homemanager;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "employers")
public class Employer {
	
	public Employer() {}//leave blank
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name = "ic")
	private String ic;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phonenum")
	private String phonenum;
	
	@Column(name="email")
	private String email;
	
	@Column(name="job")
	private String job;
	
	@Column(name="position")
	private String position;
	
	@Column(name="salary")
	private String salary;
	
	//constructor
	public Employer(String name, String ic, String address, String phonenum, String email, String job, String position,
			String salary) {
		super();
		this.name = name;
		this.ic = ic;
		this.address = address;
		this.phonenum = phonenum;
		this.email = email;
		this.job = job;
		this.position = position;
		this.salary = salary;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	

}
