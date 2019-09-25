package com.metacube.MetacubeParkingJdbc.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * pojo class for employee with validations.
 * @author Khushi
 *
 */
public class Employee {
	
	@NotBlank(message = "{blankMsg}")
	@Size(min = 3, message = "{fullNameMsg}")
	@Pattern(regexp = "^[A-Za-z\\s]+$", message = "{fullNameRegExpMsg}")
	private String fullName;
	
	private String gender;
	
	@NotBlank(message = "{blankMsg}")
	@Pattern(regexp = "^[A-Za-z0-9.]+@[A-Za-z0-9]+\\.[A-Za-z0-9]{2,4}$", message = "{emailMsg}")
	private String emailId;
	
	@NotBlank(message = "{blankMsg}")
	private String password;
	
	@NotBlank(message = "{blankMsg}")
	private String confirmPassword;
	
	@NotBlank(message = "{blankMsg}")
	private String contactNumber;
	
	private String organization;
	
	public String getFullName() { 
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getOrganization() {
		return organization;
	}
	
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
}
