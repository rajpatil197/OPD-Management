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
import com.opd_management.Services.TestMasterService;
import com.opd_management.dtos.TestMasterDto;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.TestMaster;

@RestController
@RequestMapping("/testmasters") // Base API endpoint for Test Master records
public class TestMasterController {

	@Autowired
	private TestMasterService testMasterService; // Service to handle test master-related database operations
	
	@Autowired
	private DoctorService doctorService; // To fetch doctor related to the test master
	
	
	// ---------------------- CREATE TEST MASTER ----------------------
	
	@PostMapping("/")
	public ResponseEntity<TestMaster> saveTestMaster(@RequestBody TestMasterDto testMasterDto){
		
		// Map DTO to Entity
		TestMaster testMaster = new TestMaster();
		testMaster.setTest_name(testMasterDto.getTest_name());
		testMaster.setNormal_range(testMasterDto.getNormal_range());
		testMaster.setUnit(testMasterDto.getUnit());
		
		// Assign doctor record using doctor id
		Doctor doctor = doctorService.getDoctorById(testMasterDto.getDoctorid());
		testMaster.setDoctorid(doctor);
		
		// Save in DB
		TestMaster savedTestMaster = testMasterService.saveTestMaster(testMaster);
		
		return new ResponseEntity<>(savedTestMaster, HttpStatus.CREATED);
	}
	
	
	// ---------------------- GET ALL TEST MASTERS ----------------------
	
	@GetMapping("/")
	public ResponseEntity<List<TestMaster>> getAllTestMaster(){
		
		List<TestMaster> testMasterList = testMasterService.GetAllTestMaster();
		
		// Handle empty response
		if(testMasterList == null || testMasterList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(testMasterList, HttpStatus.OK);
	}
	
	
	// ---------------------- GET TEST MASTER BY ID ----------------------
	
	@GetMapping("/{id}")
	public ResponseEntity<TestMaster> getTestMasterById(@PathVariable("id") int id){
		
		TestMaster testMaster = testMasterService.GetTestMasterById(id);
		
		// If not found return 404
		if(testMaster == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(testMaster, HttpStatus.OK);
	}
	
	
	// ---------------------- UPDATE TEST MASTER ----------------------
	
	@PutMapping("/{id}")
	public ResponseEntity<TestMaster> updateTestMaster(@PathVariable("id") int id, @RequestBody TestMasterDto testMasterDto){
		
		TestMaster testMaster = testMasterService.GetTestMasterById(id);
		
		// Check if record exists
		if(testMaster == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Update data
		testMaster.setTest_name(testMasterDto.getTest_name());
		testMaster.setNormal_range(testMasterDto.getNormal_range());
		testMaster.setUnit(testMasterDto.getUnit());
		
		// Update doctor reference
		Doctor doctor = doctorService.getDoctorById(testMasterDto.getDoctorid());
		testMaster.setDoctorid(doctor);
		
		TestMaster updatedTestMaster = testMasterService.saveTestMaster(testMaster);
		
		return new ResponseEntity<>(updatedTestMaster, HttpStatus.OK);
	}
	
	
	// ---------------------- DELETE TEST MASTER ----------------------
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTestMaster(@PathVariable("id") int id){
		
		TestMaster testMaster = testMasterService.GetTestMasterById(id);
		
		// If not found return NOT_FOUND
		if(testMaster == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Delete record
		testMasterService.DeleteTestMaster(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Correct delete response
	}
}
