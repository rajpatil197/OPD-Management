package com.opd_management.entities;

import java.math.BigDecimal;
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
@Table(name="bills")//table name
public class Bill {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private BigDecimal consultation_fee;
	private String payment_status;
	private String payment_mode;
	private String concession;
	private BigDecimal paid_amount;
	private BigDecimal total_amount;
	private BigDecimal pending_amount;
	private Date created_at;
	
	//relation of tables
	@ManyToOne
	@JoinColumn(name="visitId")
	@JsonIgnoreProperties(value="{visitid}",allowSetters = true)
	private Visit visitid;

	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getConsultation_fee() {
		return consultation_fee;
	}

	public void setConsultation_fee(BigDecimal consultation_fee) {
		this.consultation_fee = consultation_fee;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public String getConcession() {
		return concession;
	}

	public void setConcession(String concession) {
		this.concession = concession;
	}

	public BigDecimal getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(BigDecimal paid_amount) {
		this.paid_amount = paid_amount;
	}

	public BigDecimal getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(BigDecimal total_amount) {
		this.total_amount = total_amount;
	}

	public BigDecimal getPending_amount() {
		return pending_amount;
	}

	public void setPending_amount(BigDecimal pending_amount) {
		this.pending_amount = pending_amount;
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

	//contructor with parameter
	public Bill(int id, BigDecimal consultation_fee, String payment_status, String payment_mode, String concession,
			BigDecimal paid_amount, BigDecimal total_amount, BigDecimal pending_amount, Date created_at,
			Visit visitid) {
		super();
		this.id = id;
		this.consultation_fee = consultation_fee;
		this.payment_status = payment_status;
		this.payment_mode = payment_mode;
		this.concession = concession;
		this.paid_amount = paid_amount;
		this.total_amount = total_amount;
		this.pending_amount = pending_amount;
		this.created_at = created_at;
		this.visitid = visitid;
	}

	//contructor
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", consultation_fee=" + consultation_fee + ", payment_status=" + payment_status
				+ ", payment_mode=" + payment_mode + ", concession=" + concession + ", paid_amount=" + paid_amount
				+ ", total_amount=" + total_amount + ", pending_amount=" + pending_amount + ", created_at=" + created_at
				+ ", visitid=" + visitid + "]";
	}
	
	
}
