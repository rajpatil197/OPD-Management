package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.opd_management.Exception.DataBaseException;
import com.opd_management.Exception.ResourceNotFoundException;
import com.opd_management.Repositories.DiagnosticRepository;
import com.opd_management.Services.DiagnosticService;
import com.opd_management.entities.Bill;
import com.opd_management.entities.Diagnostic;

@Service
public class DiagnosticServiceImpl implements DiagnosticService {

	@Autowired
	private DiagnosticRepository diagnosticRepository;
	
	@Override
	public Diagnostic saveDiagnostic(Diagnostic diagnostic) {
		try {
			return diagnosticRepository.save(diagnostic);
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to save diagnostic due to database error" ,e);
		}
	}

	@Override
	public List<Diagnostic> GetAllDiagnostic() {
		try {
			return diagnosticRepository.findAll();
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to Show diagnostic due to database error", e);
		}
	}

	@Override
	public Diagnostic GetDiagnosticByID(int id) {
		try {
			return diagnosticRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("diagnostic Not Found With this id: "+ id));
		} catch (DataAccessException e) {
			throw new DataBaseException("Failed to Show diagnostic due to database error"+ id ,e);
		}
	}

	@Override
	public void DeleteDiagnostic(int id) {
		Diagnostic diagnostic = diagnosticRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException( "Diagnostic not found with id: " + id));
		
		try {
			diagnosticRepository.delete(diagnostic);
		} catch (DataAccessException e) {
			throw new DataBaseException("Database error while deleting Diagnostic with id: " + id,e);
		}
	}

}
