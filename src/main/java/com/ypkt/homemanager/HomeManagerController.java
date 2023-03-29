package com.ypkt.homemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeManagerController {
	
	@Autowired(required = false)
	private HomeManagerService homeManagerService;
	
	@GetMapping("/") //main page
	public String mainPage(Model model, HttpSession session) {
		return "index";
	}
	
	@GetMapping("login") //login page
	public String loginPage(Model model) {
		return "login";
	}
	
	@GetMapping("/register/choose")
    public String registerChoose(Model model) {
		return "registerchoose";
	}
	
	@GetMapping("/assignEmployee")
	public String assignEmployeePage(Model model) {
		model.addAttribute("employers",homeManagerService.getAllEmployers());
		model.addAttribute("employees",homeManagerService.getAllEmployees());
		model.addAttribute("booking",homeManagerService.getNewBookings());
		model.addAttribute("bookingAll",homeManagerService.getAllBookings());
		model.addAttribute("bookingStatus",homeManagerService.getBookingStatus());
		model.addAttribute("availableEmployees",homeManagerService.getAvailableEmployees());
		model.addAttribute("jobApplication",homeManagerService.getAllJobApplication());
		model.addAttribute("newJobApplication",homeManagerService.getNewJobApplication());
		return "assignemployee";
	}
	
	@GetMapping("/applicationApproval")
	public String applicationApprovalPage(Model model) {
		model.addAttribute("employers",homeManagerService.getAllEmployers());
		model.addAttribute("employees",homeManagerService.getAllEmployees());
		model.addAttribute("booking",homeManagerService.getNewBookings());
		model.addAttribute("bookingStatus",homeManagerService.getBookingStatus());
		model.addAttribute("availableEmployees",homeManagerService.getAvailableEmployees());
		model.addAttribute("jobApplication",homeManagerService.getAllJobApplication());
		model.addAttribute("newJobApplication",homeManagerService.getNewJobApplication());
		return "applicationapproval";
	}
	
	@GetMapping("/message")
	public String messagePage(Model model) {
		return "message";
	}
	
	@GetMapping("/userList")
	public String userListPage(Model model) {
		model.addAttribute("employers",homeManagerService.getAllEmployers());
		model.addAttribute("employees",homeManagerService.getAllEmployees());
		return "userlist";
	}
	
	@GetMapping("/addUser")
	public String userAddUserPage(Model model) {
		return "adduser";
	}
	
	@GetMapping("/dashboard")
	public String dashBoardPage(Model model) {
		return "adminpage";
	}
	
	
//-------------------------------EMPLOYER----------------------------------------//
	@GetMapping("/register/employer/new") //register page //create obj
	public String registerPageEmployer(Model model) {
		
		Employer employer = new Employer();
		model.addAttribute("register",employer);
		return "register-employer";
	}
	@PostMapping("/registeremployer") //saveRegister by using model attribute
	public String saveRegister(@ModelAttribute("register")Employer employer) {
		homeManagerService.saveRegister(employer);
		return "redirect:/login";
	}
	//Redirect to employer page
	@GetMapping("/employer/{id}")
	public String employerPage(@PathVariable("id") Long id, Model model) {
		Employer employer = homeManagerService.getEmployerById(id);
		String bookingStatus = homeManagerService.checkBookingStatus(id);
		model.addAttribute("bookingStatus",bookingStatus);
		model.addAttribute("employer",employer);
		return("employerpage");
	}
	
	@GetMapping("/employer/delete/{id}")
	public String deleteEmployer(@PathVariable Long id) {
		
		//check booking_id references by employerId is null or not
		Booking booking = homeManagerService.getBookingByEmployerId(id);
		
		if (booking != null) {
			homeManagerService.deleteBookingByEmployerId(id);
			homeManagerService.deleteEmployerById(id);
			return "redirect:/userList";
		}
		else {
			homeManagerService.deleteEmployerById(id);
			return "redirect:/userList";
		}
	}
	

	
//	@GetMapping("/employee/delete/{id}")
//	public String deleteEmployee(@PathVariable Long id) {
//		
//		JobOffer jobOffer = homeManagerService.getJobOfferByEmployeeId(id);
//		
//		//check if joboffer_id references by employeeid is null or not
//		if (jobOffer != null) {
//			homeManagerService.deleteJobOfferByEmployeeId(id);
//			homeManagerService.deleteEmployeeById(id);
//			return "redirect:/userList";
//		}
//		else {
//			return null;
//		}
//
//	}
	
	
//-------------------------------EMPLOYEE----------------------------------------//
	
//	@GetMapping("/register/employee/new")
//	public String registerPageEmployee(Model model) {
//		Employee employee = new Employee();
//		model.addAttribute("register",employee);
//		return "register-employee";
//	}
	

	
	@GetMapping("/register/employee/new")
	public String registerPageEmployee(Model model) {
		JobApplication jobApplication = new JobApplication();
		model.addAttribute("jobApplication",jobApplication);
		return "register-employee";
	}
	
	@PostMapping("/saveJobApplication")
	public String saveJobApplication(@ModelAttribute("jobApplication")JobApplication jobApplication) {
		homeManagerService.saveJobApplication(jobApplication);
		return "redirect:/";
	}
	
	@GetMapping("/jobApplication/delete/{id}")
	public String deleteJobApplication(@PathVariable Long id) {
		
		//JobApplication jobApplication = homeManagerService.getJobApplicationById(id);
		homeManagerService.deleteJobApplicationById(id);
		return "redirect:/applicationApproval";
	}
	
	@PostMapping("/registeremployee") //save to employee table, 3 fields will be not included which is evaluation, availability and employee_id, these set of fields will be created only after the application is approved 
	public String saveRegister(@ModelAttribute("register")Employee employee, @RequestParam Long jobApplicationId) {
	    JobApplication jobApplication = homeManagerService.getJobApplicationById(jobApplicationId);
	    Employee newEmployee = new Employee();
	    newEmployee.setName(jobApplication.getName());
	    newEmployee.setIc(jobApplication.getIc());
	    newEmployee.setEmail(jobApplication.getEmail());
	    newEmployee.setAcademic(jobApplication.getAcademic());
	    newEmployee.setAddress(jobApplication.getAddress());
	    newEmployee.setAge(jobApplication.getAge());
	    newEmployee.setGender(jobApplication.getGender());
	    newEmployee.setRace(jobApplication.getRace());
	    newEmployee.setDisease(jobApplication.getDisease());
	    newEmployee.setMarriage(jobApplication.getMarriage());
	    newEmployee.setPhonenum(jobApplication.getPhonenum());
	    newEmployee.setPhonenum2(jobApplication.getPhonenum2());
	    newEmployee.setJobscope(jobApplication.getJobscope());
	    newEmployee.setVehicle(jobApplication.getVehicle());
	    jobApplication.setJobApplicationStatus("APPROVED");
	    homeManagerService.saveRegister(newEmployee);
	    return "redirect:/applicationApproval";
	}
	
	@GetMapping("/employee/{id}")
	public String employeePage(@PathVariable("id") Long id, Model model) {
		Employee employee = homeManagerService.getEmployeeById(id);
		String checkJobOffer = homeManagerService.checkJobOffer(id);
		
		
		String checkJobOfferStatus = homeManagerService.checkJobOfferStatus(id);
		model.addAttribute("checkJobOfferStatus",checkJobOfferStatus);


		model.addAttribute("employee",employee);
		model.addAttribute("checkJobOffer",checkJobOffer);
		JobOffer jobOffer = homeManagerService.getJobOfferByEmployerId(id);
		model.addAttribute("jobOffer",jobOffer);
		return("employeepage");
	}
	
	@PostMapping("/employee/jobApprove/{jobOffer_id}") //when employee click accept job come here
    public String jobApprove(@PathVariable("jobOffer_id") Long jobOffer_id) {
		JobOffer jobOffer = homeManagerService.getJobOfferById(jobOffer_id);
		Employer employer = jobOffer.getEmployer();
		Booking booking = homeManagerService.getBookingByEmployer(employer);
        jobOffer.setJobOfferStatus("APPROVED");
        booking.setBookingStatus("ACTIVE");
        homeManagerService.saveBooking(booking);
        homeManagerService.saveJobOffer(jobOffer);
        return "redirect:/employee/"+jobOffer.getEmployee().getId();
    }
	
	@PostMapping("/employee/jobReject/{jobOffer_id}") //when employee click accept job come here
    public String jobReject(@PathVariable("jobOffer_id") Long jobOffer_id) {
		
		JobOffer jobOffer = homeManagerService.getJobOfferById(jobOffer_id);
        jobOffer.setJobOfferStatus("REJECTED");
        homeManagerService.saveJobOffer(jobOffer);
        return "redirect:/employee/"+jobOffer.getEmployee().getId();
    }
	
	@GetMapping("/employee/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		
		JobOffer jobOffer = homeManagerService.getJobOfferByEmployeeId(id);
		
		//check if joboffer_id references by employeeid is null or not
		if (jobOffer != null) {
			homeManagerService.deleteJobOfferByEmployeeId(id);
			homeManagerService.deleteEmployeeById(id);
			return "redirect:/userList";
		}
		else {
			homeManagerService.deleteEmployeeById(id);
			return "redirect:/userList";
		}

	}
	
	
	 

	

	

	
//-------------------------------ADMIN----------------------------------------//
	@GetMapping("/admin") //list employers
    public String adminPage(Model model) {
		model.addAttribute("employers",homeManagerService.getAllEmployers());
		model.addAttribute("employees",homeManagerService.getAllEmployees());
		model.addAttribute("booking",homeManagerService.getNewBookings());
		model.addAttribute("bookingStatus",homeManagerService.getBookingStatus());
		model.addAttribute("availableEmployees",homeManagerService.getAvailableEmployees());
		model.addAttribute("jobApplication",homeManagerService.getAllJobApplication());
		model.addAttribute("newJobApplication",homeManagerService.getNewJobApplication());
		return "adminpage";
	}
	
	
	//assign employee
	@PostMapping("/assign-employee")
	public String updateBooking(@RequestParam("employee.id") Long employee_id, @RequestParam("booking_id") Long booking_id) {
		
		
		
		
		Booking existingBooking = homeManagerService.getBookingById(booking_id);
		Employee existingEmployee = homeManagerService.getEmployeeById(employee_id);
		existingBooking.setEmployeeAssigned(existingEmployee.getName());
		existingBooking.setBookingStatus("PENDING");
		homeManagerService.updateBooking(existingBooking);
		existingEmployee.setAvailability("Not Available"); //tukar pahni, sbb kito akan guno setavailability status ni untuk employee sajo, 
		homeManagerService.updateEmployee(existingEmployee);
		
		//job offer will appear here
		JobOffer newJobOffer = new JobOffer();
		newJobOffer.setEmployee(existingEmployee);
		newJobOffer.setEmployer(existingBooking.getEmployer());
		newJobOffer.setJobOfferStatus("NEW JOB OFFER");
		homeManagerService.saveJobOffer(newJobOffer);
		return "redirect:/assignEmployee";
	}

	
	
//-------------------------------BOOKING----------------------------------------//
	@GetMapping("/booking/new")
	public String bookingPage(Model model) {
		Booking booking = new Booking();
		model.addAttribute("booking",booking);
		return "booking";
	}
	@PostMapping("/savebooking") //save Booking
	public String saveBooking(@ModelAttribute("booking")Booking booking, HttpSession session) {
		Long employerId = (Long) session.getAttribute("id");
		Employer employer = homeManagerService.getEmployerById(employerId);
		booking.setEmployer(employer);
		booking.setBookingStatus("NEW BOOKING");
		homeManagerService.saveBooking(booking);
		return ("redirect:/employer/" + employer.getId());
	}
	
//-------------------------------LOGIN----------------------------------------//
	
//	@PostMapping("/processLogin")
//	public String processLogin(@RequestParam("email") String email,@RequestParam("ic") String ic, HttpSession session)
//	{
//		Object loginAuth = homeManagerService.loginAuth(email, ic);
//		if(loginAuth != null){
//            
//            session.setAttribute("email", email);
//            session.setAttribute("name",loginAuth.getName());
//            session.setAttribute("id", loginAuth.getId());
//            return ("redirect:/employer/" + loginAuth.getId()); //successful login goes to employerPage
//        }
//        else{
//            return("redirect:/login?fail"); //fail
//        }
//	}
	
	@PostMapping("/processLogin")
	public String processLogin(@RequestParam("email") String email,@RequestParam("ic") String ic, HttpSession session)
    {
        User user = homeManagerService.loginAuth(email, ic);
        if(user != null){
            if (user.getEmployer() != null) {
                session.setAttribute("name", user.getEmployer().getName());
                session.setAttribute("id", user.getEmployer().getId());
                return ("redirect:/employer/" + user.getEmployer().getId()); //successful login goes to employerPage
            } else if (user.getEmployee() != null) {
                session.setAttribute("name", user.getEmployee().getName());
                session.setAttribute("id", user.getEmployee().getId());
                return ("redirect:/employee/" + user.getEmployee().getId()); //successful login goes to employeePage
            }
        }
        else{
            return("redirect:/login?fail"); //fail
        }
        return("redirect:/login?fail");
    }


	
	
	

	
//-------------------------------LOGIN----------------------------------------//
    @GetMapping("/logout")
    public String logoutSession(HttpSession session) {
    	session.removeAttribute("email");
    	session.removeAttribute("name");
    	session.removeAttribute("id");
    	return "redirect:/login?loggedout";
    }
	
	

} //end
