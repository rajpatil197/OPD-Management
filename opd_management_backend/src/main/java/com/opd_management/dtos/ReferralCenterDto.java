package com.opd_management.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ReferralCenterDto {

    @NotBlank(message = "Center name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3–50 characters")
    private String name;

    @NotBlank(message = "Center type is required")
    private String type;

    @NotBlank(message = "Contact information is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be a valid 10-digit mobile number")
    private String contact_info;

    @NotBlank(message = "Address is required")
    private String address;

    @NotNull(message = "Created date is required")
    @PastOrPresent(message = "Date must be past or present")
    private Date created_at;

    @Positive(message = "Doctor ID must be a positive number")
    @NotNull(message = "id cannot be null")
    private int doctorid;


    // ---------------- GETTERS & SETTERS ----------------

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getContact_info() {
        return contact_info;
    }
    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getDoctorid() {
        return doctorid;
    }
    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }
}
