package com.ehr.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehr.spring.dao.GroupDAO;
import com.ehr.spring.dao.PersonDAO;
import com.ehr.spring.model.Group;
import com.ehr.spring.model.Person;
@Service
public class GroupServiceImpl implements GroupService {
	private GroupDAO groupDAO;

	
	@Transactional
	public void createGroup(Group p) {
		groupDAO.createGroup(p);
		
	}
	@Transactional
	public void updateGroup(Group p) {
		groupDAO.updateGroup(p);
		
	}
	

	@Transactional
	public void deleteGroup(int id) {
		groupDAO.deleteGroup(id);
		
	}
	@Transactional
	@Override
	public List<Group> listGroups() {
		return this.groupDAO.listGroups();
	}
	public GroupDAO getGroupDAO() {
		return groupDAO;
	}
	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}
	@Override
	@Transactional
	public Group getGroupById(int id) {
		return this.groupDAO.getGroupById(id);
	}

}
