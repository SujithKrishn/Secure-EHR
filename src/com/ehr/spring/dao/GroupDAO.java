package com.ehr.spring.dao;

import java.util.List;

import com.ehr.spring.model.Group;
import com.ehr.spring.model.Login;
import com.ehr.spring.model.Person;

public interface GroupDAO {
	
	public void createGroup(Group p);
	public void updateGroup(Group p);

	public void deleteGroup(int id);
	public List<Group> listGroups();
	public Group getGroupById(int id);

}
