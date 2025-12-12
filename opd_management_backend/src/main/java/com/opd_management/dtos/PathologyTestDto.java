package com.opd_management.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public class PathologyTestDto {

	 @NotBlank(message = "Result is required")
	 private String result;

	 private String remarks;

	 @NotBlank(message = "Report file path is required")
	 private String report_file;

	 @NotNull(message = "Created date is required")
	 @PastOrPresent(message = "date must present or past")
	 private Date created_at;

	 @Positive(message = "Visit ID must be a positive integer")
	 @NotNull(message = "visitid must be required")
	 private int visitid;

	 @NotNull(message = "testMAster id must be required")
	 @Positive(message = "Test Master ID must be a positive integer")
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
