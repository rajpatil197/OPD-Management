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
import com.opd_management.Services.ReceptionService;
import com.opd_management.dtos.ReceptionDto;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Reception;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/receptions") // Base endpoint for receptionist management
@CrossOrigin(origins = "http://localhost:4200")

public class ReceptionController {

    @Autowired
    private ReceptionService receptionService;

    @Autowired
    private DoctorService doctorService;


    // ---------------------- CREATE RECEPTION STAFF ----------------------
    
    @PostMapping("/")
    public ResponseEntity<Reception> saveReception(@Valid @RequestBody ReceptionDto receptionDto) {

        // Map DTO → Entity
        Reception reception = new Reception();
        reception.setName(receptionDto.getName());
        reception.setEmail(receptionDto.getEmail());
        reception.setPhoneNo(receptionDto.getPhoneNo());
        reception.setRole("RECEPTION");
        reception.setShift(receptionDto.getShift());
        reception.setPassword(receptionDto.getPassword());

        // Assign doctor to receptionist
        Doctor doctor = doctorService.getDoctorById(receptionDto.getDoctorid());
        reception.setDoctorid(doctor);

        // Save receptionist data
        Reception savedReception = receptionService.saveReception(reception);

        return new ResponseEntity<>(savedReception, HttpStatus.CREATED);
    }


    // ---------------------- GET ALL RECEPTION STAFF ----------------------

    @GetMapping("/")
    public ResponseEntity<List<Reception>> showReception() {

        List<Reception> receptionList = receptionService.GetAllReception();

        // If no receptionist found
        if (receptionList == null || receptionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(receptionList, HttpStatus.OK);
    }


    // ---------------------- GET RECEPTION BY ID ----------------------

    @GetMapping("/{id}")
    public ResponseEntity<Reception> showReceptionById(@PathVariable("id") int id) {

        Reception reception = receptionService.GetReceptionById(id);

        // If record not found
        if (reception == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reception, HttpStatus.OK);
    }


    // ---------------------- UPDATE RECEPTION STAFF ----------------------

    @PutMapping("/{id}")
    public ResponseEntity<Reception> updateReception(@PathVariable("id") int id,@Valid  @RequestBody ReceptionDto receptionDto) {

        Reception reception = receptionService.GetReceptionById(id);

        // Validate record
        if (reception == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Update fields
        reception.setName(receptionDto.getName());
        reception.setEmail(receptionDto.getEmail());
        reception.setPhoneNo(receptionDto.getPhoneNo());
        reception.setShift(receptionDto.getShift());
        reception.setPassword(receptionDto.getPassword());

        // Update doctor assignment
        Doctor doctor = doctorService.getDoctorById(receptionDto.getDoctorid());
        reception.setDoctorid(doctor);

        // Save updated record
        Reception updatedReception = receptionService.saveReception(reception);

        return new ResponseEntity<>(updatedReception, HttpStatus.OK);
    }


    // ---------------------- DELETE RECEPTION STAFF ----------------------

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReception(@PathVariable("id") int id) {

        Reception reception = receptionService.GetReceptionById(id);

        // Check existence
        if (reception == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Perform deletion
        receptionService.DeleteReception(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    // ----------------------Get RECEPTION STAFF By Doctor Id ----------------------
    
    @GetMapping("/doctor/{doctorid}")
    public ResponseEntity<List<Reception>>GetReceptionByDoctor(@PathVariable int doctorid){
    	
    	List<Reception> reception = receptionService.GetReceptionsByDoctor(doctorid);
    	
    	 if (reception == null || reception.isEmpty()) {
    	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	    }

    	    return new ResponseEntity<>(reception, HttpStatus.OK);
    	
    }
    
    @PostMapping("/login")
    public ResponseEntity<Reception> loginReception(@RequestBody ReceptionDto loginDto) {

        Reception reception = receptionService.getReceptionByEmail(loginDto.getEmail());

        if (reception == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!reception.getPassword().equals(loginDto.getPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(reception, HttpStatus.OK);
    }

}
