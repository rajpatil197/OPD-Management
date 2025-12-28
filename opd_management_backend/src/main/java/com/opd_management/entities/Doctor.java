package com.opd_management.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name ="doctors")//table name
public class Doctor {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@Column(unique = true)
	private String email;
	private String password;
	private String role;
	private String specialization;
	private String clinic_name;
	private String qualification;
	private String address;
	@Column(unique = true)
	private String mobileno;
	private String token;
	private String status;
	private Date created_at;
	private Date updated_at;
	
	// getter and setter for the doctor table to get and set data
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
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
	
	
	public Doctor(int id, String name, String email, String password, String role, String specialization,
			String clinic_name, String qualification, String address, String mobileno, String token, String status,
			Date created_at, Date updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.specialization = specialization;
		this.clinic_name = clinic_name;
		this.qualification = qualification;
		this.address = address;
		this.mobileno = mobileno;
		this.token = token;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", specialization=" + specialization + ", clinic_name=" + clinic_name + ", qualification="
				+ qualification + ", address=" + address + ", mobileno=" + mobileno + ", token=" + token + ", status="
				+ status + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	
	
	
}
	