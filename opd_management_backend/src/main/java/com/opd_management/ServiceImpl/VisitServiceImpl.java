package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.Repositories.VisitRepository;
import com.opd_management.Services.VisitService;
import com.opd_management.entities.Visit;

@Service
public class VisitServiceImpl implements VisitService {

	@Autowired
	private VisitRepository visitRepository;
	
	@Override
	public Visit saveVisit(Visit visit) {
		// TODO Auto-generated method stub
		return visitRepository.save(visit);
	}

	@Override
	public List<Visit> GetAllVisit() {
		// TODO Auto-generated method stub
		return visitRepository.findAll();
	}

	@Override
	public Visit GetVisitById(int id) {
		// TODO Auto-generated method stub
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public void DeleteVisitById(int id) {
		// TODO Auto-generated method stub
		visitRepository.deleteById(id);
	}

}
