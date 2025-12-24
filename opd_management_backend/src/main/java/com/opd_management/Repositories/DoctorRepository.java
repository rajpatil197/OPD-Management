package com.opd_management.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.Doctor;

@Repository // access jpa method 
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	Doctor findByEmail(String email);

	Boolean existsByEmail(String email);
}
