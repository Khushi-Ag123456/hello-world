package com.metacube.MetacubeParkingJdbc.model;

import java.sql.Blob;

import javax.validation.constraints.NotBlank;

/**
 * pojo class for image
 * @author Khushi
 *
 */
public class Image {

	
	
	private String image;
	
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

	
}
