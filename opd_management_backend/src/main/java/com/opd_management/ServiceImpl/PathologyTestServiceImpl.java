package com.opd_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.opd_management.Exception.DataBaseException;
import com.opd_management.Exception.ResourceNotFoundException;
import com.opd_management.Repositories.PathologyTestRepository;
import com.opd_management.Services.PathologyTestService;
import com.opd_management.entities.Bill;
import com.opd_management.entities.PathologyTest;

@Service
public class PathologyTestServiceImpl implements PathologyTestService {

	@Autowired
	private PathologyTestRepository pathologyTestRepository;
	
	@Override
	public PathologyTest savePathologyTest(PathologyTest pathologyTest) {
		try {
			return pathologyTestRepository.save(pathologyTest);
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to save PathologyTest due to database error" ,e);
		}

	}

	@Override
	public List<PathologyTest> GetAllPathologyTest() {
		try {
			return pathologyTestRepository.findAll();
		} catch (DataAccessException  e) {
			 throw new DataBaseException("Failed to Show PathologyTest due to database error", e);
		}
		
	}

	@Override
	public PathologyTest GetPathologyTestById(int id) {
		try {
			return pathologyTestRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pathology tests Not Found With this id: "+ id));
		} catch (DataAccessException e) {
			throw new DataBaseException("Failed to Show Pathology due to database error"+ id ,e);
		}
		
	}

	@Override
	public void DeletePathologyTest(int id) {
			PathologyTest pathologyTest = pathologyTestRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException( "Pathology not found with id: " + id));
		
		try {
			pathologyTestRepository.delete(pathologyTest);
		} catch (DataAccessException e) {
			throw new DataBaseException("Database error while deleting Pathology with id: " + id,e);
		}
	}

}
