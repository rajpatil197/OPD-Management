package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.opd_management.Exception.DataBaseException;
import com.opd_management.Exception.ResourceNotFoundException;
import com.opd_management.Repositories.VisitRepository;
import com.opd_management.Services.VisitService;
import com.opd_management.entities.Bill;
import com.opd_management.entities.Visit;

@Service
public class VisitServiceImpl implements VisitService {

	@Autowired
	private VisitRepository visitRepository;
	
	@Override
	public Visit saveVisit(Visit visit) {
		try {
			return visitRepository.save(visit);
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to save Visit due to database error" ,e);
		}
		
	}

	@Override
	public List<Visit> GetAllVisit() {
		try {
			return visitRepository.findAll();
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to Show Visits due to database error", e);
		}
		
	}

	@Override
	public Visit GetVisitById(int id) {
		try {
			return visitRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Visit Not Found With this id: "+ id));
		} catch (DataAccessException e) {
			throw new DataBaseException("Failed to Show Visit due to database error"+ id ,e);
		}
		
	}

	@Override
	public void DeleteVisitById(int id) {
		Visit visit = visitRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException( "Visit not found with id: " + id));
		
		try {
			visitRepository.delete(visit);
		} catch (DataAccessException e) {
			throw new DataBaseException("Database error while deleting Visit with id: " + id,e);
		}
	}

	@Override
	public List<Visit> GetVisitByDoctor(int doctorId) {
		// TODO Auto-generated method stub
		return visitRepository.findByDoctorid_Id(doctorId);
	}

}
