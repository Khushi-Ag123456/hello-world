package com.metacube.MetacubeParkingJdbc.dto;

import org.springframework.web.multipart.MultipartFile;

public class ImageDto {

	private MultipartFile image;

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

}
