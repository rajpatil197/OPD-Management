package com.opd_management.Services;

import java.util.List;

import com.opd_management.entities.Bill;

public interface BillService {

	Bill saveBill(Bill bill);
	List<Bill> GetAllBill();
	Bill GetBillById(int id);
	void DeleteBill(int id);
}
