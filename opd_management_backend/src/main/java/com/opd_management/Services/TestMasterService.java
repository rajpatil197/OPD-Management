package com.opd_management.Services;

import java.util.List;

import com.opd_management.entities.TestMaster;

public interface TestMasterService {

	TestMaster saveTestMaster(TestMaster testMaster);
	List<TestMaster> GetAllTestMaster();
	TestMaster GetTestMasterById(int id);
	void DeleteTestMaster(int id);
}
