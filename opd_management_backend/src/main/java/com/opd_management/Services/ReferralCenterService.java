package com.opd_management.Services;

import java.util.List;

import com.opd_management.entities.Medicine;
import com.opd_management.entities.ReferralCenter;

public interface ReferralCenterService {

	ReferralCenter saveReferralCenter(ReferralCenter referralCenter);
	List<ReferralCenter> GetAllReferralCenter();
	ReferralCenter GetReferralCenterById(int id);
	void DeleteReferralCenter(int id);
}
