package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.opd_management.Exception.DataBaseException;
import com.opd_management.Exception.ResourceNotFoundException;
import com.opd_management.Repositories.VisitReportRepository;
import com.opd_management.Services.VisitReportService;
import com.opd_management.entities.Bill;
import com.opd_management.entities.VisitReport;

@Service
public class VisitReportServiceImpl implements VisitReportService {

	@Autowired
	private VisitReportRepository visitReportRepository;
	
	@Override
	public VisitReport saveVisitReport(VisitReport visitReport) {
		try {
			return visitReportRepository.save(visitReport);
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to save VisitReport due to database error" ,e);
		}
		
	}

	@Override
	public List<VisitReport> GetAllVisitReport() {
		try {
			return visitReportRepository.findAll();
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to Show VisitReport due to database error", e);
		}
		
	}

	@Override
	public VisitReport GetVisitReportById(int id) {
		try {
			return visitReportRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Visit Report Not Found With this id: "+ id));
		} catch (DataAccessException e) {
			throw new DataBaseException("Failed to Show VisitReport due to database error"+ id ,e);
		}
		
	}

	@Override
	public void DeleteVisitReport(int id) {
		VisitReport visitReport = visitReportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException( "VisitReport not found with id: " + id));
		
		try {
			visitReportRepository.delete(visitReport);
		} catch (DataAccessException e) {
			throw new DataBaseException("Database error while deleting VisitReport with id: " + id,e);
		}
	}

}
