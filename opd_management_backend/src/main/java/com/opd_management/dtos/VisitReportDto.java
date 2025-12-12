package com.opd_management.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class VisitReportDto {

    @NotBlank(message = "File name is required")
    @Size(max = 100, message = "File name must be under 100 characters")
    private String file_name;

    @NotBlank(message = "File URL is required")
    @Pattern( regexp = "^(https?|ftp)://.*$",message = "File URL must be a valid URL")
    private String file_url;

    @NotBlank(message = "File type is required")
    @Pattern(regexp = "^(PDF|JPG|JPEG|PNG|DOC|DOCX)$",message = "File type must be one of: PDF, JPG, JPEG, PNG, DOC, DOCX")
    private String file_type;

    @NotNull(message = "Created date is required")
    @PastOrPresent(message = "date must be past or present")
    private Date created_at;

    @Positive(message = "Visit ID must be a positive number")
    @NotNull(message = "Id cannot be null")
    private int visitid;


    // ---------------- GETTERS & SETTERS ----------------

    public String getFile_name() {
        return file_name;
    }
    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_url() {
        return file_url;
    }
    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getFile_type() {
        return file_type;
    }
    public void setFile_type(String file_type) {
        this.file_type = file_type;
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
