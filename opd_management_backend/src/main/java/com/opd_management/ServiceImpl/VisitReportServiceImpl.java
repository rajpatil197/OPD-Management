package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.Repositories.VisitReportRepository;
import com.opd_management.Services.VisitReportService;
import com.opd_management.entities.VisitReport;

@Service
public class VisitReportServiceImpl implements VisitReportService {

	@Autowired
	private VisitReportRepository visitReportRepository;
	
	@Override
	public VisitReport saveVisitReport(VisitReport visitReport) {
		// TODO Auto-generated method stub
		return visitReportRepository.save(visitReport);
	}

	@Override
	public List<VisitReport> GetAllVisitReport() {
		// TODO Auto-generated method stub
		return visitReportRepository.findAll();
	}

	@Override
	public VisitReport GetVisitReportById(int id) {
		// TODO Auto-generated method stub
		return visitReportRepository.findById(id).orElse(null);
	}

	@Override
	public void DeleteVisitReport(int id) {
		// TODO Auto-generated method stub
		visitReportRepository.deleteById(id);
	}

}
