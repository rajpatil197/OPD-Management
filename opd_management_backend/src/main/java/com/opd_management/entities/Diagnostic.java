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
@Table(name="diagnostics")//table name
public class Diagnostic {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Date created_at;
	
	
	//table relation
	@ManyToOne
	@JoinColumn(name="doctorId")
	@JsonIgnoreProperties(value= {"doctorid"},allowSetters = true)
	private Doctor doctorid;
	
	//table relation
	@ManyToOne
	@JoinColumn(name="visitId")
	@JsonIgnoreProperties (value = {"visitid"},allowSetters = true)
	private Visit visitid;

	//getter and setter
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

	public Visit getVisitid() {
		return visitid;
	}

	public void setVisitid(Visit visitid) {
		this.visitid = visitid;
	}

	
	//contructor 
	public Diagnostic(int id, String name, Date created_at, Doctor doctorid, Visit visitid) {
		super();
		this.id = id;
		this.name = name;
		this.created_at = created_at;
		this.doctorid = doctorid;
		this.visitid = visitid;
	}

	//contructor
	public Diagnostic() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Diagnostic [id=" + id + ", name=" + name + ", created_at=" + created_at + ", doctorid=" + doctorid
				+ ", visitid=" + visitid + "]";
	}
	
	
	
}
