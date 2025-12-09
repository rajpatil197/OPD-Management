package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.Repositories.TestMasterRepository;
import com.opd_management.Services.TestMasterService;
import com.opd_management.entities.TestMaster;

@Service
public class TestMasterServiceImpl implements TestMasterService {

	@Autowired
	private TestMasterRepository testMasterRepository;
	
	@Override
	public TestMaster saveTestMaster(TestMaster testMaster) {
		// TODO Auto-generated method stub
		return testMasterRepository.save(testMaster);
	}

	@Override
	public List<TestMaster> GetAllTestMaster() {
		// TODO Auto-generated method stub
		return testMasterRepository.findAll();
	}

	@Override
	public TestMaster GetTestMasterById(int id) {
		// TODO Auto-generated method stub
		return testMasterRepository.findById(id).orElse(null);
	}

	@Override
	public void DeleteTestMaster(int id) {
		// TODO Auto-generated method stub
		testMasterRepository.deleteById(id);
	}

}
