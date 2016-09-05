package com.ehr.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="FGA")
public class FGA {
@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
int groupId;
//@ManyToMany(fetch = FetchType.EAGER)
//private List columnNames; 
private String columnNames;
public String getColumnNames() {
	return columnNames;
}
public void setColumnNames(String columnNames) {
	this.columnNames = columnNames;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
//public List getColumnNames() {
//	return columnNames;
//}
//public void setColumnNames(List columnNames) {
//	this.columnNames = columnNames;
//}
//tring columnNames;
public int getGroupId() {
	return groupId;
}
public void setGroupId(int groupId) {
	this.groupId = groupId;
}

}
