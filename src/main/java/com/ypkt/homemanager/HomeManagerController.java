package com.ypkt.homemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@GetMapping("/register/employer/new") //register page //create obj
	public String registerPageEmployer(Model model) {
		
		Employer employer = new Employer();
		model.addAttribute("register",employer);
		return "register-employer";
	}
	
	@GetMapping("/register/employee/new")
	public String registerPageEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("register",employee);
		return "register-employee";
	}
	
	@GetMapping("/booking/new")
	public String bookingPage(Model model) {
		Booking booking = new Booking();
		model.addAttribute("booking",booking);
		return "booking";
	}
	
	@PostMapping("/registeremployer") //saveRegister by using model attribute
	public String saveRegister(@ModelAttribute("register")Employer employer) {
		homeManagerService.saveRegister(employer);
		return "redirect:/login";
	}
	
	@PostMapping("/savebooking") //save Booking
	public String saveBooking(@ModelAttribute("booking")Booking booking) {
		homeManagerService.saveBooking(booking);
		return "redirect:/";
	}
	
	@PostMapping("/registeremployee") //save
	public String saveRegister(@ModelAttribute("register")Employee employee) {
		homeManagerService.saveRegister(employee);
		return "redirect:/";
	}
	
	@GetMapping("/admin") //list employers
    public String adminPage(Model model) {
		model.addAttribute("employers",homeManagerService.getAllEmployers());
		model.addAttribute("employees",homeManagerService.getAllEmployees());
		model.addAttribute("booking",homeManagerService.getNewBookings());
		model.addAttribute("bookingStatus",homeManagerService.getBookingStatus());
		model.addAttribute("availableEmployees",homeManagerService.getAvailableEmployees());
		return "adminpage";
	}
	
	//assign employee
	@PostMapping("/assign-employee")
	public String updateBooking(@RequestParam("employee.id") Long employee_id, @RequestParam("booking_id") Long booking_id) {
		
		Booking existingBooking = homeManagerService.getBookingById(booking_id);
		Employee existingEmployee = homeManagerService.getEmployeeById(employee_id);
		existingBooking.setEmployeeAssigned(existingEmployee.getName());
		existingBooking.setBookingStatus("Pending");
		homeManagerService.updateBooking(existingBooking);
		existingEmployee.setAvailability("Not Available");
		homeManagerService.updateEmployee(existingEmployee);
		return "redirect:/admin";
	}
	

		
	@GetMapping("/register/choose")
    public String registerChoose(Model model) {
		return "registerchoose";
	}
	
	
	//-----------------LOGIN AUTH------------------//
	@PostMapping("/processLogin")
	public String processLogin(@RequestParam("email") String email,@RequestParam("ic") String ic, HttpSession session)
	{
		Employer loginAuth = homeManagerService.loginAuth(email, ic);
		if(loginAuth != null){
            
            session.setAttribute("email", email);
            session.setAttribute("name",loginAuth.getName());
            session.setAttribute("id", loginAuth.getId());
            return ("employerpage"); //success
        }
        else{
            return("redirect:/login?fail"); //fail
        }
	}
	
	//---------------LOG OUT------------------------//
    @GetMapping("/logout")
    public String logoutSession(HttpSession session) {
    	session.removeAttribute("email");
    	session.removeAttribute("name");
    	session.removeAttribute("id");
    	return "redirect:/login?loggedout";
    }
    
    //---ADMIN CONTROL---//
    
	

} //end
