package com.opd_management.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.ReferralCenter;

@Repository
public interface ReferralCenterRepository extends JpaRepository<ReferralCenter, Integer> {

}
