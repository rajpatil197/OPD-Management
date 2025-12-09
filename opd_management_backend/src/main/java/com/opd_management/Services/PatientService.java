package com.opd_management.Services;

import java.util.List;

import com.opd_management.entities.Patient;

public interface PatientService {

	Patient savePatient(Patient patient);//user defined method for save data
	
	List<Patient> getAllPatient(); //user defined method for show list of patient data
	
	Patient getPatientByID(int id); //user defined method for show patient data by there id
	
	void DeletePatientByID(int id); //user defined method for delete patient data by there id
	
	List<Patient> getPatientsByDoctor(int doctorId);


}
