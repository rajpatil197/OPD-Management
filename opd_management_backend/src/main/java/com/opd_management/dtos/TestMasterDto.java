package com.opd_management.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class TestMasterDto {

    @NotBlank(message = "Test name is required")
    @Size(min = 2, max = 50, message = "Test name must be between 2–50 characters")
    private String test_name;

    @NotBlank(message = "Normal range is required")
    private String normal_range;

    @NotBlank(message = "Unit is required")
    private String unit;

    @Positive(message = "Doctor ID must be a positive number")
    @NotNull(message = "id cannot be null")
    private int doctorid;


    // ---------------- GETTERS & SETTERS ----------------

    public String getTest_name() {
        return test_name;
    }
    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public String getNormal_range() {
        return normal_range;
    }
    public void setNormal_range(String normal_range) {
        this.normal_range = normal_range;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getDoctorid() {
        return doctorid;
    }
    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }
}
