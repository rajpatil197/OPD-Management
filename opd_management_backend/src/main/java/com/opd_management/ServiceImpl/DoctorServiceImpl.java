package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.opd_management.Exception.DataBaseException;
import com.opd_management.Exception.DuplicateResourceException;
import com.opd_management.Exception.ResourceNotFoundException;
import com.opd_management.Repositories.DoctorRepository;
import com.opd_management.Services.DoctorService;
import com.opd_management.entities.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	// creating object of doctor repository
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//access repository methods
	@Override
	public Doctor saveDoctor(Doctor doctor) {

	    //  Check duplicate email
	    if (doctorRepository.existsByEmail(doctor.getEmail())) {
	        throw new DuplicateResourceException("Doctor with email " + doctor.getEmail() + " already exists");
	    }
	    try {
	    	doctor.setPassword(passwordEncoder.encode(doctor.getPassword())); //Encrypt password
	    	
	        return doctorRepository.save(doctor);
	    } catch (DataAccessException  e) {
	        throw new DataBaseException("Failed to save doctor due to database error",e);
	    }
	}


	@Override
	public List<Doctor> getAllDoctor() {
		
		try {
			return doctorRepository.findAll();//repository method
		} catch (DataAccessException  e) {
			throw new DataBaseException("Failed to Show doctors due to database error", e);
		}
	}

	@Override
	public Doctor getDoctorById(int id) {
		try {
			return doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor Not Found With this id: "+ id));//repository method
		} catch (DataAccessException  e) {
			throw new DataBaseException("Failed to Show doctor due to database error with id",e);
		}
		
	}

	@Override
	public void DeleteById(int id) {
		Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor Not Found With this id: "+ id));
		
		try {
			doctorRepository.delete(doctor);
		} catch (DataAccessException e) {
			throw new DataBaseException("Database error while deleting Doctor with id: " + id , e);
		}
	}
	
	
	@Override
	public Doctor getDoctorByEmail(String email) {
	    try {
	    	return doctorRepository.findByEmail(email);
		} catch (DataAccessException  e) {
			throw new DataBaseException("Failed to Get doctor due to database error",e);	
			}
	}


}
