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
import com.opd_management.Services.ReferralCenterService;
import com.opd_management.dtos.ReferralCenterDto;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.ReferralCenter;

@RestController
@RequestMapping("/referralCenters") // Base path for all referral center APIs
public class ReferralCenterController {

	@Autowired
	private ReferralCenterService referralCenterService; // For CRUD operations on referral center
	
	@Autowired
	private DoctorService doctorService; // To fetch doctor details for relationships
	
	
	// ---------------------- CREATE REFERRAL CENTER ----------------------
	
	@PostMapping("/")
	public ResponseEntity<ReferralCenter> saveReferralCenter(@RequestBody ReferralCenterDto referralCenterDto){
		
		// Map DTO fields to entity
		ReferralCenter referralCenter = new ReferralCenter();
		referralCenter.setName(referralCenterDto.getName());
		referralCenter.setContact_info(referralCenterDto.getContact_info());
		referralCenter.setAddress(referralCenterDto.getAddress());
		referralCenter.setType(referralCenterDto.getType());
		referralCenter.setCreated_at(referralCenterDto.getCreated_at());
		
		// Assign doctor relationship
		Doctor doctor = doctorService.getDoctorById(referralCenterDto.getDoctorid());
		referralCenter.setDoctorid(doctor);
		
		// Save to DB
		ReferralCenter savedReferralCenter = referralCenterService.saveReferralCenter(referralCenter);
		
		return new ResponseEntity<>(savedReferralCenter, HttpStatus.CREATED);
	}
	
	
	// ---------------------- GET ALL REFERRAL CENTERS ----------------------
	
	@GetMapping("/")
	public ResponseEntity<List<ReferralCenter>> getAllReferralCenter(){
		
		List<ReferralCenter> referralCenterList = referralCenterService.GetAllReferralCenter();
		
		// If empty list return NOT_FOUND
		if(referralCenterList == null || referralCenterList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(referralCenterList, HttpStatus.OK);
	}
	
	
	// ---------------------- GET REFERRAL CENTER BY ID ----------------------
	
	@GetMapping("/{id}")
	public ResponseEntity<ReferralCenter> getReferralCenterById(@PathVariable("id") int id){
		
		ReferralCenter referralCenter = referralCenterService.GetReferralCenterById(id);
		
		// If record does not exist return NOT_FOUND
		if(referralCenter == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(referralCenter, HttpStatus.OK);
	}
	
	
	// ---------------------- UPDATE REFERRAL CENTER ----------------------
	
	@PutMapping("/{id}")
	public ResponseEntity<ReferralCenter> updateReferralCenter(@PathVariable("id") int id, @RequestBody ReferralCenterDto referralCenterDto){
		
		ReferralCenter referralCenter = referralCenterService.GetReferralCenterById(id);
		
		// Check record exists
		if(referralCenter == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Update fields
		referralCenter.setName(referralCenterDto.getName());
		referralCenter.setContact_info(referralCenterDto.getContact_info());
		referralCenter.setAddress(referralCenterDto.getAddress());
		referralCenter.setType(referralCenterDto.getType());
		referralCenter.setCreated_at(referralCenterDto.getCreated_at());
		
		// Update doctor relationship
		Doctor doctor = doctorService.getDoctorById(referralCenterDto.getDoctorid());
		referralCenter.setDoctorid(doctor);
		
		// Save updated record
		ReferralCenter updatedReferralCenter = referralCenterService.saveReferralCenter(referralCenter);
		
		return new ResponseEntity<>(updatedReferralCenter, HttpStatus.OK);
	}
	
	
	// ---------------------- DELETE REFERRAL CENTER ----------------------
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReferralCenter(@PathVariable("id") int id){
		
		ReferralCenter referralCenter = referralCenterService.GetReferralCenterById(id);
		
		// If not found return 404
		if(referralCenter == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Perform delete
		referralCenterService.DeleteReferralCenter(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Correct response for delete
	}
	
}
