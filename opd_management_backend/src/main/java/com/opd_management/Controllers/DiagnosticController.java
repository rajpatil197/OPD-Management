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

import com.opd_management.Services.DiagnosticService;
import com.opd_management.Services.DoctorService;
import com.opd_management.Services.VisitService;
import com.opd_management.dtos.DiagnosticDto;
import com.opd_management.entities.Diagnostic;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Visit;

@RestController
@RequestMapping("/diagnostics") // Base API path for diagnostic-related operations
public class DiagnosticController {

	@Autowired
	private DoctorService doctorService; // Used to fetch the related doctor entity
	
	@Autowired
	private VisitService visitService; // Used to fetch related visit record
	
	@Autowired
	private DiagnosticService diagnosticsService; // Service layer for diagnostic operations
	
	// ---------------------- CREATE DIAGNOSTIC ----------------------
	
	@PostMapping("/")
	public ResponseEntity<Diagnostic> SaveDiagnostic(@RequestBody DiagnosticDto diagnosticDto){
		
		// Create Diagnostic entity and set values from DTO
		Diagnostic diagnostic = new Diagnostic();
		diagnostic.setName(diagnosticDto.getName());
		diagnostic.setCreated_at(diagnosticDto.getCreated_at());

		// Fetch doctor using doctor id and set it to diagnostic
		Doctor doctor = doctorService.getDoctorById(diagnosticDto.getDoctorid());
		diagnostic.setDoctorid(doctor);
		
		// Fetch visit record and link to diagnostic
		Visit visit = visitService.GetVisitById(diagnosticDto.getVisitid());
		diagnostic.setVisitid(visit);
		
		// Save diagnostic record to database
		Diagnostic savedDiagnostic = diagnosticsService.saveDiagnostic(diagnostic);
		
		return new ResponseEntity<>(savedDiagnostic, HttpStatus.CREATED);
	}
	
	// ---------------------- GET ALL DIAGNOSTICS ----------------------
	
	@GetMapping("/")
	public ResponseEntity<List<Diagnostic>> GetAllDiagnostic(){
		
		List<Diagnostic> diagnosticList = diagnosticsService.GetAllDiagnostic();
		
		// If no records found return 404
		if(diagnosticList == null || diagnosticList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(diagnosticList, HttpStatus.OK);
	}
	
	// ---------------------- GET DIAGNOSTIC BY ID ----------------------
	
	@GetMapping("/{id}")
	public ResponseEntity<Diagnostic> GetDiagnosticById(@PathVariable("id") int id){
		
		Diagnostic diagnostic = diagnosticsService.GetDiagnosticByID(id);

		// If not found return NOT_FOUND response
		if(diagnostic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(diagnostic, HttpStatus.OK);
	}
	
	// ---------------------- UPDATE DIAGNOSTIC ----------------------
	
	@PutMapping("/{id}")
	public ResponseEntity<Diagnostic> UpdateDiagnostic(@PathVariable("id") int id, @RequestBody DiagnosticDto diagnosticDto){
		
		Diagnostic diagnostic = diagnosticsService.GetDiagnosticByID(id);

		// Check if diagnostic exists
		if(diagnostic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
		
		// Update fields
		diagnostic.setName(diagnosticDto.getName());
		diagnostic.setCreated_at(diagnosticDto.getCreated_at());

		// Update related doctor
		Doctor doctor = doctorService.getDoctorById(diagnosticDto.getDoctorid());
		diagnostic.setDoctorid(doctor);
		
		// Update related visit
		Visit visit = visitService.GetVisitById(diagnosticDto.getVisitid());
		diagnostic.setVisitid(visit);
		
		// Save updated record
		Diagnostic updatedDiagnostic = diagnosticsService.saveDiagnostic(diagnostic);
		
		return new ResponseEntity<>(updatedDiagnostic, HttpStatus.OK);
	}
	
	// ---------------------- DELETE DIAGNOSTIC ----------------------
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteDiagnostic(@PathVariable("id") int id){
		
		Diagnostic diagnostic = diagnosticsService.GetDiagnosticByID(id);

		// If no record found return error
		if(diagnostic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
		
		// Delete entry
		diagnosticsService.DeleteDiagnostic(id);
		
		// Return success with no content
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
