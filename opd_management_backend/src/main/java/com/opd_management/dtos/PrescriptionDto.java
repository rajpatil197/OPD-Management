package com.opd_management.dtos;

import java.sql.Date;

public class PrescriptionDto {

	private String dosage;
	private String duration;
	private String instructions;
	private int quantity;
	private Date created_at;
	private int morning_dose;
	private int afternoon_dose;
	private int evening_dose;
	private int duration_days;
	private int total_quantity;
	private String quantity_note;
	private String dose_qty;
	private String dose_unit;
	private int visitid;
	private int medicineid;
	
	
	//getters and setters
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public int getMorning_dose() {
		return morning_dose;
	}
	public void setMorning_dose(int morning_dose) {
		this.morning_dose = morning_dose;
	}
	public int getAfternoon_dose() {
		return afternoon_dose;
	}
	public void setAfternoon_dose(int afternoon_dose) {
		this.afternoon_dose = afternoon_dose;
	}
	public int getEvening_dose() {
		return evening_dose;
	}
	public void setEvening_dose(int evening_dose) {
		this.evening_dose = evening_dose;
	}
	public int getDuration_days() {
		return duration_days;
	}
	public void setDuration_days(int duration_days) {
		this.duration_days = duration_days;
	}
	public int getTotal_quantity() {
		return total_quantity;
	}
	public void setTotal_quantity(int total_quantity) {
		this.total_quantity = total_quantity;
	}
	public String getQuantity_note() {
		return quantity_note;
	}
	public void setQuantity_note(String quantity_note) {
		this.quantity_note = quantity_note;
	}
	public String getDose_qty() {
		return dose_qty;
	}
	public void setDose_qty(String dose_qty) {
		this.dose_qty = dose_qty;
	}
	public String getDose_unit() {
		return dose_unit;
	}
	public void setDose_unit(String dose_unit) {
		this.dose_unit = dose_unit;
	}
	public int getVisitid() {
		return visitid;
	}
	public void setVisitid(int visitid) {
		this.visitid = visitid;
	}
	public int getMedicineid() {
		return medicineid;
	}
	public void setMedicineid(int medicineid) {
		this.medicineid = medicineid;
	}
	
	

	
}
