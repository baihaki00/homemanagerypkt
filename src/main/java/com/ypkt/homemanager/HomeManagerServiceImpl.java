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
	
	@Autowired
	private JobApplicationRepository jobApplicationRepository;
	
	@Autowired
	private JobOfferRepository jobOfferRepository;
	
	
	public HomeManagerServiceImpl(EmployerRepository employerRepository) {
		
		super();
		this.employerRepository = employerRepository;
	}
	
	@Override
	public Employer saveRegister(Employer employer) {
		return employerRepository.save(employer);
	}
	
	@Override
	public JobOffer saveJobOffer(JobOffer jobOffer) {
		return jobOfferRepository.save(jobOffer);
	}
	
	@Override
	public JobApplication saveJobApplication(JobApplication jobApplication) {
		return jobApplicationRepository.save(jobApplication);
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
	
	@Override
	public Employer getEmployerById(Long id) {
		return employerRepository.findById(id).get();
	}
	
	@Override
	public JobApplication getJobApplicationById(Long id) {
		return jobApplicationRepository.findById(id).get();
	}
	
	@Override
	public JobOffer getJobOfferById(Long id) {
		return jobOfferRepository.findById(id).get();
	}
	
	@Override
	public JobOffer getJobOfferByEmployerId(Long id) {
		return jobOfferRepository.findByEmployeeId(id);
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
	public List<JobApplication> getAllJobApplication() {
		return jobApplicationRepository.findAll();
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
	public List<JobApplication> getJobApplicationStatus() {
		return jobApplicationRepository.findByJobApplicationStatus("APPROVED");
	}
	
	@Override
	public List<JobApplication> getNewJobApplication() {
		return jobApplicationRepository.findByJobApplicationStatus("NEW JOB APPLICATION");
	}
	
	@Override
	public List<Employee> getAvailableEmployees() {
	    return employeeRepository.findByAvailability("UNAVAILABLE");
	}
	

	

	@Override
    public String checkBookingStatus(Long employerId) {
        Booking booking = bookingRepository.findByEmployerId(employerId);
        if(booking != null) {
            return booking.getBookingStatus();
        } else {
            return null;
        }
    }
	
	@Override
	public String checkJobOfferStatus(Long jobOffer_id) {
	    JobOffer jobOffer = jobOfferRepository.findById(jobOffer_id).orElse(null);
	    if (jobOffer != null) {
	        return jobOffer.getJobOfferStatus();
	    } else {
	        return null;
	    }
	}
    
	@Override
    public String checkJobOffer(Long employeeId) {
    	JobOffer jobOffer = jobOfferRepository.findByEmployeeId(employeeId);
    	if (jobOffer != null) {
    		return jobOffer.getJobOfferStatus();
    	} else {
    		return null;
    	}
    }
	
    

    
    
    
    

    	
    @Override
    public User loginAuth(String email, String ic) {
        Employer employer = employerRepository.getByEmail(email);
        Employee employee = employeeRepository.getByEmail(email);
        
        if (employer != null) {
            if (employer.getIc().equals(ic) && employer.getEmail().equals(email)) {
                return new User(employer, null);
            }
        }
        else if (employee != null) {
            if (employee.getIc().equals(ic) && employee.getEmail().equals(email)) {
                return new User(null, employee);
            }
        }
        return null;
    	}





	
	//login auth
//	public Employer loginAuth(String email, String ic) {
//		Employer employer = employerRepository.getByEmail(email);
//		
//		if (employer != null) {
//			if (employer.getIc().equals(ic) && employer.getEmail().equals(email)) {
//				return employer;
//			}	
//			else {
//				return null;
//			}
//		}
//		else {
//			return null;
//		}
//	}



	

	

} //end of service impl
