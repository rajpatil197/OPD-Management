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
@Table(name="pathologytest")//Table name
public class PathologyTest {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String result;
	private String remarks;
	private String report_file;
	private Date created_at;
	
	//table relation
	@ManyToOne
	@JoinColumn(name="visitId")
	@JsonIgnoreProperties(value="{visitid}",allowSetters = true)
	private Visit visitid;
	
	@ManyToOne
	@JoinColumn(name="testmasterId")
	@JsonIgnoreProperties(value="{testmasterid}",allowSetters = true)
	private TestMaster testmasterid;

	//getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getReport_file() {
		return report_file;
	}

	public void setReport_file(String report_file) {
		this.report_file = report_file;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Visit getVisitid() {
		return visitid;
	}

	public void setVisitid(Visit visitid) {
		this.visitid = visitid;
	}

	public TestMaster getTestmasterid() {
		return testmasterid;
	}

	public void setTestmasterid(TestMaster testmasterid) {
		this.testmasterid = testmasterid;
	}

	//contructor
	public PathologyTest(int id, String result, String remarks, String report_file, Date created_at, Visit visitid,
			TestMaster testmasterid) {
		super();
		this.id = id;
		this.result = result;
		this.remarks = remarks;
		this.report_file = report_file;
		this.created_at = created_at;
		this.visitid = visitid;
		this.testmasterid = testmasterid;
	}

	//contructor
	public PathologyTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PathologyTest [id=" + id + ", result=" + result + ", remarks=" + remarks + ", report_file="
				+ report_file + ", created_at=" + created_at + ", visitid=" + visitid + ", testmasterid=" + testmasterid
				+ "]";
	}
	
	
}
