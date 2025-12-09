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

import com.opd_management.Services.VisitReportService;
import com.opd_management.Services.VisitService;
import com.opd_management.dtos.VisitReportDto;
import com.opd_management.entities.Visit;
import com.opd_management.entities.VisitReport;

@RestController
@RequestMapping("/visitreports") // Base API path for VisitReport operations
public class VisitReportController {

	@Autowired
	private VisitReportService visitReportService; // Service layer for VisitReport CRUD
	
	@Autowired
	private VisitService visitService; // To link visit records to reports
	
	
	// ---------------------- CREATE VISIT REPORT ----------------------
	
	@PostMapping("/")
	public ResponseEntity<VisitReport> saveVisitReport(@RequestBody VisitReportDto visitReportDto){
		
		// Mapping DTO -> Entity
		VisitReport visitReport = new VisitReport();
		visitReport.setFile_name(visitReportDto.getFile_name());
		visitReport.setFile_type(visitReportDto.getFile_type());
		visitReport.setFile_url(visitReportDto.getFile_url());
		visitReport.setCreated_at(visitReportDto.getCreated_at());
		
		// Linking visit entity
		Visit visit = visitService.GetVisitById(visitReportDto.getVisitid());
		visitReport.setVisitid(visit);
		
		// Save record in database
		VisitReport savedReport = visitReportService.saveVisitReport(visitReport);
		
		return new ResponseEntity<>(savedReport, HttpStatus.CREATED);
	}
	
	
	// ---------------------- GET ALL VISIT REPORTS ----------------------
	
	@GetMapping("/")
	public ResponseEntity<List<VisitReport>> getAllVisitReports(){
		
		List<VisitReport> reports = visitReportService.GetAllVisitReport();
		
		if (reports == null || reports.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(reports, HttpStatus.OK);
	}
	
	
	// ---------------------- GET REPORT BY ID ----------------------
	
	@GetMapping("/{id}")
	public ResponseEntity<VisitReport> getVisitReportById(@PathVariable("id") int id){
		
		VisitReport report = visitReportService.GetVisitReportById(id);
		
		if (report == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(report, HttpStatus.OK);
	}
	
	
	// ---------------------- UPDATE REPORT ----------------------
	
	@PutMapping("/{id}")
	public ResponseEntity<VisitReport> updateVisitReport(@PathVariable("id") int id, @RequestBody VisitReportDto visitReportDto){
		
		VisitReport report = visitReportService.GetVisitReportById(id);
		
		if (report == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Update existing fields
		report.setFile_name(visitReportDto.getFile_name());
		report.setFile_type(visitReportDto.getFile_type());
		report.setFile_url(visitReportDto.getFile_url());
		report.setCreated_at(visitReportDto.getCreated_at());
		
		// Update linked visit
		Visit visit = visitService.GetVisitById(visitReportDto.getVisitid());
		report.setVisitid(visit);
		
		VisitReport updatedReport = visitReportService.saveVisitReport(report);
		
		return new ResponseEntity<>(updatedReport, HttpStatus.OK);
	}
	
	
	// ---------------------- DELETE REPORT ----------------------
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVisitReport(@PathVariable("id") int id){
		
		VisitReport report = visitReportService.GetVisitReportById(id);
		
		if (report == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		visitReportService.DeleteVisitReport(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Correct REST delete response
	}
}
