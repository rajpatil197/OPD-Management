package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.Repositories.PrescriptionRepository;
import com.opd_management.Services.PrescriptionService;
import com.opd_management.entities.Prescription;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Override
	public Prescription savePrescription(Prescription prescription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prescription> GetAllPrescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prescription GetPrescriptionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeletePrescription(int id) {
		// TODO Auto-generated method stub

	}

}
