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
import com.opd_management.Services.VisitService;
import com.opd_management.dtos.VisitDto;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Patient;
import com.opd_management.entities.Visit;

@RestController
@RequestMapping("/visits") // Base route for Visit module
public class VisitController {

	@Autowired
	private VisitService visitService; // Service layer to access visit operations
	
	@Autowired
	private DoctorService doctorService; // Inject doctor service for linking doctor to visit
	
	@Autowired
	private PatientService patientService; // Inject patient service for linking patient to visit
	
	
	// ---------------------- CREATE VISIT ----------------------
	
	@PostMapping("/")
	public ResponseEntity<Visit> saveVisit(@RequestBody VisitDto visitDto){
		
		// Convert DTO to Entity
		Visit visit = new Visit();
		visit.setVisit_date(visitDto.getVisit_date());
		visit.setComplaints(visitDto.getComplaints());
		visit.setDiagnosis(visitDto.getDiagnosis());
		visit.setAdvice(visitDto.getAdvice());
		visit.setBp(visitDto.getBp());
		visit.setPulse(visitDto.getPulse());
		visit.setSaturation(visitDto.getSaturation());
		visit.setTemperature(visitDto.getTemperature());
		visit.setRespiration_rate(visitDto.getRespiration_rate());
		visit.setSugar(visitDto.getSugar());
		visit.setFasting_sugar(visitDto.getFasting_sugar());
		visit.setPp_sugar(visitDto.getPp_sugar());
		visit.setRandom_sugar(visitDto.getRandom_sugar());
		visit.setUrea_creatine(visitDto.getUrea_creatine());
		visit.setPast_history(visitDto.getPast_history());
		visit.setCurrent_medication(visitDto.getCurrent_medication());
		visit.setAdditional_notes(visitDto.getAdditional_notes());
		visit.setWeight(visitDto.getWeight());
		visit.setEdema(visitDto.getEdema());
		visit.setPallor(visitDto.getPallor());
		visit.setJaundice(visitDto.getJaundice());
		visit.setCvs(visitDto.getCvs());
		visit.setRs(visitDto.getRs());
		visit.setPa(visitDto.getPa());
		visit.setCns(visitDto.getCns());
		visit.setHb(visitDto.getHb());
		visit.setEcg(visitDto.getEcg());
		visit.setFollowup_date(visitDto.getFollowup_date());
		visit.setCreated_at(visitDto.getCreated_at());
		visit.setUpdated_at(visitDto.getUpdated_at());
		
		// Assign related doctor and patient
		Doctor doctor = doctorService.getDoctorById(visitDto.getDoctorid());
		visit.setDoctorid(doctor);
		
		Patient patient = patientService.getPatientByID(visitDto.getPatientid());
		visit.setPatientid(patient);
		
		// Store in DB
		Visit savedVisit = visitService.saveVisit(visit);
		
		return new ResponseEntity<>(savedVisit, HttpStatus.CREATED);
	}
	
	
	// ---------------------- GET ALL VISITS ----------------------
	
	@GetMapping("/")
	public ResponseEntity<List<Visit>> getAllVisits(){
		
		List<Visit> visits = visitService.GetAllVisit();
		
		if(visits == null || visits.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(visits, HttpStatus.OK);
	}
	
	
	// ---------------------- GET VISIT BY ID ----------------------
	
	@GetMapping("/{id}")
	public ResponseEntity<Visit> getVisitById(@PathVariable("id") int id){
		
		Visit visit = visitService.GetVisitById(id);
		
		if(visit == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(visit, HttpStatus.OK);
	}
	
	
	// ---------------------- UPDATE VISIT ----------------------
	
	@PutMapping("/{id}")
	public ResponseEntity<Visit> updateVisit(@PathVariable("id") int id, @RequestBody VisitDto visitDto){
		
		Visit visit = visitService.GetVisitById(id);
		
		if(visit == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Updating same fields as in creation
		visit.setVisit_date(visitDto.getVisit_date());
		visit.setComplaints(visitDto.getComplaints());
		visit.setDiagnosis(visitDto.getDiagnosis());
		visit.setAdvice(visitDto.getAdvice());
		visit.setBp(visitDto.getBp());
		visit.setPulse(visitDto.getPulse());
		visit.setSaturation(visitDto.getSaturation());
		visit.setTemperature(visitDto.getTemperature());
		visit.setRespiration_rate(visitDto.getRespiration_rate());
		visit.setSugar(visitDto.getSugar());
		visit.setFasting_sugar(visitDto.getFasting_sugar());
		visit.setPp_sugar(visitDto.getPp_sugar());
		visit.setRandom_sugar(visitDto.getRandom_sugar());
		visit.setUrea_creatine(visitDto.getUrea_creatine());
		visit.setPast_history(visitDto.getPast_history());
		visit.setCurrent_medication(visitDto.getCurrent_medication());
		visit.setAdditional_notes(visitDto.getAdditional_notes());
		visit.setWeight(visitDto.getWeight());
		visit.setEdema(visitDto.getEdema());
		visit.setPallor(visitDto.getPallor());
		visit.setJaundice(visitDto.getJaundice());
		visit.setCvs(visitDto.getCvs());
		visit.setRs(visitDto.getRs());
		visit.setPa(visitDto.getPa());
		visit.setCns(visitDto.getCns());
		visit.setHb(visitDto.getHb());
		visit.setEcg(visitDto.getEcg());
		visit.setFollowup_date(visitDto.getFollowup_date());
		visit.setCreated_at(visitDto.getCreated_at());
		visit.setUpdated_at(visitDto.getUpdated_at());
		
		// Update linked entities
		Doctor doctor = doctorService.getDoctorById(visitDto.getDoctorid());
		visit.setDoctorid(doctor);
		
		Patient patient = patientService.getPatientByID(visitDto.getPatientid());
		visit.setPatientid(patient);
		
		Visit updatedVisit = visitService.saveVisit(visit);
		
		return new ResponseEntity<>(updatedVisit, HttpStatus.OK);
	}
	
	
	// ---------------------- DELETE VISIT ----------------------
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVisit(@PathVariable("id") int id){
		
		Visit visit = visitService.GetVisitById(id);
		
		if(visit == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		visitService.DeleteVisitById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Correct delete response
	}
}
