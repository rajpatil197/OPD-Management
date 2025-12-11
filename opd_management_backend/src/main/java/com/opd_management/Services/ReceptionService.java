package com.opd_management.Services;

import java.util.List;

import com.opd_management.entities.Reception;

public interface ReceptionService {

	Reception saveReception(Reception reception);
	List<Reception> GetAllReception();
	Reception GetReceptionById(int id);
	void DeleteReception(int id);
}
