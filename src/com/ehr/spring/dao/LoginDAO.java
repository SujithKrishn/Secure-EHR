package com.ehr.spring.dao;

import java.util.List;
import java.util.Map;

import com.ehr.spring.model.Group;
import com.ehr.spring.model.Login;
import com.ehr.spring.model.Person;

public interface LoginDAO {
	
	public void createUser(Login p);
	public void updateUser(Login p);
	public Boolean validateUser(Login u);
	public void deleteUser(int id);
	public List<Login> listUsers();
	public Login getUserById(int id);
	public Map listExistingGroups();
	public List userAccessData(Login u);
}
