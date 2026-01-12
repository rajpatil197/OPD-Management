package com.opd_management.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.opd_management.dtos.DoctorDto;
import com.opd_management.dtos.LoginDto;
import com.opd_management.entities.Doctor;
import com.opd_management.security.jwt.JwtUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctors") // Base endpoint for doctor-related APIs
@CrossOrigin(origins = "http://localhost:4200") 
public class DoctorController {
	
	// Inject service layer to perform doctor-related operations
	@Autowired
	private DoctorService doctorService;

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// ---------------------- CREATE DOCTOR ----------------------
	
	@PostMapping("/")
	public ResponseEntity<Doctor> SaveDoctor(@Valid@RequestBody DoctorDto doctorDto){
		
		// Mapping data from DTO to Entity
		Doctor doctor = new Doctor();
		doctor.setName("Dr."+doctorDto.getName());
		doctor.setEmail(doctorDto.getEmail());
		doctor.setAddress(doctorDto.getAddress());
		doctor.setPassword(doctorDto.getPassword());
		doctor.setSpecialization(doctorDto.getSpecialization());
		doctor.setClinic_name(doctorDto.getClinic_name());
		doctor.setMobileno(doctorDto.getMobileno());
		doctor.setToken(doctorDto.getToken());
		doctor.setStatus(doctorDto.getStatus());
		doctor.setRole("DOCTOR");
		doctor.setQualification(doctorDto.getQualification());
		doctor.setCreated_at(doctorDto.getCreated_at());
		doctor.setUpdated_at(doctorDto.getUpdated_at());
		 
		// Save doctor details in database
		Doctor savedDoctor = doctorService.saveDoctor(doctor);
		 
		return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
	}
	
	
	// ---------------------- GET ALL DOCTORS ----------------------
	
	@GetMapping("/")
	public ResponseEntity<List<Doctor>> GetAllDoctor(){
		List<Doctor> doctorList = doctorService.getAllDoctor();
		
		// If list empty, return NOT_FOUND message
		if(doctorList == null || doctorList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(doctorList, HttpStatus.OK);
	}
	
	
	// ---------------------- GET DOCTOR BY ID ----------------------
	
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> GetDoctorById(@PathVariable("id") int id){
		
		Doctor doctor = doctorService.getDoctorById(id);
		
		// Check if doctor exists
		if(doctor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(doctor, HttpStatus.OK);
	}
	
	
	// ---------------------- UPDATE DOCTOR ----------------------
	
	@PutMapping("/{id}")
	public ResponseEntity<Doctor> UpdateDoctor(@PathVariable("id") int id, @Valid @RequestBody DoctorDto doctorDto){
		
		Doctor doctor = doctorService.getDoctorById(id);
		
		// Check if doctor exists before updating
		if(doctor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Update doctor fields
		doctor.setName(doctorDto.getName());
		doctor.setEmail(doctorDto.getEmail());
		doctor.setAddress(doctorDto.getAddress());
		doctor.setPassword(doctorDto.getPassword());
		doctor.setSpecialization(doctorDto.getSpecialization());
		doctor.setClinic_name(doctorDto.getClinic_name());
		doctor.setMobileno(doctorDto.getMobileno());
		doctor.setToken(doctorDto.getToken());
		doctor.setStatus(doctorDto.getStatus());
		doctor.setQualification(doctorDto.getQualification());
		doctor.setCreated_at(doctorDto.getCreated_at());
		doctor.setUpdated_at(doctorDto.getUpdated_at());
		 
		// Save updated doctor details
		Doctor updatedDoctor = doctorService.saveDoctor(doctor);
		
		return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
	}
	
	
	// ---------------------- DELETE DOCTOR ----------------------
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteDoctor(@PathVariable("id") int id){
		
		Doctor doctor = doctorService.getDoctorById(id);
		
		// Check if record exists
		if(doctor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Delete doctor entry
		doctorService.DeleteById(id);
		
		// Return 204 as delete success response
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// ---------------------- DOCTOR LOGIN ----------------------

	@PostMapping("/login")
	public ResponseEntity<?> loginDoctor(@Valid @RequestBody LoginDto loginDto) {

		
	    Doctor doctor = doctorService.getDoctorByEmail(loginDto.getEmail());

	    if (doctor == null) {
	        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	    }

	    if (!passwordEncoder.matches(loginDto.getPassword(), doctor.getPassword())) {
	        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	    }
	    
	    String token = jwtUtil.generateToken(doctor.getEmail(), doctor.getRole());

	    doctor.setToken(token);

	    return ResponseEntity.ok(Map.of(
	            "email", doctor.getEmail(),
	            "doctorId", doctor.getId(),
	            "token", token ));
	}
}
