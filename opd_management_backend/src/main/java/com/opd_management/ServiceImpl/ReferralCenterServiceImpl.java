package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.opd_management.Exception.DataBaseException;
import com.opd_management.Exception.ResourceNotFoundException;
import com.opd_management.Repositories.ReferralCenterRepository;
import com.opd_management.Services.ReferralCenterService;
import com.opd_management.entities.Bill;
import com.opd_management.entities.ReferralCenter;

@Service
public class ReferralCenterServiceImpl implements ReferralCenterService {

	@Autowired
	private ReferralCenterRepository  referralCenterRepository;
	
	@Override
	public ReferralCenter saveReferralCenter(ReferralCenter referralCenter) {
		try {
			return referralCenterRepository.save(referralCenter);
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to save ReferralCenter due to database error" ,e);
		}
		
	}

	@Override
	public List<ReferralCenter> GetAllReferralCenter() {
		try {
			return referralCenterRepository.findAll();
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to Show ReferralCenter due to database error", e);
		}
		
	}

	@Override
	public ReferralCenter GetReferralCenterById(int id) {
		try {
			return referralCenterRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Referral Center Not Found With this id: "+ id));
		} catch (DataAccessException e) {
			throw new DataBaseException("Failed to Show ReferralCenter due to database error"+ id ,e);
		}
		
	
	}

	@Override
	public void DeleteReferralCenter(int id) {
		ReferralCenter referralCenter = referralCenterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException( "Referral Center not found with id: " + id));
		
		try {
			referralCenterRepository.delete(referralCenter);
		} catch (DataAccessException e) {
			throw new DataBaseException("Database error while deleting Referral Center with id: " + id,e);
		}
	}

}
