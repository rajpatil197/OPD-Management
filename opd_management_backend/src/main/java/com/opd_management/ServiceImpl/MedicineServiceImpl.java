package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.Repositories.MedicineRepository;
import com.opd_management.Services.MedicineService;
import com.opd_management.entities.Medicine;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineRepository medicineRepository;
	
	@Override
	public Medicine saveMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return medicineRepository.save(medicine);
	}

	@Override
	public List<Medicine> GetAllMedicine() {
		// TODO Auto-generated method stub
		return medicineRepository.findAll();
	}

	@Override
	public Medicine GetMedicineById(int id) {
		// TODO Auto-generated method stub
		return medicineRepository.findById(id).orElse(null);
	}

	@Override
	public void DeleteMedicine(int id) {
		// TODO Auto-generated method stub
		medicineRepository.deleteById(id);
	}

}
