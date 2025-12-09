package com.opd_management.Services;

import java.util.List;

import com.opd_management.entities.Medicine;

public interface MedicineService {

	Medicine saveMedicine(Medicine medicine);
	List<Medicine> GetAllMedicine();
	Medicine GetMedicineById(int id);
	void DeleteMedicine(int id);
}
