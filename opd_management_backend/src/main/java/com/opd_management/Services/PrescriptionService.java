package com.opd_management.Services;

import java.util.List;

import com.opd_management.entities.Prescription;

public interface PrescriptionService {

	Prescription savePrescription(Prescription prescription);
	
	List<Prescription> GetAllPrescription();
	
	Prescription GetPrescriptionById(int id);
	
	void DeletePrescription(int id);
	
}
