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
@Table(name="testmasters")//table name
public class TestMaster {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String test_name;
	private String normal_range;
	private String unit;
	
	//table relation
	@ManyToOne
	@JoinColumn(name="doctorId")
	@JsonIgnoreProperties(value="{doctorid}",allowSetters = true)
	private Doctor doctorid;

	//getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	public String getNormal_range() {
		return normal_range;
	}

	public void setNormal_range(String normal_range) {
		this.normal_range = normal_range;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Doctor getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(Doctor doctorid) {
		this.doctorid = doctorid;
	}

	//contructor
	public TestMaster(int id, String test_name, String normal_range, String unit, Doctor doctorid) {
		super();
		this.id = id;
		this.test_name = test_name;
		this.normal_range = normal_range;
		this.unit = unit;
		this.doctorid = doctorid;
	}

	//contructor
	public TestMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TestMaster [id=" + id + ", test_name=" + test_name + ", normal_range=" + normal_range + ", unit=" + unit
				+ ", doctorid=" + doctorid + "]";
	}
	
	
	
}
