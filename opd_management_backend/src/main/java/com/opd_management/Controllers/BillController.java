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

import com.opd_management.Services.BillService;
import com.opd_management.Services.VisitService;
import com.opd_management.dtos.BillDto;
import com.opd_management.entities.Bill;
import com.opd_management.entities.Visit;

@RestController
@RequestMapping("/bills") // Base URL for bill-related APIs
public class BillController {

	@Autowired
	private BillService billService; // Service to handle Bill database operations
	
	@Autowired 
	private VisitService visitService; // Service to fetch visit details
	
	// ---------------------- Create Bill ----------------------
	
	@PostMapping("/")
	public ResponseEntity<Bill> saveBill(@RequestBody BillDto billDto){
		
		// Create new Bill entity and set values from DTO
		Bill bill = new Bill();
		bill.setConcession(billDto.getConcession());
		bill.setConsultation_fee(billDto.getConsultation_fee());
		bill.setPaid_amount(billDto.getPaid_amount());
		bill.setPayment_status(billDto.getPayment_status());
		bill.setPayment_mode(billDto.getPayment_mode());
		bill.setPending_amount(billDto.getPending_amount());
		bill.setTotal_amount(billDto.getTotal_amount());
		bill.setCreated_at(billDto.getCreated_at());
		
		// Assign related Visit entity using visit id
		Visit visit = visitService.GetVisitById(billDto.getVisitid());
		bill.setVisitid(visit);
		
		// Save bill into database
		Bill Savebill = billService.saveBill(bill);
	
		return new ResponseEntity<>(Savebill, HttpStatus.CREATED);
	}
	
	// ---------------------- Get All Bills ----------------------
	
	@GetMapping("/")
	public ResponseEntity<List<Bill>> GetAllBills(){
		
		List<Bill> bill = billService.GetAllBill();
		
		// If no bill found return NOT_FOUND
		if(bill == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(bill, HttpStatus.OK);
	}
	
	// ---------------------- Get Bill By ID ----------------------
	
	@GetMapping("/{id}")
	public ResponseEntity<Bill> GetBillById(@PathVariable("id") int id){
		
		Bill bill = billService.GetBillById(id);
		
		// If bill doesn't exist return NOT_FOUND
		if(bill == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(bill, HttpStatus.OK);
	}
	
	// ---------------------- Update Bill ----------------------
	
	@PutMapping("/{id}")
	public ResponseEntity<Bill> UpdateBill(@PathVariable("id") int id, @RequestBody BillDto billDto){
		
		Bill bill = billService.GetBillById(id);
		
		// If bill doesn't exist return NOT_FOUND
		if(bill == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Update bill fields
		bill.setConcession(billDto.getConcession());
		bill.setConsultation_fee(billDto.getConsultation_fee());
		bill.setPaid_amount(billDto.getPaid_amount());
		bill.setPayment_status(billDto.getPayment_status());
		bill.setPayment_mode(billDto.getPayment_mode());
		bill.setPending_amount(billDto.getPending_amount());
		bill.setTotal_amount(billDto.getTotal_amount());
		bill.setCreated_at(billDto.getCreated_at());
		
		// Update visit information
		Visit visit = visitService.GetVisitById(billDto.getVisitid());
		bill.setVisitid(visit);
		
		// Save updated bill
		Bill Updatebill = billService.saveBill(bill);
	
		return new ResponseEntity<>(Updatebill, HttpStatus.OK);
	}
	
	// ---------------------- Delete Bill ----------------------
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Bill> DeleteBill(@PathVariable("id") int id){
		
		Bill bill = billService.GetBillById(id);
		
		// If bill not found return NOT_FOUND
		if(bill == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// Delete bill
		billService.DeleteBill(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Success but no content to return
	}
	
}

