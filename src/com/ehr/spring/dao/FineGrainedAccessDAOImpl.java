package com.ehr.spring.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ehr.spring.model.FGA;
import com.ehr.spring.model.Group;

public class FineGrainedAccessDAOImpl implements FineGrainedAccessDAO{
	

	private static final Logger logger = LoggerFactory.getLogger(FineGrainedAccessDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	@Override
	public void createFGA(FGA p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
		
	}


	

	@Override
	public void deleteFGA(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		FGA p = (FGA) session.load(FGA.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, FGA details="+p);
	}
		
	
	@Override
	public void updateFGA(FGA p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("FGA updated successfully, FGA Details="+p);
		
	}
	
	public List<FGA> listFGAs() {
		Session session = this.sessionFactory.getCurrentSession();
		List<FGA> personsList = session.createQuery("from FGA order by groupId").list();
		for(FGA p : personsList){
			logger.info("FGA List::"+p);
		}
		return personsList;
	}
	@Override
	public FGA getFGAById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		FGA p = (FGA) session.load(FGA.class, new Integer(id));
		logger.info("FGA loaded successfully, Person details="+p);
		return p;
	}

	public Map listFGAColumns() {
		Session session = this.sessionFactory.getCurrentSession();
		
		Map groupIds = new LinkedHashMap();
		List personsList = session.createSQLQuery(" select column_name from information_schema.columns where table_name='person'").list();
		for(int i=0;i<personsList.size();i++)
		{
			groupIds.put(personsList.get(i),personsList.get(i));
		}
		
		//groupIdMap.put(groupIdMap, groupIds);
		return groupIds;
	}
}
