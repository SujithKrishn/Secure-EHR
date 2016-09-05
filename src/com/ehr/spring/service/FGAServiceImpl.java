package com.ehr.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehr.spring.dao.FineGrainedAccessDAO;
import com.ehr.spring.dao.GroupDAO;
import com.ehr.spring.dao.PersonDAO;
import com.ehr.spring.model.FGA;
import com.ehr.spring.model.Group;
@Service
public class FGAServiceImpl implements FGAService {
	private FineGrainedAccessDAO fineGrainedAccessDAO;

	public FineGrainedAccessDAO getFineGrainedAccessDAO() {
		return fineGrainedAccessDAO;
	}

	public void setFineGrainedAccessDAO(FineGrainedAccessDAO fineGrainedAccessDAO) {
		this.fineGrainedAccessDAO = fineGrainedAccessDAO;
	}
	@Transactional
	public void createFGA(FGA p) {
		fineGrainedAccessDAO.createFGA(p);
		
	}
	@Transactional
	public void updateFGA(FGA p) {
		fineGrainedAccessDAO.updateFGA(p);
		
	}
	

	@Transactional
	public void deleteFGA(int id) {
		fineGrainedAccessDAO.deleteFGA(id);
		
	}
	@Transactional
	@Override
	public List<FGA> listFGAs() {
		return this.fineGrainedAccessDAO.listFGAs();
	}
	
	@Override
	@Transactional
	public FGA getFGAById(int id) {
		return this.fineGrainedAccessDAO.getFGAById(id);
	}
	@Transactional
	@Override
	public Map listFGAColumns() {
		return this.fineGrainedAccessDAO.listFGAColumns();
	}
	
	

}
