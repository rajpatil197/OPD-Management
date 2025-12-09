package com.opd_management.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opd_management.Services.DoctorService;
import com.opd_management.Services.MedicineService;
import com.opd_management.dtos.MedicineDto;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Medicine;

@RestController
@RequestMapping("/medicines") // Base URL for medicine APIs
public class MedicineController {

	@Autowired
	private DoctorService doctorService; // To fetch doctor data
	
	@Autowired
	private MedicineService medicineService; // Medicine CRUD operations
	
	// ---------------------- CREATE MEDICINE ----------------------
	
	@PostMapping("/")
	public ResponseEntity<Medicine> SaveMedicine(@RequestBody MedicineDto medicineDto){
		
		// Map DTO to Entity
		Medicine medicine = new Medicine();
		medicine.setMedicine_name(medicineDto.getMedicine_name());
		medicine.setType(medicineDto.getType());
		
		// Link doctor with medicine
		Doctor doctor = doctorService.getDoctorById(medicineDto.getDoctorid());
		medicine.setDoctorid(doctor);
		
		// Save into database
		Medicine savedMedicine = medicineService.saveMedicine(medicine);
		
		return new ResponseEntity<>(savedMedicine, HttpStatus.CREATED);
	}
	
	
	// ---------------------- GET ALL MEDICINES ----------------------
	
	@GetMapping("/")
	public ResponseEntity<List<Medicine>> GetAllMedicine(){
		
		List<Medicine> medicineList = medicineService.GetAllMedicine();
		
		// If no records found return empty response
		if(medicineList == null || medicineList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(medicineList, HttpStatus.OK);
	}
	
	
	// ---------------------- GET MEDICINE BY ID ----------------------
	
	@GetMapping("/{id}")
	public ResponseEntity<Medicine> GetMedicineById(@PathVariable("id") int id){
		
		Medicine medicine = medicineService.GetMedicineById(id);
		
		// Return 404 if medicine not found
		if(medicine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(medicine, HttpStatus.OK);
	}
	
	
	// ---------------------- UPDATE MEDICINE ----------------------
	
	@PutMapping("/{id}")
	public ResponseEntity<Medicine> UpdateMedicineById(@PathVariable("id") int id, @RequestBody MedicineDto medicineDto){
		
		Medicine medicine = medicineService.GetMedicineById(id);
		
		// Check record exists before update
		if(medicine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Update fields
		medicine.setMedicine_name(medicineDto.getMedicine_name());
		medicine.setType(medicineDto.getType());
		
		// Update doctor reference
		Doctor doctor = doctorService.getDoctorById(medicineDto.getDoctorid());
		medicine.setDoctorid(doctor);
		
		// Save updated data
		Medicine updatedMedicine = medicineService.saveMedicine(medicine);
		
		return new ResponseEntity<>(updatedMedicine, HttpStatus.OK);
	}
	
	
	// ---------------------- DELETE MEDICINE ----------------------
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteMedicine(@PathVariable("id") int id){
		
		Medicine medicine = medicineService.GetMedicineById(id);
		
		// Check if record exists
		if(medicine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Delete record
		medicineService.DeleteMedicine(id);
		
		// Return success with no content
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
