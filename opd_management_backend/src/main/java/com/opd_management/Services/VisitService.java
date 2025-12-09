package com.opd_management.Services;

import java.util.List;

import com.opd_management.entities.Visit;

public interface VisitService {

	Visit saveVisit(Visit visit);
	List<Visit>GetAllVisit();
	Visit GetVisitById(int id);
	void DeleteVisitById(int id);
}
