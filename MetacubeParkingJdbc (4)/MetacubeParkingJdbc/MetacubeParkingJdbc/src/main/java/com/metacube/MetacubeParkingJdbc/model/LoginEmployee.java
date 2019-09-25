package com.metacube.MetacubeParkingJdbc.model;

import javax.validation.constraints.NotBlank;

/**
 * Pojo class for employee login with validations
 * @author Khushi
 *
 */
public class LoginEmployee {

	@NotBlank(message = "{blankMsg}")
	private String emailId;
	
	@NotBlank(message = "{blankMsg}")
	private String password;

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
}
