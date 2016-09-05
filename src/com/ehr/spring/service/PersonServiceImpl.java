package com.ehr.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehr.spring.dao.PersonDAO;
import com.ehr.spring.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDAO.addPerson(p);
	}

	@Override
	@Transactional
	public void updatePerson(Person p) {
		this.personDAO.updatePerson(p);
	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}

	@Override
	@Transactional
	public Map listPhysicians() {
		return this.personDAO.listPhysicians();
	}

	@Override
	@Transactional
	public List<Person> listEncrptedPersons(Person p, String sessionToken) {
		return this.personDAO.listEncrptedPersons(p,sessionToken);
	}



	@Override
	@Transactional //else throws error  No Session found for current thread
	public List<Person> listDecryptPersons(String token) {
		// TODO Auto-generated method stub
		return this.personDAO.listDecryptPersons(token);
	}

}
