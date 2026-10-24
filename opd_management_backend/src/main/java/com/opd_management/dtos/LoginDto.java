package com.opd_management.dtos;

import jakarta.validation.constraints.NotBlank;

public class LoginDto {

	@NotBlank(message = "Email is Required")
	private String email;
	
	@NotBlank(message = "Password is Required")
	private String password;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
