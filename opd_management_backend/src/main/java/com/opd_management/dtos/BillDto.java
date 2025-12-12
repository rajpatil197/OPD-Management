package com.opd_management.dtos;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class BillDto {

	@NotNull(message = "Consultation fee is Required")
	@DecimalMin(value ="0.0",inclusive = false,message = "Consultation fee must be greater than 0")
	private BigDecimal consultation_fee;
	
	@NotBlank(message = "Payment Status is Required")
	private String payment_status;
	
	@NotBlank(message = "Payment Mode is Required")
	private String payment_mode;
	
	@NotBlank(message = "Concession field cannot be empty")
	private String concession;
	
	@NotNull(message = "Paid Amount is Required")
	@PositiveOrZero(message = "Paid Amount cannot be zero")
	private BigDecimal paid_amount;
	
	@NotNull(message = "Total amount is required")
	@PositiveOrZero(message = "Total amount cannot be negative")
	private BigDecimal total_amount;
	

    @NotNull(message = "Pending amount is required")
    @PositiveOrZero(message = "Pending amount cannot be negative")
	private BigDecimal pending_amount;
    
    @PastOrPresent(message = "Creating date must be past or present")
	private Date created_at;
    
    @Positive(message = "Id must be Positive")
    @NotNull(message = "visitid must be required")
	private int visitid;
	
	
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
	public int getVisitid() {
		return visitid;
	}
	public void setVisitid(int visitid) {
		this.visitid = visitid;
	}
	
	
}
