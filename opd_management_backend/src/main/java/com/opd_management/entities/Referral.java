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
@Table(name="referrals")// table name
public class Referral {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String note_type;
	private String reason;
	private String deatils;
	private Date created_at;
	
	//Table Relation
	@ManyToOne
	@JoinColumn(name="visitId")
	@JsonIgnoreProperties(value="{visitid}",allowSetters = true)
	private Visit visitid;
	
	@ManyToOne
	@JoinColumn(name="patientId")
	@JsonIgnoreProperties(value="{patientid}",allowSetters = true)
	private Patient patientid;
	
	@ManyToOne
	@JoinColumn(name="doctorId")
	@JsonIgnoreProperties(value="{doctorid}",allowSetters = true)
	private Doctor doctorid;
	
	@ManyToOne
	@JoinColumn(name="referralCenterId")
	@JsonIgnoreProperties(value="{referralCenterid}",allowSetters = true)
	private ReferralCenter referralCenterid;

	//getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Visit getVisitid() {
		return visitid;
	}

	public void setVisitid(Visit visitid) {
		this.visitid = visitid;
	}

	public Patient getPatientid() {
		return patientid;
	}

	public void setPatientid(Patient patientid) {
		this.patientid = patientid;
	}

	public Doctor getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(Doctor doctorid) {
		this.doctorid = doctorid;
	}

	public ReferralCenter getReferralCenterid() {
		return referralCenterid;
	}

	public void setReferralCenterid(ReferralCenter referralCenterid) {
		this.referralCenterid = referralCenterid;
	}

	//contructor
	public Referral(int id, String note_type, String reason, String deatils, Date created_at, Visit visitid,
			Patient patientid, Doctor doctorid, ReferralCenter referralCenterid) {
		super();
		this.id = id;
		this.note_type = note_type;
		this.reason = reason;
		this.deatils = deatils;
		this.created_at = created_at;
		this.visitid = visitid;
		this.patientid = patientid;
		this.doctorid = doctorid;
		this.referralCenterid = referralCenterid;
	}

	//contructor
	public Referral() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Referrals [id=" + id + ", note_type=" + note_type + ", reason=" + reason + ", deatils=" + deatils
				+ ", created_at=" + created_at + ", visitid=" + visitid + ", patientid=" + patientid + ", doctorid="
				+ doctorid + ", referralCenterid=" + referralCenterid + "]";
	}
	
	
	
}
