package com.ypkt.homemanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class HomeManagerServiceImpl implements HomeManagerService{
	
	@Autowired
	private EmployerRepository employerRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public HomeManagerServiceImpl(EmployerRepository employerRepository) {
		
		super();
		this.employerRepository = employerRepository;
	}
	
	@Override
	public Employer saveRegister(Employer employer) {
		return employerRepository.save(employer);
	}
	
	@Override
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
	
	@Override
	public Booking updateBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee saveRegister(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override //get booking by id to update
	public Booking getBookingById(Long id){
		return bookingRepository.findById(id).get();
	}
	
	@Override
	public Employee getEmployeeById(Long id){
		return employeeRepository.findById(id).get();
	}
	
	@Override //list employers
	public List<Employer> getAllEmployers() {
		return employerRepository.findAll();
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@Override
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}
	
	@Override
	public List<Booking> getNewBookings() {
		return bookingRepository.findByBookingStatus("NEW BOOKING");
	}
	
	@Override
	public List<Booking> getBookingStatus() {
		return bookingRepository.findByBookingStatus("PENDING");
	}
	
	@Override
	public List<Employee> getAvailableEmployees() {
	    return employeeRepository.findByAvailability("UNAVAILABLE");
	}
	
	
	//login auth
	public Employer loginAuth(String email, String ic) {
		Employer employer = employerRepository.getByEmail(email);
		
		if (employer != null) {
			if (employer.getIc().equals(ic) && employer.getEmail().equals(email)) {
				return employer;
			}	
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}



	

	

} //end of service impl
