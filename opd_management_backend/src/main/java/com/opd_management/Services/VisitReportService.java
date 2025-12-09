package com.opd_management.Services;

import java.util.List;

import com.opd_management.entities.VisitReport;

public interface VisitReportService {

	VisitReport saveVisitReport(VisitReport visitReport);
	List<VisitReport> GetAllVisitReport();
	VisitReport GetVisitReportById(int id);
	void DeleteVisitReport(int id);
}
