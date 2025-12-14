package com.opd_management.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.Reception;

@Repository
public interface ReceptionRepository extends JpaRepository<Reception, Integer> {
	
	List<Reception> findByDoctorid_Id(int doctor_Id);

	Reception findByEmail(String email);
}
