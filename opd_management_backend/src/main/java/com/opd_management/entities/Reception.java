package com.opd_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="receptions",uniqueConstraints = @UniqueConstraint(columnNames ="email"))
public class Reception {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long phoneNo;
	private String shift;
	private String password;
	
	@ManyToOne
	@JoinColumn(name="doctorId")
	@JsonIgnoreProperties(value="{doctorid}",allowSetters = true)
	private Doctor doctorid;

	
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

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
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

	public Doctor getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(Doctor doctorid) {
		this.doctorid = doctorid;
	}

	public Reception(int id, String name, String email, long phoneNo, String shift, String password, Doctor doctorid) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.shift = shift;
		this.password = password;
		this.doctorid = doctorid;
	}

	public Reception() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Reception [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", shift="
				+ shift + ", password=" + password + ", doctorid=" + doctorid + "]";
	}
	
	
	
}
