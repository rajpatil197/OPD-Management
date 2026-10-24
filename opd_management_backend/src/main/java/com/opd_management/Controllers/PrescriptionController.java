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

import com.opd_management.Services.MedicineService;
import com.opd_management.Services.PrescriptionService;
import com.opd_management.Services.VisitService;
import com.opd_management.dtos.PrescriptionDto;
import com.opd_management.entities.Medicine;
import com.opd_management.entities.Prescription;
import com.opd_management.entities.Visit;

@RestController
@RequestMapping("/prescriptions")   // Base URL for prescription APIs
@CrossOrigin(origins = "http://localhost:4200") 
public class PrescriptionController {

    // Injecting required services
    @Autowired
    private PrescriptionService prescriptionService;
    
    @Autowired
    private VisitService visitService;
    
    @Autowired
    private MedicineService medicineService;
    
    // ---------------------- CREATE PRESCRIPTION ----------------------
    @PostMapping("/")
    public ResponseEntity<Prescription> savePrescription(@RequestBody PrescriptionDto prescriptionDto){

        // Mapping DTO to Entity
        Prescription prescription = new Prescription();
        prescription.setDosage(prescriptionDto.getDosage());
        prescription.setDuration(prescriptionDto.getDuration());
        prescription.setInstructions(prescriptionDto.getInstructions());
        prescription.setQuantity(prescriptionDto.getQuantity());
        prescription.setCreated_at(prescriptionDto.getCreated_at());
        prescription.setMorning_dose(prescriptionDto.getMorning_dose());
        prescription.setAfternoon_dose(prescriptionDto.getAfternoon_dose());
        prescription.setEvening_dose(prescriptionDto.getEvening_dose());
        prescription.setDuration_days(prescriptionDto.getDuration_days());
        prescription.setTotal_quantity(prescriptionDto.getTotal_quantity());
        prescription.setQuantity_note(prescriptionDto.getQuantity_note());
        prescription.setDose_qty(prescriptionDto.getDose_qty());
        prescription.setDose_unit(prescriptionDto.getDose_unit());
        
        // Fetch and set Visit entity
        Visit visit = visitService.GetVisitById(prescriptionDto.getVisitid());
        prescription.setVisitid(visit);
        
        // Fetch and set Medicine entity
        Medicine medicine = medicineService.GetMedicineById(prescriptionDto.getMedicineid());
        prescription.setMedicineid(medicine);
        
        // Save prescription
        Prescription savedPrescription = prescriptionService.savePrescription(prescription);
        
        // Return created response
        return new ResponseEntity<>(savedPrescription, HttpStatus.CREATED);
    }
    
    // ---------------------- GET ALL PRESCRIPTIONS ----------------------
    @GetMapping("/")
    public ResponseEntity<List<Prescription>> GetAllPrescription(){

        List<Prescription> list = prescriptionService.GetAllPrescription();

        // If no data found, return 404 (you can also return 200 with empty list)
        if(list == null || list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    // ---------------------- GET PRESCRIPTION BY ID ----------------------
    @GetMapping("/{id}")
    public ResponseEntity<Prescription> GetPrescriptionById(@PathVariable("id") int id){
         
        Prescription prescription = prescriptionService.GetPrescriptionById(id);
        
        // If prescription not found, return 404
        if(prescription == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(prescription, HttpStatus.OK);
    }
    
    // ---------------------- UPDATE PRESCRIPTION ----------------------
    @PutMapping("/{id}")
    public ResponseEntity<Prescription> UpdatePrescription(@PathVariable("id") int id,
                                                           @RequestBody PrescriptionDto prescriptionDto){
        
        Prescription prescription = prescriptionService.GetPrescriptionById(id);
        
        // If prescription not found, return 404
        if(prescription == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        // Update fields
        prescription.setDosage(prescriptionDto.getDosage());
        prescription.setDuration(prescriptionDto.getDuration());
        prescription.setInstructions(prescriptionDto.getInstructions());
        prescription.setQuantity(prescriptionDto.getQuantity());
        prescription.setCreated_at(prescriptionDto.getCreated_at());
        prescription.setMorning_dose(prescriptionDto.getMorning_dose());
        prescription.setAfternoon_dose(prescriptionDto.getAfternoon_dose());
        prescription.setEvening_dose(prescriptionDto.getEvening_dose());
        prescription.setDuration_days(prescriptionDto.getDuration_days());
        prescription.setTotal_quantity(prescriptionDto.getTotal_quantity());
        prescription.setQuantity_note(prescriptionDto.getQuantity_note());
        prescription.setDose_qty(prescriptionDto.getDose_qty());
        prescription.setDose_unit(prescriptionDto.getDose_unit());
        
        // Update Visit reference
        Visit visit = visitService.GetVisitById(prescriptionDto.getVisitid());
        prescription.setVisitid(visit);
        
        // Update Medicine reference
        Medicine medicine = medicineService.GetMedicineById(prescriptionDto.getMedicineid());
        prescription.setMedicineid(medicine);
        
        // Save updated prescription
        Prescription updatedPrescription = prescriptionService.savePrescription(prescription);
        
        return new ResponseEntity<>(updatedPrescription, HttpStatus.OK);             
    }
    
    // ---------------------- DELETE PRESCRIPTION ----------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeletePrescription(@PathVariable("id") int id){
        
        Prescription prescription = prescriptionService.GetPrescriptionById(id);

        // If not found, return 404
        if(prescription == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Delete prescription
        prescriptionService.DeletePrescription(id);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}