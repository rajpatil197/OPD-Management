package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.opd_management.Exception.DataBaseException;
import com.opd_management.Exception.ResourceNotFoundException;
import com.opd_management.Repositories.PrescriptionRepository;
import com.opd_management.Services.PrescriptionService;
import com.opd_management.entities.PathologyTest;
import com.opd_management.entities.Prescription;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Override
	public Prescription savePrescription(Prescription prescription) {
		try {
			return prescriptionRepository.save(prescription);
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to save Prescription due to database error" ,e);
		}
	}

	@Override
	public List<Prescription> GetAllPrescription() {
		try {
			return prescriptionRepository.findAll();
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to Show Prescription due to database error", e);
		}
	}

	@Override
	public Prescription GetPrescriptionById(int id) {
		try {
			return prescriptionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Prescription Not Found With this id: "+ id));
		} catch (DataAccessException e) {
			throw new DataBaseException("Failed to Show Prescription due to database error"+ id ,e);
		}
	}

	@Override
	public void DeletePrescription(int id) {
		Prescription prescription = prescriptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException( "Prescription not found with id: " + id));
		
		try {
			prescriptionRepository.delete(prescription);
		} catch (DataAccessException e) {
			throw new DataBaseException("Database error while deleting Prescription with id: " + id,e);
		}
	}

}
