package com.opd_management.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {

	List<Visit> findByDoctorid_Id(int doctorId);
}
