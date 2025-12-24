package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.opd_management.Exception.DataBaseException;
import com.opd_management.Exception.ResourceNotFoundException;
import com.opd_management.Repositories.BillRepository;
import com.opd_management.Services.BillService;
import com.opd_management.entities.Bill;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;
	
	@Override
	public Bill saveBill(Bill bill) {
		try {
			return billRepository.save(bill);
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to save Bill due to database error" ,e);
		}
	}

	@Override
	public List<Bill> GetAllBill() {
		try {
			return billRepository.findAll();
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to Show Bills due to database error", e);
		}
		
	}

	@Override
	public Bill GetBillById(int id) {
		try {
			return billRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Bill Not Found With this id: "+ id));
		} catch (DataAccessException e) {
			throw new DataBaseException("Failed to Show Bill due to database error"+ id ,e);
		}
		
	}

	@Override
	public void DeleteBill(int id) {
		
		Bill bill = billRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException( "Bill not found with id: " + id));
		
		try {
			billRepository.delete(bill);
		} catch (DataAccessException e) {
			throw new DataBaseException("Database error while deleting Bill with id: " + id,e);
		}
	}

}
