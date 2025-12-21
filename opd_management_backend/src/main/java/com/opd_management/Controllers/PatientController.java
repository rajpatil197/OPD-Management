package com.opd_management.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opd_management.Services.DoctorService;
import com.opd_management.Services.PatientService;
import com.opd_management.dtos.PatientDto;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Patient;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patients") // Base URL for patient API
@CrossOrigin(origins = "http://localhost:4200") 
public class PatientController {
	
	@Autowired 
	private DoctorService doctorService; // To access doctor details
	
	@Autowired
	private PatientService patientService; // To access patient database operations


	// ---------------------- CREATE PATIENT ----------------------
	
	@PostMapping("/")
	public ResponseEntity<Patient> savePatient(@Valid @RequestBody PatientDto patientDto){
		
		// Mapping DTO data to entity
		Patient patient = new Patient();
		patient.setPatient_name(patientDto.getPatient_name());
		patient.setAge(patientDto.getAge());
		patient.setAddress(patientDto.getAddress());
		patient.setAlcohol(patientDto.getAlcohol());
		patient.setBlood_group(patientDto.getBlood_group());
		patient.setGender(patientDto.getGender());
		patient.setHeight(patientDto.getHeight());
		patient.setMobileno(patientDto.getMobileno());
		patient.setSmoking(patientDto.getSmoking());
		patient.setTobacco(patientDto.getTobacco());
		patient.setCreated_at(patientDto.getCreated_at());
		
		// Assign doctor reference
		Doctor doctor = doctorService.getDoctorById(patientDto.getDoctorid());
		patient.setDoctorid(doctor);
		
		// Save patient into database
		Patient savedPatient = patientService.savePatient(patient);
		
		return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
	}
	
	
	// ---------------------- GET ALL PATIENTS ----------------------
	
	@GetMapping("/")
	public ResponseEntity<List<Patient>> getAllPatient(){
		
		List<Patient> patients = patientService.getAllPatient();
		
		if(patients == null || patients.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(patients, HttpStatus.OK);
	}
	
	
	// ---------------------- GET PATIENT BY ID ----------------------
	
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("id") int id){
		
		Patient patient = patientService.getPatientByID(id);
		
		// Return 404 if not found
		if(patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}
	
	
	// ---------------------- UPDATE PATIENT ----------------------
	
	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable("id") int id,@Valid  @RequestBody PatientDto patientDto){
		
		Patient patient = patientService.getPatientByID(id);
		
		// Check if patient exists
		if(patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Update fields
		patient.setPatient_name(patientDto.getPatient_name());
		patient.setAge(patientDto.getAge());
		patient.setAddress(patientDto.getAddress());
		patient.setAlcohol(patientDto.getAlcohol());
		patient.setBlood_group(patientDto.getBlood_group());
		patient.setGender(patientDto.getGender());
		patient.setHeight(patientDto.getHeight());
		patient.setMobileno(patientDto.getMobileno());
		patient.setSmoking(patientDto.getSmoking());
		patient.setTobacco(patientDto.getTobacco());
		patient.setCreated_at(patientDto.getCreated_at());
		
		// Update doctor mapping
		Doctor doctor = doctorService.getDoctorById(patientDto.getDoctorid());
		patient.setDoctorid(doctor);
		
		// Save updated record
		Patient updatedPatient = patientService.savePatient(patient);
		
		return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
	}
	
	
	// ---------------------- DELETE PATIENT ----------------------
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePatientById(@PathVariable("id") int id){
		
		Patient patient = patientService.getPatientByID(id);
		
		// Return NOT_FOUND if record does not exist
		if(patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Perform deletion
		patientService.DeletePatientByID(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Correct delete response
	}
	// ---------------------- GET PATIENT BY DOCTOR ID ----------------------
	@GetMapping("/doctor/{doctorId}")
	public ResponseEntity<List<Patient>> getPatientsByDoctor(@PathVariable int doctorId) {

	    List<Patient> patients = patientService.getPatientsByDoctor(doctorId);

	    if (patients.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    return new ResponseEntity<>(patients, HttpStatus.OK);
	}

	
	
}
