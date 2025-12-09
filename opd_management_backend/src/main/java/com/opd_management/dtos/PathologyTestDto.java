package com.opd_management.dtos;

import java.sql.Date;

public class PathologyTestDto {

	private String result;
	private String remarks;
	private String report_file;
	private Date created_at;
	private int visitid;
	private int testmasterid;
	
	
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
	public int getVisitid() {
		return visitid;
	}
	public void setVisitid(int visitid) {
		this.visitid = visitid;
	}
	public int getTestmasterid() {
		return testmasterid;
	}
	public void setTestmasterid(int testmasterid) {
		this.testmasterid = testmasterid;
	}
	
	
}
