package com.opd_management.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class MedicineDto {

	@NotBlank(message = "Medicine Name is required")
	@Size(min = 3,max = 50 ,message = "Name must be between 3–50 characters")
	private String medicine_name;
	
	@NotBlank(message = "Type must be required")
	private String type;
	
	@NotNull(message = "visitid must be required")
	@Positive(message = "Id must be positive")
	private int doctorid;
	
	
	public String getMedicine_name() {
		return medicine_name;
	}
	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	
	
}
