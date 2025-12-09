package com.opd_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="medicines")//table name
public class Medicine {

	//table Relation
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String medicine_name;
	private String type;
	
	@ManyToOne
	@JoinColumn(name="doctorId")
	@JsonIgnoreProperties(value= {"doctorid"},allowSetters = true)
	private Doctor doctorid;

	//getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Doctor getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(Doctor doctorid) {
		this.doctorid = doctorid;
	}

	//contructor
	public Medicine(int id, String medicine_name, String type, Doctor doctorid) {
		super();
		this.id = id;
		this.medicine_name = medicine_name;
		this.type = type;
		this.doctorid = doctorid;
	}
	//contructor
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", medicine_name=" + medicine_name + ", type=" + type + ", doctorid=" + doctorid
				+ "]";
	}
	
	
}
