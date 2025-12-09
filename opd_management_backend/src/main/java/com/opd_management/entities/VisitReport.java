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
@Table(name="visitreports")//table name
public class VisitReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String file_name;
	private String file_url;
	private String file_type;
	private Date created_at;
	
	//table relation
	@ManyToOne
	@JoinColumn(name="visitId")
	@JsonIgnoreProperties(value="{visitid}",allowSetters = true)
	private Visit visitid;

	// getter and setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_url() {
		return file_url;
	}

	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date creared_at) {
		this.created_at = created_at;
	}

	public Visit getVisitid() {
		return visitid;
	}

	public void setVisitid(Visit visitid) {
		this.visitid = visitid;
	}

	//contructor
	public VisitReport(int id, String file_name, String file_url, String file_type, Date created_at, Visit visitid) {
		super();
		this.id = id;
		this.file_name = file_name;
		this.file_url = file_url;
		this.file_type = file_type;
		this.created_at = created_at;
		this.visitid = visitid;
	}

	//contructor
	public VisitReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "VisitReport [id=" + id + ", file_name=" + file_name + ", file_url=" + file_url + ", file_type="
				+ file_type + ", created_at=" + created_at + ", visitid=" + visitid + "]";
	}
	
	
}
