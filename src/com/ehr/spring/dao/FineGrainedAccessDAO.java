package com.ehr.spring.dao;

import java.util.List;
import java.util.Map;

import com.ehr.spring.model.FGA;

public interface FineGrainedAccessDAO {
	
	public void createFGA(FGA p);
	public void updateFGA(FGA p);

	public void deleteFGA(int id);
	public List<FGA> listFGAs();
	public FGA getFGAById(int id);
	public Map listFGAColumns();
}
