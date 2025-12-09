package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.Repositories.DoctorRepository;
import com.opd_management.Services.DoctorService;
import com.opd_management.entities.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	// creating object of doctor repository
	@Autowired
	private DoctorRepository doctorRepository;
	
	
	//access repository methods
	@Override
	public Doctor saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor) ;//repository method
	}

	@Override
	public List<Doctor> getAllDoctor() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();//repository method
	}

	@Override
	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id).orElse(null);//repository method
	}

	@Override
	public void DeleteById(int id) {
		// TODO Auto-generated method stub
		doctorRepository.deleteById(id);//repository method
	}
	@Override
	public Doctor getDoctorByEmail(String email) {
	    return doctorRepository.findByEmail(email);
	}


}
