package com.opd_management.dtos;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DoctorDto {

	@NotBlank(message = "name is required")
	@Size(min = 3,max = 50 ,message = "Name must be between 3–50 characters")
	private String name;
	
	@NotBlank(message = "Email is Required")
	@Email(message = "Enter Valid Email address")
	private String email;
	
	@NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters")
	private String password;
	
	@NotBlank(message = "Specialization is required")
	private String specialization;
	
	@NotBlank(message = "Clinic name is required")
	private String clinic_name;
	
	@NotBlank(message = "Address cannot be empty")
	private String address;
	
	@NotBlank(message = "Mobile number is required")
	@Pattern(regexp="^[0-9]{10}$",message = "Mobile number must be exactly 10 digits")
	private String mobileno;
	
	private String token;
	
	@NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "Created date is required")
    @PastOrPresent(message = "Date must be past or present")
    private Date created_at;

    
    @NotNull(message = "Updated date is required")
    private Date updated_at;
	
	// getter and setter 
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getClinic_name() {
		return clinic_name;
	}
	public void setClinic_name(String clinic_name) {
		this.clinic_name = clinic_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
	
}
