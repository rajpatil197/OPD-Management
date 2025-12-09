package com.opd_management.dtos;

import java.sql.Date;

public class ReferralDto {

	private String note_type;
	private String reason;
	private String deatils;
	private Date created_at;
	private int visitid;
	private int patientid;
	private int doctorid;
	private int referralCenterid;
	
	
	public String getNote_type() {
		return note_type;
	}
	public void setNote_type(String note_type) {
		this.note_type = note_type;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDeatils() {
		return deatils;
	}
	public void setDeatils(String deatils) {
		this.deatils = deatils;
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
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	public int getReferralCenterid() {
		return referralCenterid;
	}
	public void setReferralCenterid(int referralCenterid) {
		this.referralCenterid = referralCenterid;
	}
	
	
}
