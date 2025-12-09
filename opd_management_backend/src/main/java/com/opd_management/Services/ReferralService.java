package com.opd_management.Services;

import java.util.List;

import com.opd_management.entities.Referral;

public interface ReferralService {

	Referral saveReferral(Referral referral);
	List<Referral> GetAllReferral();
	Referral GetReferralById(int id);
	void DeleteReferral(int id);
}
