package com.opd_management.Services;

import java.util.List;

import com.opd_management.entities.Diagnostic;

public interface DiagnosticService {

	Diagnostic saveDiagnostic(Diagnostic diagnostic);
	List<Diagnostic> GetAllDiagnostic();
	Diagnostic GetDiagnosticByID(int id);
	void DeleteDiagnostic(int id);
}
