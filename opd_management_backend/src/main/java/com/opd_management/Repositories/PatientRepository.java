package com.opd_management.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.Patient;

@Repository // access jpa method 
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	List<Patient> findByDoctorid_Id(int doctorId);


}
