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

import com.opd_management.Services.PathologyTestService;
import com.opd_management.Services.TestMasterService;
import com.opd_management.Services.VisitService;
import com.opd_management.dtos.PathologyTestDto;
import com.opd_management.entities.PathologyTest;
import com.opd_management.entities.TestMaster;
import com.opd_management.entities.Visit;

@RestController
@RequestMapping("/pathologytest") // Base path for all PathologyTest APIs
public class PathologyTestController {

	@Autowired
	private PathologyTestService pathologyTestService;
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private TestMasterService testMasterService;
	
	// ---------------------- CREATE PATHOLOGY TEST ----------------------
	
	@PostMapping("/")
	public ResponseEntity<PathologyTest> savePathologyTest(@RequestBody PathologyTestDto pathologyTestDto){
		
		// Convert DTO to Entity
		PathologyTest pathologyTest = new PathologyTest();
		pathologyTest.setRemarks(pathologyTestDto.getRemarks());
		pathologyTest.setReport_file(pathologyTestDto.getReport_file());
		pathologyTest.setResult(pathologyTestDto.getResult());
		pathologyTest.setCreated_at(pathologyTestDto.getCreated_at());
		
		// Assign foreign keys
		Visit visit = visitService.GetVisitById(pathologyTestDto.getVisitid());
		pathologyTest.setVisitid(visit);
		
		TestMaster testMaster = testMasterService.GetTestMasterById(pathologyTestDto.getTestmasterid());
		pathologyTest.setTestmasterid(testMaster);
		
		// Save to database
		PathologyTest saved = pathologyTestService.savePathologyTest(pathologyTest);
		
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
	
	
	// ---------------------- GET ALL PATHOLOGY TESTS ----------------------
	
	@GetMapping("/")
	public ResponseEntity<List<PathologyTest>> GetAllPathologyTest(){
		
		List<PathologyTest> list = pathologyTestService.GetAllPathologyTest();
		
		if(list == null || list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	// ---------------------- GET PATHOLOGY TEST BY ID ----------------------
	
	@GetMapping("/{id}")
	public ResponseEntity<PathologyTest> GetPathologyTestById(@PathVariable("id") int id){
		
		PathologyTest pathologyTest = pathologyTestService.GetPathologyTestById(id);
		
		if(pathologyTest == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(pathologyTest, HttpStatus.OK);
	}
	
	
	// ---------------------- UPDATE PATHOLOGY TEST ----------------------
	
	@PutMapping("/{id}")
	public ResponseEntity<PathologyTest> UpdatePathologyTest(@PathVariable("id") int id, @RequestBody PathologyTestDto pathologyTestDto){
		
		PathologyTest pathologyTest = pathologyTestService.GetPathologyTestById(id);
		
		if(pathologyTest == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Update fields
		pathologyTest.setRemarks(pathologyTestDto.getRemarks());
		pathologyTest.setReport_file(pathologyTestDto.getReport_file());
		pathologyTest.setResult(pathologyTestDto.getResult());
		pathologyTest.setCreated_at(pathologyTestDto.getCreated_at());
		
		// Update relationships
		Visit visit = visitService.GetVisitById(pathologyTestDto.getVisitid());
		pathologyTest.setVisitid(visit);
		
		TestMaster testMaster = testMasterService.GetTestMasterById(pathologyTestDto.getTestmasterid());
		pathologyTest.setTestmasterid(testMaster);
		
		PathologyTest updated = pathologyTestService.savePathologyTest(pathologyTest);
		
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}
	
	
	// ---------------------- DELETE PATHOLOGY TEST ----------------------
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeletePathologyTest(@PathVariable("id") int id){
		
		PathologyTest pathologyTest = pathologyTestService.GetPathologyTestById(id);
		
		if(pathologyTest == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		pathologyTestService.DeletePathologyTest(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Best practice for delete response
	}
	
}
