package com.ehr.spring.service;

import java.util.List;

import com.ehr.spring.model.Group;
import com.ehr.spring.model.Login;

public interface GroupService {
	public void createGroup(Group p);
	public void updateGroup(Group p);

	public void deleteGroup(int id);
	public List<Group> listGroups();
	public Group getGroupById(int id);
}
