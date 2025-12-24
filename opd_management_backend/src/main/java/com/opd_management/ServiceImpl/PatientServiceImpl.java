package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.opd_management.Exception.DataBaseException;
import com.opd_management.Exception.ResourceNotFoundException;
import com.opd_management.Repositories.PatientRepository;
import com.opd_management.Services.PatientService;
import com.opd_management.entities.Bill;
import com.opd_management.entities.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	// creating object of patient repository
	@Autowired
	private PatientRepository patientRepository;
	
	//access repository methods
	@Override
	public Patient savePatient(Patient patient) {
		try {
			return patientRepository.save(patient);//repository method
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to save Patient due to database error" ,e);
		}
		
	}

	@Override
	public List<Patient> getAllPatient() {
		try {
			return patientRepository.findAll();//repository method
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to Show Patient due to database error", e);
		}
		
	}

	@Override
	public Patient getPatientByID(int id) {
		try {
			return patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient Not Found With this id: "+ id));//repository method
		} catch (DataAccessException e) {
			throw new DataBaseException("Failed to Show Patient due to database error"+ id ,e);
		}
		
	}

	@Override
	public void DeletePatientByID(int id) {
		Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException( "Patient not found with id: " + id));
		
		try {
			patientRepository.delete(patient);
		} catch (DataAccessException e) {
			throw new DataBaseException("Database error while deleting Patient with id: " + id,e);
		}
	}

	@Override
	public List<Patient> getPatientsByDoctor(int doctorId) {
	    return patientRepository.findByDoctorid_Id(doctorId);
	}


}
