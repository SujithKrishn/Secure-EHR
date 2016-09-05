package com.ehr.spring.service;

import java.util.List;
import java.util.Map;

import com.ehr.spring.model.Login;
import com.ehr.spring.model.Person;

public interface LoginService {
	public void createUser(Login p);
	public void updateUser(Login p);
	public Boolean validateUser(Login u);
	public void deleteUser(int id);
	public List<Login> listUsers();
	public Map listExistingGroups();
	public List userAccessData(Login u);
	public Login getUserById(int id);
	
}
