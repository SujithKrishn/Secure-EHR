package com.ehr.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehr.spring.dao.GroupDAO;
import com.ehr.spring.dao.LoginDAO;
import com.ehr.spring.dao.PersonDAO;
import com.ehr.spring.model.Group;
import com.ehr.spring.model.Login;
@Service
public class LoginServiceImpl implements LoginService {
	private LoginDAO loginDAO;

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	@Transactional
	public void createUser(Login p) {
		loginDAO.createUser(p);
		
	}
	@Transactional
	public void updateUser(Login p) {
		loginDAO.updateUser(p);
		
	}
	@Transactional
	public Boolean validateUser(Login u) {
		return loginDAO.validateUser(u);
	}

	@Transactional
	public void deleteUser(int id) {
		loginDAO.deleteUser(id);
		
	}
	@Transactional
	@Override
	public List<Login> listUsers() {
		return this.loginDAO.listUsers();
	}
	
	@Override
	@Transactional
	public Login getUserById(int id) {
		return this.loginDAO.getUserById(id);
	}
	
	@Transactional
	@Override
	public Map listExistingGroups() {
		// TODO Auto-generated method stub
		return this.loginDAO.listExistingGroups();
	}
	@Transactional
	@Override
	public List userAccessData(Login u) {
		// TODO Auto-generated method stub
		return this.loginDAO.userAccessData(u);
	}

}
