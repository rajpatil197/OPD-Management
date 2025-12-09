package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.Repositories.ReferralCenterRepository;
import com.opd_management.Services.ReferralCenterService;
import com.opd_management.entities.ReferralCenter;

@Service
public class ReferralCenterServiceImpl implements ReferralCenterService {

	@Autowired
	private ReferralCenterRepository  referralCenterRepository;
	
	@Override
	public ReferralCenter saveReferralCenter(ReferralCenter referralCenter) {
		// TODO Auto-generated method stub
		return referralCenterRepository.save(referralCenter);
	}

	@Override
	public List<ReferralCenter> GetAllReferralCenter() {
		// TODO Auto-generated method stub
		return referralCenterRepository.findAll();
	}

	@Override
	public ReferralCenter GetReferralCenterById(int id) {
		// TODO Auto-generated method stub
		return referralCenterRepository.findById(id).orElse(null);
	}

	@Override
	public void DeleteReferralCenter(int id) {
		// TODO Auto-generated method stub
		referralCenterRepository.deleteById(id);
	}

}
