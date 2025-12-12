package com.opd_management.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ReceptionDto {

	 	@NotBlank(message = "Receptionist name is required")
	 	@Size(min = 3, max = 40, message = "Name must be between 3–40 characters")
	    private String name;

	    @NotBlank(message = "Email is required")
	    @Email(message = "Please enter a valid email")
	    private String email;

	    @NotBlank(message = "Phone number is required")
	    @Pattern(regexp = "^[0-9]{10}$",message = "Phone number must be exactly 10 digits")
	    private String phoneNo;

	    @NotBlank(message = "Shift is required")
	    private String shift;

	    @NotBlank(message = "Password is required")
	    @Size(min = 6, message = "Password must be at least 6 characters")
	    private String password;

	    @Positive(message = "Doctor ID must be a positive number")
	    @NotNull(message = "id cannot be null")
	    private int doctorid;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	
	
}
