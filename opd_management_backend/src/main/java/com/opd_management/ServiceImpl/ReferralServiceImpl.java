package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.Repositories.ReferralRepository;
import com.opd_management.Services.ReferralService;
import com.opd_management.entities.Referral;

@Service
public class ReferralServiceImpl implements ReferralService {

	@Autowired
	private ReferralRepository referralRepository;
	
	@Override
	public Referral saveReferral(Referral referral) {
		// TODO Auto-generated method stub
		return referralRepository.save(referral);
	}

	@Override
	public List<Referral> GetAllReferral() {
		// TODO Auto-generated method stub
		return referralRepository.findAll();
	}

	@Override
	public Referral GetReferralById(int id) {
		// TODO Auto-generated method stub
		return referralRepository.findById(id).orElse(null);
	}

	@Override
	public void DeleteReferral(int id) {
		// TODO Auto-generated method stub
		referralRepository.deleteById(id);
	}

}
