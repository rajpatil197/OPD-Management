package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.Repositories.PathologyTestRepository;
import com.opd_management.Services.PathologyTestService;
import com.opd_management.entities.PathologyTest;

@Service
public class PathologyTestServiceImpl implements PathologyTestService {

	@Autowired
	private PathologyTestRepository pathologyTestRepository;
	
	@Override
	public PathologyTest savePathologyTest(PathologyTest pathologyTest) {
		// TODO Auto-generated method stub
		return pathologyTestRepository.save(pathologyTest);
	}

	@Override
	public List<PathologyTest> GetAllPathologyTest() {
		// TODO Auto-generated method stub
		return pathologyTestRepository.findAll();
	}

	@Override
	public PathologyTest GetPathologyTestById(int id) {
		// TODO Auto-generated method stub
		return pathologyTestRepository.findById(id).orElse(null);
	}

	@Override
	public void DeletePathologyTest(int id) {
		// TODO Auto-generated method stub
		pathologyTestRepository.deleteById(id);
	}

}
