package com.metacube.MetacubeParkingJdbc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.MetacubeParkingJdbc.dto.ImageDto;
import com.metacube.MetacubeParkingJdbc.model.Employee;
import com.metacube.MetacubeParkingJdbc.model.Image;
import com.metacube.MetacubeParkingJdbc.model.LoginEmployee;
import com.metacube.MetacubeParkingJdbc.model.Pass;
import com.metacube.MetacubeParkingJdbc.model.PassDetails;
import com.metacube.MetacubeParkingJdbc.model.Vehicle;
import com.metacube.MetacubeParkingJdbc.service.EmployeeService;

@Controller
public class ParkingController {
	
	@Autowired 
	private EmployeeService employeeService;

	
	@Autowired
	ServletContext context; 

	Double passPrices[];
	
	/**
	 * get Mapping for signUp page
	 * @param model
	 * @return
	 */
	@GetMapping("/signUp") 
	public String signUp(Model model) {
		model.addAttribute("employee", new Employee());
		return "signUp";
	}
	
	/**
	 * post mapping for signUp page and to check validations
	 * @param student
	 * @param result
	 * @return
	 */
	@PostMapping("/signUp") 
	public String doSignUp(@Validated Employee employee, BindingResult result, RedirectAttributes attribute, Model model) {
		if (result.hasErrors()) {
			return "signUp";
			
		} else {
			if (!((employee.getPassword()).equals(employee.getConfirmPassword()))) {
				ObjectError error = new ObjectError("errorMsg", "Password and confirm password should be same");
				result.addError(error);
				return "signUp";
			}
			try {
				employeeService.addEmployee(employee);
				int employeeId = employeeService.getEmployeeId();
				attribute.addFlashAttribute("msg", "Employee Id : " + employeeId);
				attribute.addAttribute("employeeId", employeeId);
				return "redirect:/vehicleForm";	
			} catch(DuplicateKeyException e) {
				ObjectError error = new ObjectError("errorMsg", e.getMessage());
				result.addError(error);
				return "signUp";
			}
		}
	}
	
	/**
	 * get mapping for vehicleform page
	 * @param model
	 * @return
	 */
	@GetMapping("/vehicleForm") 
	public String addVehicle(Model model) {
		model.addAttribute("vehicle", new Vehicle());
		return "vehicleForm";
	}
	
	/**
	 * post mapping for vehicle page
	 * @param vehicle object
	 * @param result
	 * @param attribute
	 * @return
	 */
	@PostMapping("/registerVehicle")
	public String registerVehicle(@Validated Vehicle vehicle, BindingResult result, RedirectAttributes attribute) {
		if(result.hasErrors()) {
			return "vehicleForm";
		} else {
			employeeService.addVehicle(vehicle);
			attribute.addAttribute("type", vehicle.getVehicleType());
			return "redirect:/getPass";
		}
	}
	
	/**
	 * get mapping for get pass page
	 * @param type
	 * @param model
	 * @return
	 */
	@GetMapping("/getPass")
	public String getPass(@RequestParam("type") String type, Model model) {
		PassDetails passDetails = employeeService.getPassPrice(type);
		Map<Double, String> passMap = new HashMap<Double, String>();
		passMap.put(passDetails.getDaily(), passDetails.getDaily() + "Daily");
		passMap.put(passDetails.getMonthly(), passDetails.getMonthly() + "Monthly");
		passMap.put(passDetails.getYearly(), passDetails.getYearly() + "Yearly");
		model.addAttribute("passPrices", passMap);
		model.addAttribute("pass", new Pass());
		return "getPass";
	}
	
	/**
	 * post mapping for get pass page.
	 * @param pass object
	 * @param result  
	 * @param reAttribute
	 * @return
	 */
	@PostMapping("/getPass") 
	public String getFinalPass(@Validated Pass pass, BindingResult result, RedirectAttributes reAttribute) {
		double plan = employeeService.getValueByCurrency(pass.getPlan(), pass.getCurrency());
		reAttribute.addAttribute("passPrice", plan);
		return  "redirect:/pass";
	}
	
	/**
	 * Get mapping for pass page to show pass Price
	 * @param passPrice
	 * @param model
	 * @return
	 */
	@GetMapping("/pass") 
	public String pass(@RequestParam("passPrice") double passPrice, Model model) {
		model.addAttribute("passPrice", passPrice);
		return "pass";
	}
	
	/**
	 * Get mapping for login page
	 * @param model
	 * @return
	 */
	@GetMapping("/login") 
	public String login(Model model) {
		model.addAttribute("loginEmployee", new LoginEmployee());
		return "login";
	}
	
	/**
	 * post mapping for login page
	 * @param loginEmployee  
	 * @param result
	 * @param attributes
	 * @param request
	 * @return
	 */
	@PostMapping("/login")
	public String getLoggedIn(@Validated LoginEmployee loginEmployee, BindingResult result, RedirectAttributes attributes, HttpServletRequest request){
		if(result.hasErrors()) {
			return "login";
		} else {
			try {
				String password = employeeService.auth(loginEmployee.getEmailId());
				if(password.equals(loginEmployee.getPassword())) {
					HttpSession session = request.getSession();
					session.setAttribute("email", loginEmployee.getEmailId());
					attributes.addAttribute("email", loginEmployee.getEmailId());
					attributes.addFlashAttribute("Msg", "Logged in successfully");
					return "redirect:/home";
				} else {
					attributes.addFlashAttribute("errorMsg", "Enter a valid password");
					return "redirect:/login";
				}
			} catch(EmptyResultDataAccessException e) {
				attributes.addFlashAttribute("errorMsg", "Enter valid details");
				return "redirect:/login";
			}
		} 
	}
	
	/**
	 * Get mapping for home page i.e profile page
	 * @param email
	 * @param model
	 * @return
	 */
	@GetMapping("/home") 
	public String getHome(@RequestParam("email") String email, Model model) {
		Employee emp = employeeService.getEmployeeByEmail(email);
		model.addAttribute("employee", emp);
		return "home";
	}
	
	/**
	 * Get mapping for update page
	 * @param email
	 * @param model
	 * @return
	 */
	@GetMapping("/update")
	public String update(@RequestParam("email") String email, Model model) {
		Employee employee = employeeService.getEmployeeByEmail(email);
		model.addAttribute("employee", employee);
		return "update";
	}
	
	/**
	 * Post mapping for update page
	 * @param employee
	 * @param result
	 * @param attributes
	 * @return
	 */
	@PostMapping("/update")
	public String updateEmployee(@Validated Employee employee, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "update";
		} else {
			if(!(employee.getPassword().equals(employee.getConfirmPassword()))) {
				ObjectError error = new ObjectError("errorMsg", "Password and confirm password should be same");
				result.addError(error);
				return "update";
			}
			employeeService.updateEmployee(employee);
			attributes.addFlashAttribute("Msg", "Updated successfully!!");
			return "home";
		}
	}
	
	/**
	 * get mapping for image upload page
	 * @param email
	 * @param model
	 * @return
	 */
	@GetMapping("/fileUpload")
	public String fileUpload(@RequestParam("email") String email, Model model){
		model.addAttribute("image", new ImageDto());
		return "imageUpload";
	}

	/**
	 * post mapping for image upload page
	 * @param image
	 * @param result
	 * @param attribute
	 * @return
	 * @throws IOException 
	 */
	@PostMapping("/fileUpload")
	public String doFileUpload(@Validated ImageDto imageDto, BindingResult result, RedirectAttributes attribute) throws IOException{
		String fileName = null;
		if(result.hasErrors()){
			return "imageUpload";
		}else{
			if (employeeService.getImage(imageDto.getEmail()) != null)  {
				MultipartFile image1 = imageDto.getImage();
				String uploadPath = "C:/Users/praka_000/Downloads/MetacubeParkingJdbc (4)/MetacubeParkingJdbc/MetacubeParkingJdbc/src/main/resources/static/images/" + imageDto.getImage().getOriginalFilename();
				FileCopyUtils.copy(imageDto.getImage().getBytes(), new File(uploadPath));
				fileName = image1.getOriginalFilename();
			}
			else {
				fileName = "default.jpg";
			}
			employeeService.addImage(fileName, imageDto.getEmail());
			attribute.addAttribute("img", imageDto.getImage());
			attribute.addAttribute("email",imageDto.getEmail());
			attribute.addFlashAttribute("Msg","Image Sucessfully Updated!");
			return "redirect:/home";
		}
	}

	/**
	 * Get mapping for friends page
	 * @param email
	 * @param model
	 * @return
	 */
	@GetMapping("/friends")
	public String friends(@RequestParam("email") String email, Model model) {
		List<Employee> friends = new ArrayList<Employee>();
		friends = employeeService.getFriends(email);
		model.addAttribute("friends", friends);
		System.out.println(friends.size());
		return "friends";
	}
	
	/**
	 * Get mapping for friends profile page
	 * @param email
	 * @param model
	 * @return
	 */
	@GetMapping("/friendProfile")
	public String getFriendProfile(@RequestParam("email") String email, Model model) {
		Employee friend = employeeService.getEmployeeByEmail(email);
		model.addAttribute("friend", friend);
		return "friendProfile";
	}
	
	
	/**
	 * Get mapping for logout
	 * @param request
	 * @return
	 */
	@GetMapping("/logout")
	public String logOut(HttpServletRequest request) {
		HttpSession session= request.getSession(false);
		if(session != null){
			session.invalidate();
		}
		return "redirect:/login";
	}
}
