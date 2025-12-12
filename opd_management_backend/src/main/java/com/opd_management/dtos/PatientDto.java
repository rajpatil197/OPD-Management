package com.opd_management.dtos;

import java.sql.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class PatientDto {

	 @NotBlank(message = "Patient name is required")
	 private String patient_name;

	 	@Positive(message = "Age must be positive")
	    @Min(value = 0, message = "Age cannot be negative")
	    private int age;

	    @NotBlank(message = "Gender is required")
	    private String gender;

	    @NotBlank(message = "Mobile number is required")
	    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits")
	    private String mobileno;

	    @NotBlank(message = "Address is required")
	    private String address;

	    @NotBlank(message = "Blood group is required")
	    @Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Invalid blood group format")
	    private String blood_group;

	    @NotBlank(message = "Height is required")
	    private String height;
	    
	    @NotBlank(message = "Smoking field is required")
	    @Pattern(regexp = "^(Yes|No)$",message = "Value must be yes or no")
	    private String smoking;   // optional
	    
	    @NotBlank(message = "Alcohol field is required")
	    @Pattern(regexp = "^(Yes|No)$",message = "Value must be yes or no")
	    private String alcohol;   // optional
	    
	    @NotBlank(message = "Tobacco field is required")
	    @Pattern(regexp = "^(Yes|No)$",message = "Value must be yes or no")
	    private String tobacco;   // optional

	    @NotNull(message = "Created date is required")
	    @PastOrPresent(message = "Date must past or present")
	    private Date created_at;

	    @Positive(message = "Doctor ID must be a positive number")
	    @NotNull(message = "Id must be not null")
	    private int doctorid;

	    
	
	//getter and setter 
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	public String getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}
	public String getTobacco() {
		return tobacco;
	}
	public void setTobacco(String tobacco) {
		this.tobacco = tobacco;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	
	
}
