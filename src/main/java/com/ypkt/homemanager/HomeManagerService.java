package com.ypkt.homemanager;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface HomeManagerService {
	
	Employee getEmployeeById(Long employee_id);
	Booking getBookingById(Long id);

	
	//add employer
	Employer saveRegister(Employer employer);
	
	//add booking
	Booking saveBooking(Booking booking);
	
	//update booking
	Booking updateBooking(Booking booking);
	
	//update employee
	Employee updateEmployee(Employee empployee);
	
	//add employee
	Employee saveRegister(Employee employee);
	
	//login auth
	Employer loginAuth(String email, String ic);
	
	// list
	List<Employer> getAllEmployers();
	List<Employee> getAllEmployees();
	List<Booking> getAllBookings();
	List<Employee> getAvailableEmployees();
	List<Booking> getNewBookings();
	List<Booking> getBookingStatus();





	


	

}
