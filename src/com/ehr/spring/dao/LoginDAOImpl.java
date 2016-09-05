package com.ehr.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ehr.spring.model.Group;
import com.ehr.spring.model.Login;
import com.ehr.spring.model.Person;
@Repository
public class LoginDAOImpl implements LoginDAO {
	private static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	@Override
	public void createUser(Login p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Login saved successfully, Login Details="+p);
		
	}


	

	@Override
	public void deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Login p = (Login) session.load(Login.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Login deleted successfully, person details="+p);
	}
		
	
	@Override
	public void updateUser(Login p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Login updated successfully, Person Details="+p);
		
	}
	@Override
	public Boolean validateUser(Login u) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Login where loginName='"+u.getLoginName()+"'").list();
		
		if(personsList.size()>0)
			return true;
		else return false;
		
	}
	
	@Override
	public Login getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Login p = (Login) session.load(Login.class, new Integer(id));
		logger.info("Login loaded successfully, Person details="+p);
		return p;
	}
	@Override
	public List<Login> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Login> personsList = session.createQuery("from Login").list();
		for(Login p : personsList){
			logger.info("Login List::"+p);
		}
		return personsList;
	}
	@Override
	public Map listExistingGroups() {
		Session session = this.sessionFactory.getCurrentSession();
		Map groupIdMap = new HashMap();
		Map groupIds = new LinkedHashMap();
		List<Group> personsList = session.createQuery(" from Group").list();
		for(Group p : personsList){
			groupIds.put(p.getGroupId(),p.getGroupName());
		//	groupIds.put(p.getGroupId(), p.getGroupId());
			logger.info("Login List::"+p);
		}
		groupIdMap.put(groupIdMap, groupIds);
		return groupIds;
	}
	@Override
	public List userAccessData(Login u) {
		Session session = this.sessionFactory.getCurrentSession();
		
		List<Login> loginList = session.createQuery("from Login where loginName='"+u.getLoginName()+"'").list();
		int groupId=0;
		for(Login p : loginList){
			groupId=p.getGroupId();
			logger.info("Login List::"+p);
		}
		List userAccessDataList=new ArrayList();
		String columnListStr="";
		List columnList = session.createSQLQuery(" SELECT 'id' from DUAL UNION SELECT columnNames FROM fga where columnNames <> 'id' and groupId="+groupId).list();
		for(int i=0;i<columnList.size();i++)
		{
			columnListStr=columnListStr+columnList.get(i)+",";
		}
		System.out.println("columnListStr:"+columnListStr);
		if(columnList.size()>0)
		columnListStr=columnListStr.substring(0, columnListStr.length()-1);
		List personList = session.createSQLQuery(" SELECT "+columnListStr+" FROM person ").list();
		System.out.println("personList:"+personList);
		userAccessDataList.add(columnList);
		userAccessDataList.add(personList);
		
		return userAccessDataList;
	}
}
