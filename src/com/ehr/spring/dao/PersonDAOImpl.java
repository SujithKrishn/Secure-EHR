package com.ehr.spring.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ehr.spring.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updatePerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person").list();
		for(Person p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

	@Override
	public Map listPhysicians() {
Session session = this.sessionFactory.getCurrentSession();
		
		Map physicians = new LinkedHashMap();
		List personsList = session.createSQLQuery(" select loginName from login").list();
		for(int i=0;i<personsList.size();i++)
		{
			physicians.put(personsList.get(i),personsList.get(i));
		}
		
		//groupIdMap.put(groupIdMap, groupIds);
		return physicians;
	}

	@Override
	public List<Person> listEncrptedPersons(Person p, String sessionToken) {
		Session session = this.sessionFactory.getCurrentSession();
		//session.getTransaction().begin();

		SQLQuery  query = session.createSQLQuery("INSERT INTO public_ehr.person( session_token,  name,country, fatherName,motherName,gender,  bloodType,dob, disease,symptoms,diagnosis,isUndergoneSurgery,tempAddress,permanentAddress,isEyeSightProblem,  leftEyePower,rightEyePower, isHandicapped, hasPolio,  hasCancer, cancerType, hasDiabetis,hasBloodPressure, hasSTD,physician) SELECT '"+sessionToken+"', AES_ENCRYPT(name,'"+sessionToken+"'),AES_ENCRYPT(country,'"+sessionToken+"'),AES_ENCRYPT(fatherName,'"+sessionToken+"'), AES_ENCRYPT(motherName,'"+sessionToken+"'),  AES_ENCRYPT(gender,'"+sessionToken+"'),AES_ENCRYPT(bloodType,'"+sessionToken+"'), AES_ENCRYPT(dob,'"+sessionToken+"'), AES_ENCRYPT(disease,'"+sessionToken+"'),AES_ENCRYPT(symptoms,'"+sessionToken+"'), AES_ENCRYPT(diagnosis,'"+sessionToken+"'), AES_ENCRYPT(isUndergoneSurgery,'"+sessionToken+"'),AES_ENCRYPT(tempAddress,'"+sessionToken+"'), AES_ENCRYPT(permanentAddress,'"+sessionToken+"'),  AES_ENCRYPT(isEyeSightProblem,'"+sessionToken+"'),AES_ENCRYPT(leftEyePower,'"+sessionToken+"'),AES_ENCRYPT(rightEyePower,'"+sessionToken+"'),AES_ENCRYPT(isHandicapped,'"+sessionToken+"'),AES_ENCRYPT(hasPolio,'"+sessionToken+"'),AES_ENCRYPT(hasCancer,'"+sessionToken+"'), AES_ENCRYPT(cancerType,'"+sessionToken+"'),AES_ENCRYPT(hasDiabetis,'"+sessionToken+"'),AES_ENCRYPT(hasBloodPressure,'"+sessionToken+"'),AES_ENCRYPT(hasSTD,'"+sessionToken+"'),AES_ENCRYPT(physician,'"+sessionToken+"') FROM person where id="+p.getId());
        int result = query.executeUpdate();
       
       

     //   session.getTransaction().commit();

        System.out.println("result:"+result);
        List personsList = session.createSQLQuery("select * from public_ehr.person").list();
		for(Object p1 : personsList){
			logger.info("Person List::"+p1);
		}
		try{
		// session.getTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e.toString());
		}
				
		return personsList;
	}

	

	@Override
	public List<Person> listDecryptPersons(String sessionToken) {

		Session session = this.sessionFactory.getCurrentSession();
		//session.getTransaction().begin();

	//	SQLQuery  query = session.createSQLQuery("INSERT INTO ehr2.person(  name,country, fatherName,motherName,gender,  bloodType,dob, disease,symptoms,diagnosis,isUndergoneSurgery,tempAddress,permanentAddress,isEyeSightProblem,  leftEyePower,rightEyePower, isHandicapped, hasPolio,  hasCancer, cancerType, hasDiabetis,hasBloodPressure, hasSTD,physician) SELECT '"+sessionToken+"', AES_ENCRYPT(name,'"+sessionToken+"'),AES_ENCRYPT(country,'"+sessionToken+"'),AES_ENCRYPT(fatherName,'"+sessionToken+"'), AES_ENCRYPT(motherName,'"+sessionToken+"'),  AES_ENCRYPT(gender,'"+sessionToken+"'),AES_ENCRYPT(bloodType,'"+sessionToken+"'), AES_ENCRYPT(dob,'"+sessionToken+"'), AES_ENCRYPT(disease,'"+sessionToken+"'),AES_ENCRYPT(symptoms,'"+sessionToken+"'), AES_ENCRYPT(diagnosis,'"+sessionToken+"'), AES_ENCRYPT(isUndergoneSurgery,'"+sessionToken+"'),AES_ENCRYPT(tempAddress,'"+sessionToken+"'), AES_ENCRYPT(permanentAddress,'"+sessionToken+"'),  AES_ENCRYPT(isEyeSightProblem,'"+sessionToken+"'),AES_ENCRYPT(leftEyePower,'"+sessionToken+"'),AES_ENCRYPT(rightEyePower,'"+sessionToken+"'),AES_ENCRYPT(isHandicapped,'"+sessionToken+"'),AES_ENCRYPT(hasPolio,'"+sessionToken+"'),AES_ENCRYPT(hasCancer,'"+sessionToken+"'), AES_ENCRYPT(cancerType,'"+sessionToken+"'),AES_ENCRYPT(hasDiabetis,'"+sessionToken+"'),AES_ENCRYPT(hasBloodPressure,'"+sessionToken+"'),AES_ENCRYPT(hasSTD,'"+sessionToken+"'),AES_ENCRYPT(physician,'"+sessionToken+"') FROM person");
        
		
		SQLQuery  query = session.createSQLQuery("INSERT INTO ehr2.person(session_token,name,country, fatherName,motherName,gender,  bloodType,dob, disease,symptoms,diagnosis,isUndergoneSurgery,tempAddress,permanentAddress,isEyeSightProblem,  leftEyePower,rightEyePower, isHandicapped, hasPolio,  hasCancer, cancerType, hasDiabetis,hasBloodPressure, hasSTD,physician) SELECT '"+sessionToken+"', CONVERT(aes_decrypt(name,'"+sessionToken+"') USING utf8),CONVERT(aes_decrypt(country,'"+sessionToken+"') USING utf8),CONVERT(aes_decrypt(fatherName,'"+sessionToken+"') USING utf8), CONVERT(aes_decrypt(motherName,'"+sessionToken+"') USING utf8),  CONVERT(aes_decrypt(gender,'"+sessionToken+"') USING utf8),CONVERT(aes_decrypt(bloodType,'"+sessionToken+"') USING utf8), CONVERT(aes_decrypt(dob,'"+sessionToken+"') USING utf8), CONVERT(aes_decrypt(disease,'"+sessionToken+"') USING utf8),CONVERT(aes_decrypt(symptoms,'"+sessionToken+"') USING utf8), CONVERT(aes_decrypt(diagnosis,'"+sessionToken+"') USING utf8), CONVERT(aes_decrypt(isUndergoneSurgery,'"+sessionToken+"') USING utf8),CONVERT(aes_decrypt(tempAddress,'"+sessionToken+"') USING utf8), CONVERT(aes_decrypt(permanentAddress,'"+sessionToken+"') USING utf8),  CONVERT(aes_decrypt(isEyeSightProblem,'"+sessionToken+"') USING utf8),CONVERT(aes_decrypt(leftEyePower,'"+sessionToken+"') USING utf8),CONVERT(aes_decrypt(rightEyePower,'"+sessionToken+"') USING utf8),CONVERT(aes_decrypt(isHandicapped,'"+sessionToken+"') USING utf8),CONVERT(aes_decrypt(hasPolio,'"+sessionToken+"') USING utf8),CONVERT(aes_decrypt(hasCancer,'"+sessionToken+"') USING utf8), CONVERT(aes_decrypt(cancerType,'"+sessionToken+"') USING utf8),CONVERT(aes_decrypt(hasDiabetis,'"+sessionToken+"') USING utf8),CONVERT(aes_decrypt(hasBloodPressure,'"+sessionToken+"') USING utf8),CONVERT(aes_decrypt(hasSTD,'"+sessionToken+"') USING utf8),CONVERT(aes_decrypt(physician,'"+sessionToken+"') USING utf8) FROM public_ehr.person where session_token='"+sessionToken+"'");
		int result = query.executeUpdate();
		
		query = session.createSQLQuery("delete from public_ehr.person");
		 result = query.executeUpdate();
       
       
//public_ehr.person
     //   session.getTransaction().commit();

        System.out.println("result:"+result);
        List personsList = session.createSQLQuery("select * from ehr2.person where session_token='"+sessionToken+"'").list();
		for(Object p1 : personsList){
			logger.info("Person List::"+p1);
		}
		try{
		// session.getTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e.toString());
		}
				
		return personsList;
	
	}

}
