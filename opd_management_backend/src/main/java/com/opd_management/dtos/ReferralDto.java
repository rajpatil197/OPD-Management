package com.opd_management.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ReferralDto {

    @NotBlank(message = "Note type is required")
    private String note_type;

    @NotBlank(message = "Reason is required")
    private String reason;

    @NotBlank(message = "Details field cannot be empty")
    @Size(min = 5, message = "Details must contain at least 5 characters")
    private String deatils;  // (typo kept because your code uses it)

    @NotNull(message = "Created date is required")
    @PastOrPresent(message = "Date must Past or Present")
    private Date created_at;

    @Positive(message = "Visit ID must be a positive number")
    @NotNull(message = "id cannot be null")
    private int visitid;

    @Positive(message = "Patient ID must be a positive number")
    @NotNull(message = "id cannot be null")
    private int patientid;

    @Positive(message = "Doctor ID must be a positive number")
    @NotNull(message = "id cannot be null")
    private int doctorid;

    @Positive(message = "Referral Center ID must be a positive number")
    @NotNull(message = "id cannot be null")
    private int referralCenterid;


    // ---------------- GETTERS & SETTERS ----------------

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
