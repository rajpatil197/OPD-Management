package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.Repositories.ReceptionRepository;
import com.opd_management.Services.ReceptionService;
import com.opd_management.entities.Reception;

@Service
public class ReceptionServiceImpl implements ReceptionService {

	@Autowired
	private ReceptionRepository receptionRepository;
	
	@Override
	public Reception saveReception(Reception reception) {
		// TODO Auto-generated method stub
		return receptionRepository.save(reception);
	}

	@Override
	public List<Reception> GetAllReception() {
		// TODO Auto-generated method stub
		return receptionRepository.findAll();
	}

	@Override
	public Reception GetReceptionById(int id) {
		// TODO Auto-generated method stub
		return receptionRepository.findById(id).orElse(null);
	}

	@Override
	public void DeleteReception(int id) {
		// TODO Auto-generated method stub
		receptionRepository.deleteById(id);
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
