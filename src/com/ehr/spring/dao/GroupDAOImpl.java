package com.ehr.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ehr.spring.model.Group;
import com.ehr.spring.model.Person;
@Repository
public class GroupDAOImpl implements GroupDAO {
	private static final Logger logger = LoggerFactory.getLogger(GroupDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	@Override
	public void createGroup(Group p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
		
	}


	

	@Override
	public void deleteGroup(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Group p = (Group) session.load(Group.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, Group details="+p);
	}
		
	
	@Override
	public void updateGroup(Group p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Group updated successfully, Group Details="+p);
		
	}
	
	public List<Group> listGroups() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Group> personsList = session.createQuery("from Group").list();
		for(Group p : personsList){
			logger.info("Group List::"+p);
		}
		return personsList;
	}
	@Override
	public Group getGroupById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Group p = (Group) session.load(Group.class, new Integer(id));
		logger.info("Group loaded successfully, Person details="+p);
		return p;
	}
}
