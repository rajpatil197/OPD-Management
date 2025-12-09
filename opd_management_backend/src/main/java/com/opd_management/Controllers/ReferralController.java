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
import com.opd_management.Services.PatientService;
import com.opd_management.Services.ReferralCenterService;
import com.opd_management.Services.ReferralService;
import com.opd_management.Services.VisitService;
import com.opd_management.dtos.ReferralDto;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Patient;
import com.opd_management.entities.Referral;
import com.opd_management.entities.ReferralCenter;
import com.opd_management.entities.Visit;

@RestController
@RequestMapping("/referrals") // Base URL for referral-related requests
public class ReferralController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private ReferralCenterService referralCenterService;
	
	@Autowired
	private ReferralService referralService;
	
	
	// ---------------------- CREATE REFERRAL ----------------------
	
	@PostMapping("/")
	public ResponseEntity<Referral> saveReferral(@RequestBody ReferralDto referralDto){
		
		// Mapping DTO to Entity
		Referral referral = new Referral();
		referral.setNote_type(referralDto.getNote_type());
		referral.setReason(referralDto.getReason());
		referral.setDeatils(referralDto.getDeatils());
		referral.setCreated_at(referralDto.getCreated_at());
		
		// Assign relationships
		Doctor doctor = doctorService.getDoctorById(referralDto.getDoctorid());
		referral.setDoctorid(doctor);
		
		Patient patient = patientService.getPatientByID(referralDto.getPatientid());
		referral.setPatientid(patient);
		
		ReferralCenter referralCenter = referralCenterService.GetReferralCenterById(referralDto.getReferralCenterid());
		referral.setReferralCenterid(referralCenter);
		
		Visit visit = visitService.GetVisitById(referralDto.getVisitid());
		referral.setVisitid(visit);
		
		// Save data to the database
		Referral savedReferral = referralService.saveReferral(referral);
		
		return new ResponseEntity<>(savedReferral, HttpStatus.CREATED);
	}
	
	
	// ---------------------- GET ALL REFERRALS ----------------------
	
	@GetMapping("/")
	public ResponseEntity<List<Referral>> getAllReferral(){
		
		List<Referral> referrals = referralService.GetAllReferral();
		
		if(referrals == null || referrals.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(referrals, HttpStatus.OK);
	}
	
	
	// ---------------------- GET REFERRAL BY ID ----------------------
	
	@GetMapping("/{id}")
	public ResponseEntity<Referral> getReferralById(@PathVariable("id") int id){
		
		Referral referral = referralService.GetReferralById(id);
		
		if(referral == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(referral, HttpStatus.OK);
	}
	
	
	// ---------------------- UPDATE REFERRAL ----------------------
	
	@PutMapping("/{id}")
	public ResponseEntity<Referral> updateReferral(@PathVariable("id") int id, @RequestBody ReferralDto referralDto){
		
		Referral referral = referralService.GetReferralById(id);
		
		if(referral == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Update fields
		referral.setNote_type(referralDto.getNote_type());
		referral.setReason(referralDto.getReason());
		referral.setDeatils(referralDto.getDeatils());
		referral.setCreated_at(referralDto.getCreated_at());
		
		// Update relationships
		Doctor doctor = doctorService.getDoctorById(referralDto.getDoctorid());
		referral.setDoctorid(doctor);
		
		Patient patient = patientService.getPatientByID(referralDto.getPatientid());
		referral.setPatientid(patient);
		
		ReferralCenter referralCenter = referralCenterService.GetReferralCenterById(referralDto.getReferralCenterid());
		referral.setReferralCenterid(referralCenter);
		
		Visit visit = visitService.GetVisitById(referralDto.getVisitid());
		referral.setVisitid(visit);
		
		// Save updated record
		Referral updatedReferral = referralService.saveReferral(referral);
		
		return new ResponseEntity<>(updatedReferral, HttpStatus.OK);
	}
	
	
	// ---------------------- DELETE REFERRAL ----------------------
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReferral(@PathVariable("id") int id){
		
		Referral referral = referralService.GetReferralById(id);
		
		if(referral == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		referralService.DeleteReferral(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Correct response for delete requests
	}
	
}
