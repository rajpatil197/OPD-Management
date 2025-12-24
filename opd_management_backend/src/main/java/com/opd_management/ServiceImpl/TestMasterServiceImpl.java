package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.opd_management.Exception.DataBaseException;
import com.opd_management.Exception.ResourceNotFoundException;
import com.opd_management.Repositories.TestMasterRepository;
import com.opd_management.Services.TestMasterService;
import com.opd_management.entities.Bill;
import com.opd_management.entities.TestMaster;

@Service
public class TestMasterServiceImpl implements TestMasterService {

	@Autowired
	private TestMasterRepository testMasterRepository;
	
	@Override
	public TestMaster saveTestMaster(TestMaster testMaster) {
		try {
			return testMasterRepository.save(testMaster);
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to save TestMaster due to database error" ,e);
		}
		
	}

	@Override
	public List<TestMaster> GetAllTestMaster() {
		try {
			return testMasterRepository.findAll();
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to Show TestMaster due to database error", e);
		}
		
	}

	@Override
	public TestMaster GetTestMasterById(int id) {
		try {
			return testMasterRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Test Master Not Found With this id: "+ id));
		} catch (DataAccessException e) {
			throw new DataBaseException("Failed to Show TestMaster due to database error"+ id ,e);
		}
		
	}

	@Override
	public void DeleteTestMaster(int id) {
		TestMaster testMaster = testMasterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException( "TestMaster not found with id: " + id));
		
		try {
			testMasterRepository.delete(testMaster);
		} catch (DataAccessException e) {
			throw new DataBaseException("Database error while deleting TestMaster with id: " + id,e);
		}
	}

}
