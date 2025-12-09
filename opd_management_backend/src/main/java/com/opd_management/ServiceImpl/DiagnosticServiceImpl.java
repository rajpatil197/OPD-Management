package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.Repositories.DiagnosticRepository;
import com.opd_management.Services.DiagnosticService;
import com.opd_management.entities.Diagnostic;

@Service
public class DiagnosticServiceImpl implements DiagnosticService {

	@Autowired
	private DiagnosticRepository diagnosticRepository;
	
	@Override
	public Diagnostic saveDiagnostic(Diagnostic diagnostic) {
		// TODO Auto-generated method stub
		return diagnosticRepository.save(diagnostic);
	}

	@Override
	public List<Diagnostic> GetAllDiagnostic() {
		// TODO Auto-generated method stub
		return diagnosticRepository.findAll();
	}

	@Override
	public Diagnostic GetDiagnosticByID(int id) {
		// TODO Auto-generated method stub
		return diagnosticRepository.findById(id).orElse(null);
	}

	@Override
	public void DeleteDiagnostic(int id) {
		// TODO Auto-generated method stub
		diagnosticRepository.deleteById(id);
	}

}
