package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.Repositories.BillRepository;
import com.opd_management.Services.BillService;
import com.opd_management.entities.Bill;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;
	
	@Override
	public Bill saveBill(Bill bill) {
		// TODO Auto-generated method stub
		return billRepository.save(bill);
	}

	@Override
	public List<Bill> GetAllBill() {
		// TODO Auto-generated method stub
		return billRepository.findAll();
	}

	@Override
	public Bill GetBillById(int id) {
		// TODO Auto-generated method stub
		return billRepository.findById(id).orElse(null);
	}

	@Override
	public void DeleteBill(int id) {
		// TODO Auto-generated method stub
		billRepository.deleteById(id);
	}

}
