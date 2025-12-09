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
@Table(name="visits")//table name
public class Visit {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private Date visit_date;
	private String complaints;
	private String diagnosis;
	private String advice;
	private String bp;
	private String pulse;
	private String saturation;
	private String temperature;
	private String respiration_rate;
	private String sugar;
	private String fasting_sugar;
	private String pp_sugar;
	private String random_sugar;
	private String urea_creatine;
	private String past_history;
	private String current_medication;
	private String additional_notes;
	private int weight;
	private String edema;
	private String pallor;
	private String jaundice;
	private String cvs;
	private String rs;
	private String pa;
	private String cns;
	private String hb;
	private String ecg;
	private Date followup_date;
	private Date created_at;
	private Date updated_at;
	
	//table relation
	@ManyToOne
	@JoinColumn(name="doctorId")
	@JsonIgnoreProperties(value= {"doctorid"},allowSetters = true)
	private Doctor doctorid;
	
	@ManyToOne
	@JoinColumn(name="patientId")
	@JsonIgnoreProperties(value= {"patientid"},allowSetters = true)
	private Patient patientid;

	//getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getVisit_date() {
		return visit_date;
	}

	public void setVisit_date(Date visit_date) {
		this.visit_date = visit_date;
	}

	public String getComplaints() {
		return complaints;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getPulse() {
		return pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

	public String getSaturation() {
		return saturation;
	}

	public void setSaturation(String saturation) {
		this.saturation = saturation;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getRespiration_rate() {
		return respiration_rate;
	}

	public void setRespiration_rate(String respiration_rate) {
		this.respiration_rate = respiration_rate;
	}

	public String getSugar() {
		return sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	public String getFasting_sugar() {
		return fasting_sugar;
	}

	public void setFasting_sugar(String fasting_sugar) {
		this.fasting_sugar = fasting_sugar;
	}

	public String getPp_sugar() {
		return pp_sugar;
	}

	public void setPp_sugar(String pp_sugar) {
		this.pp_sugar = pp_sugar;
	}

	public String getRandom_sugar() {
		return random_sugar;
	}

	public void setRandom_sugar(String random_sugar) {
		this.random_sugar = random_sugar;
	}

	public String getUrea_creatine() {
		return urea_creatine;
	}

	public void setUrea_creatine(String urea_creatine) {
		this.urea_creatine = urea_creatine;
	}

	public String getPast_history() {
		return past_history;
	}

	public void setPast_history(String past_history) {
		this.past_history = past_history;
	}

	public String getCurrent_medication() {
		return current_medication;
	}

	public void setCurrent_medication(String current_medication) {
		this.current_medication = current_medication;
	}

	public String getAdditional_notes() {
		return additional_notes;
	}

	public void setAdditional_notes(String additional_notes) {
		this.additional_notes = additional_notes;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getEdema() {
		return edema;
	}

	public void setEdema(String edema) {
		this.edema = edema;
	}

	public String getPallor() {
		return pallor;
	}

	public void setPallor(String pallor) {
		this.pallor = pallor;
	}

	public String getJaundice() {
		return jaundice;
	}

	public void setJaundice(String jaundice) {
		this.jaundice = jaundice;
	}

	public String getCvs() {
		return cvs;
	}

	public void setCvs(String cvs) {
		this.cvs = cvs;
	}

	public String getRs() {
		return rs;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}

	public String getPa() {
		return pa;
	}

	public void setPa(String pa) {
		this.pa = pa;
	}

	public String getCns() {
		return cns;
	}

	public void setCns(String cns) {
		this.cns = cns;
	}

	public String getHb() {
		return hb;
	}

	public void setHb(String hb) {
		this.hb = hb;
	}

	public String getEcg() {
		return ecg;
	}

	public void setEcg(String ecg) {
		this.ecg = ecg;
	}

	public Date getFollowup_date() {
		return followup_date;
	}

	public void setFollowup_date(Date followup_date) {
		this.followup_date = followup_date;
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

	public Doctor getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(Doctor doctorid) {
		this.doctorid = doctorid;
	}

	public Patient getPatientid() {
		return patientid;
	}

	public void setPatientid(Patient patientid) {
		this.patientid = patientid;
	}

	//contructor
	public Visit(int id, Date visit_date, String complaints, String diagnosis, String advice, String bp, String pulse,
			String saturation, String temperature, String respiration_rate, String sugar, String fasting_sugar,
			String pp_sugar, String random_sugar, String urea_creatine, String past_history, String current_medication,
			String additional_notes, int weight, String edema, String pallor, String jaundice, String cvs, String rs,
			String pa, String cns, String hb, String ecg, Date followup_date, Date created_at, Date updated_at,
			Doctor doctorid, Patient patientid) {
		super();
		this.id = id;
		this.visit_date = visit_date;
		this.complaints = complaints;
		this.diagnosis = diagnosis;
		this.advice = advice;
		this.bp = bp;
		this.pulse = pulse;
		this.saturation = saturation;
		this.temperature = temperature;
		this.respiration_rate = respiration_rate;
		this.sugar = sugar;
		this.fasting_sugar = fasting_sugar;
		this.pp_sugar = pp_sugar;
		this.random_sugar = random_sugar;
		this.urea_creatine = urea_creatine;
		this.past_history = past_history;
		this.current_medication = current_medication;
		this.additional_notes = additional_notes;
		this.weight = weight;
		this.edema = edema;
		this.pallor = pallor;
		this.jaundice = jaundice;
		this.cvs = cvs;
		this.rs = rs;
		this.pa = pa;
		this.cns = cns;
		this.hb = hb;
		this.ecg = ecg;
		this.followup_date = followup_date;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.doctorid = doctorid;
		this.patientid = patientid;
	}

	//contructor
	public Visit() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Visit [id=" + id + ", visit_date=" + visit_date + ", complaints=" + complaints + ", diagnosis="
				+ diagnosis + ", advice=" + advice + ", bp=" + bp + ", pulse=" + pulse + ", saturation=" + saturation
				+ ", temperature=" + temperature + ", respiration_rate=" + respiration_rate + ", sugar=" + sugar
				+ ", fasting_sugar=" + fasting_sugar + ", pp_sugar=" + pp_sugar + ", random_sugar=" + random_sugar
				+ ", urea_creatine=" + urea_creatine + ", past_history=" + past_history + ", current_medication="
				+ current_medication + ", additional_notes=" + additional_notes + ", weight=" + weight + ", edema="
				+ edema + ", pallor=" + pallor + ", jaundice=" + jaundice + ", cvs=" + cvs + ", rs=" + rs + ", pa=" + pa
				+ ", cns=" + cns + ", hb=" + hb + ", ecg=" + ecg + ", followup_date=" + followup_date + ", created_at="
				+ created_at + ", updated_at=" + updated_at + ", doctorid=" + doctorid + ", patientid=" + patientid
				+ "]";
	}
	
	
}
