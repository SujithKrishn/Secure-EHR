package com.ehr.spring.dao;

import java.util.List;
import java.util.Map;

import com.ehr.spring.model.Person;

public interface PersonDAO {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
	public Map listPhysicians();
	
	public List<Person> listEncrptedPersons(Person p, String sessionToken);
	public List<Person> listDecryptPersons(String token);
}
