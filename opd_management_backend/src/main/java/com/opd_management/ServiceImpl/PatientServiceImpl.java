package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.Repositories.PatientRepository;
import com.opd_management.Services.PatientService;
import com.opd_management.entities.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	// creating object of patient repository
	@Autowired
	private PatientRepository patientRepository;
	
	//access repository methods
	@Override
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);//repository method
	}

	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();//repository method
	}

	@Override
	public Patient getPatientByID(int id) {
		// TODO Auto-generated method stub
		return patientRepository.findById(id).orElse(null);//repository method
	}

	@Override
	public void DeletePatientByID(int id) {
	 
		patientRepository.deleteById(id);//repository method
	}

	@Override
	public List<Patient> getPatientsByDoctor(int doctorId) {
	    return patientRepository.findByDoctorid_Id(doctorId);
	}


}
