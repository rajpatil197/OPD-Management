package com.opd_management.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="patients")//table name
public class Patient {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String patient_name;
	private int age;
	private String gender;
	private String mobileno;
	private String address;
	private String blood_group;
	private String height;
	private String smoking;
	private String alcohol;
	private String tobacco;
	private Date created_at;
	
	@ManyToOne // connection of table in many to one 
	@JoinColumn(name="doctorId")
	@JsonIgnoreProperties(value={"doctorid"},allowSetters = true)
	private Doctor doctorid; //creating object

	
	//getter and setter to get and set details
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Doctor getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(Doctor doctorid) {
		this.doctorid = doctorid;
	}

	
	//parametrized contructor
	public Patient(int id, String patient_name, int age, String gender, String mobileno, String address,
			String blood_group, String height, String smoking, String alcohol, String tobacco, Date created_at,
			Doctor doctorid) {
		super();
		this.id = id;
		this.patient_name = patient_name;
		this.age = age;
		this.gender = gender;
		this.mobileno = mobileno;
		this.address = address;
		this.blood_group = blood_group;
		this.height = height;
		this.smoking = smoking;
		this.alcohol = alcohol;
		this.tobacco = tobacco;
		this.created_at = created_at;
		this.doctorid = doctorid;
	}

	//contructor
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", patient_name=" + patient_name + ", age=" + age + ", gender=" + gender
				+ ", mobileno=" + mobileno + ", address=" + address + ", blood_group=" + blood_group + ", height="
				+ height + ", smoking=" + smoking + ", alcohol=" + alcohol + ", tobacco=" + tobacco + ", created_at="
				+ created_at + ", doctorid=" + doctorid + "]";
	}
	
	
	
}
