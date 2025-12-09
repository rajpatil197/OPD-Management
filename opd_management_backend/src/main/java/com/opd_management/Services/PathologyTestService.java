package com.opd_management.Services;

import java.util.List;

import com.opd_management.entities.PathologyTest;

public interface PathologyTestService {

	PathologyTest savePathologyTest(PathologyTest pathologyTest);
	List<PathologyTest> GetAllPathologyTest();
	PathologyTest GetPathologyTestById(int id);
	void DeletePathologyTest(int id);
	
}
