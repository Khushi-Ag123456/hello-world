package com.metacube.StudentJPA.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.StudentJPA.model.Student;
import com.metacube.StudentJPA.service.StudentService;


@Controller
public class HomeController {
	
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	StudentService studentService = ctx.getBean(StudentService.class);
	
	@Value("${home.message}")
	private String welcomeMsg;
	
	/**
	 * to send to home page
	 * @param model
	 * @return
	 */
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("welcomeMsg", welcomeMsg);
		return "home";
	}
	
	/**
	 * to send to signup page
	 * @param model
	 * @return
	 */
	@GetMapping("/signUp") 
	public String signUp(Model model) {
		model.addAttribute("student", new Student());
		return "signUp";
	}
	
	/**
	 * to check validations
	 * @param student
	 * @param result
	 * @return
	 */
	@PostMapping("/signUp") 
	@Transactional
	public String doSignUp(@Validated Student student, BindingResult result, RedirectAttributes attributes, Model model) {
		if (result.hasErrors()) {
			return "signUp";
			
		} else {
			System.out.println(student);
			studentService.addStudent(student);
			}
			return "redirect:/home";	
	}
	
	/**
	 * To show students
	 * @param model model object
	 * @return showStudents page
	 */
	@GetMapping("/showStudent") 
    @Transactional(readOnly=true)
	public String showStudents(Model model) {
		List<Student> studentList = new ArrayList<Student>();
		studentList = studentService.showStudents();
		model.addAttribute("Students", studentList);
		return "showStudents";
	}
}
