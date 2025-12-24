package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.opd_management.Exception.DataBaseException;
import com.opd_management.Exception.ResourceNotFoundException;
import com.opd_management.Repositories.ReferralRepository;
import com.opd_management.Services.ReferralService;
import com.opd_management.entities.Bill;
import com.opd_management.entities.Referral;

@Service
public class ReferralServiceImpl implements ReferralService {

	@Autowired
	private ReferralRepository referralRepository;
	
	@Override
	public Referral saveReferral(Referral referral) {
		try {
			return referralRepository.save(referral);
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to save Referral due to database error" ,e);
		}
	
	}

	@Override
	public List<Referral> GetAllReferral() {
		try {
			return referralRepository.findAll();
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to Show Referral due to database error", e);
		}
		
	}

	@Override
	public Referral GetReferralById(int id) {
		try {
			return referralRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Referral Doctor Not Found With this id: "+ id));
		} catch (DataAccessException e) {
			throw new DataBaseException("Failed to Show Referral due to database error"+ id ,e);
		}

	}

	@Override
	public void DeleteReferral(int id) {
		Referral referral = referralRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException( "Referral not found with id: " + id));
		
		try {
			referralRepository.delete(referral);
		} catch (DataAccessException e) {
			throw new DataBaseException("Database error while deleting Referral with id: " + id,e);
		}
	}

}
