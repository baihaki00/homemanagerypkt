package com.ypkt.homemanager;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface HomeManagerService {
	
	Employee getEmployeeById(Long employee_id);
	Employer getEmployerById(Long employer_id);
	Booking getBookingById(Long id);
	JobApplication getJobApplicationById(Long id);
	JobOffer getJobOfferById(Long jobOffer_id);
	JobOffer getJobOfferByEmployerId(Long employer_id);

	
	
	//add employer
	Employer saveRegister(Employer employer);
	
	//add booking
	Booking saveBooking(Booking booking);
	
	JobApplication saveJobApplication(JobApplication jobApplication);
	
	//update booking
	Booking updateBooking(Booking booking);
	
	//update employee
	Employee updateEmployee(Employee empployee);
	
	//add employee
	Employee saveRegister(Employee employee);
	
	//add joboffer
	JobOffer saveJobOffer(JobOffer jobOffer);
	
	//login auth
	User loginAuth(String email, String ic);
	
	
	//check booking status
	String checkBookingStatus(Long id);
	
	//check job offer status
	String checkJobOfferStatus(Long id);
	
	// list
	List<Employer> getAllEmployers();
	List<Employee> getAllEmployees();
	List<Booking> getAllBookings();
	List<Employee> getAvailableEmployees();
	List<Booking> getNewBookings();
	List<Booking> getBookingStatus();
	List<JobApplication> getJobApplicationStatus();
	List<JobApplication> getAllJobApplication();
	List<JobApplication> getNewJobApplication();










	


	

}
