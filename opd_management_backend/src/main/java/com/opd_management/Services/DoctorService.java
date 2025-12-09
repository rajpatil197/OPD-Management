package com.opd_management.Services;

import java.util.List;

import com.opd_management.entities.Doctor;

public interface DoctorService {

	Doctor saveDoctor(Doctor doctor); //user defined method for save data
	
	List<Doctor>getAllDoctor();  //user defined method for show list of doctor data
	
	Doctor getDoctorById(int id); //user defined method for show doctor data by there id
	
	void DeleteById(int id); //user defined method for delete doctor data by there id
	
	Doctor getDoctorByEmail(String email);

}
