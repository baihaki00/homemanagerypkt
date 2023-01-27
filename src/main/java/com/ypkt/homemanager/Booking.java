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
@Table (name = "booking")
public class Booking {
	
	public Booking() {} //instantiate
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long booking_id;
	
	//employer_id indicating which employer make the booking
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@Column(name="packages")
	private String packages;

	@Column(name="household")
	private String household;
	
	@Column(name="jobscope")
	private String jobscope;
	
	@Column(name="employeeAssigned")
	private String employeeAssigned;
	
	@Column(name="bookingStatus")
	private String bookingStatus;
	
	
	//constructor
	
	
	//getter setter
	public Long getBooking_id() {
		return booking_id;
	}

	public Booking(String packages, String household, String jobscope, String employeeAssigned, String bookingStatus, Employer employer) {
		super();
		this.packages = packages;
		this.household = household;
		this.jobscope = jobscope;
		this.employeeAssigned = employeeAssigned;
		this.bookingStatus = bookingStatus;
		this.employer = employer;
	}
	

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
	
	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getEmployeeAssigned() {
		return employeeAssigned;
	}

	public void setEmployeeAssigned(String employeeAssigned) {
		this.employeeAssigned = employeeAssigned;
	}

	public void setBooking_id(Long booking_id) {
		this.booking_id = booking_id;
	}

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public String getHousehold() {
		return household;
	}

	public void setHousehold(String household) {
		this.household = household;
	}

	public String getJobscope() {
		return jobscope;
	}

	public void setJobscope(String jobscope) {
		this.jobscope = jobscope;
	}
	
	

}
