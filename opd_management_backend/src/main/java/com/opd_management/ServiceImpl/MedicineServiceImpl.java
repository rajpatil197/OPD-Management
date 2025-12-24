package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.opd_management.Exception.DataBaseException;
import com.opd_management.Exception.ResourceNotFoundException;
import com.opd_management.Repositories.MedicineRepository;
import com.opd_management.Services.MedicineService;
import com.opd_management.entities.Bill;
import com.opd_management.entities.Medicine;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineRepository medicineRepository;
	
	@Override
	public Medicine saveMedicine(Medicine medicine) {
		try {
			return medicineRepository.save(medicine);
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to save medicine due to database error" ,e);
		}
		
	}

	@Override
	public List<Medicine> GetAllMedicine() {
		try {
			return medicineRepository.findAll();
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to Show medicine due to database error", e);
		}
		
	}

	@Override
	public Medicine GetMedicineById(int id) {
		try {
			return medicineRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Medicine Not Found With this id: "+ id));
		} catch (DataAccessException e) {
			throw new DataBaseException("Failed to Show medicine due to database error"+ id ,e);
		}
		
	}

	@Override
	public void DeleteMedicine(int id) {
			Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException( "Medicine not found with id: " + id));
		
		try {
			medicineRepository.delete(medicine);
		} catch (DataAccessException e) {
			throw new DataBaseException("Database error while deleting Medicine with id: " + id,e);
		}
		
	}

}
