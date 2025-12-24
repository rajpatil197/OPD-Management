package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.opd_management.Exception.DataBaseException;
import com.opd_management.Exception.DuplicateResourceException;
import com.opd_management.Exception.ResourceNotFoundException;
import com.opd_management.Repositories.ReceptionRepository;
import com.opd_management.Services.ReceptionService;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Reception;

@Service
public class ReceptionServiceImpl implements ReceptionService {

	@Autowired
	private ReceptionRepository receptionRepository;
	
	@Override
	public Reception saveReception(Reception reception) {
		if (receptionRepository.existsByEmail(reception.getEmail())) {
	        throw new DuplicateResourceException("Reception with email " + reception.getEmail() + " already exists");
	    }
	    try {
	        return receptionRepository.save(reception);
	    } catch (DataAccessException  e) {
	        throw new DataBaseException("Failed to save Reception due to database error",e);
	    }
	}

	@Override
	public List<Reception> GetAllReception() {
		try {
			return receptionRepository.findAll();//repository method
		} catch (DataAccessException  e) {
			throw new DataBaseException("Failed to Show Receptions due to database error", e);
		}
		
	}

	@Override
	public Reception GetReceptionById(int id) {
		try {
			return receptionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Reception Not Found With this id: "+ id));//repository method
		} catch (DataAccessException  e) {
			throw new DataBaseException("Failed to Show Reception due to database error with id",e);
		}
		
	}

	@Override
	public void DeleteReception(int id) {
		Reception reception = receptionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Reception Not Found With this id: "+ id));
		
		try {
			receptionRepository.delete(reception);
		} catch (DataAccessException e) {
			throw new DataBaseException("Database error while deleting Reception with id: " + id , e);
		}
	}

	@Override
	public List<Reception> GetReceptionsByDoctor(int doctorid) {
		// TODO Auto-generated method stub
		return receptionRepository.findByDoctorid_Id(doctorid);
	}

	@Override
	public Reception getReceptionByEmail(String email) {
		// TODO Auto-generated method stub
		return receptionRepository.findByEmail(email);
	}

}
