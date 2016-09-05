package com.ehr.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="PERSON")
public class Person {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String country;
	
	private String fatherName;
	private String motherName;
	private String gender;
	private String bloodType;
	private String dob;
	private String disease;
	private String symptoms;
	private String diagnosis;
	private String isUndergoneSurgery;
	private String tempAddress;
	public String getTempAddress() {
		return tempAddress;
	}

	public void setTempAddress(String tempAddress) {
		this.tempAddress = tempAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	private String permanentAddress;
	private String physician;
	private String isEyeSightProblem;
	private String leftEyePower;
	private String rightEyePower;
	private String isHandicapped;
	private String hasPolio;
	private String hasCancer;
	private String cancerType;
	private String hasDiabetis;
	private String hasBloodPressure;
	private String hasSTD;
	
	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getIsUndergoneSurgery() {
		return isUndergoneSurgery;
	}

	public void setIsUndergoneSurgery(String isUndergoneSurgery) {
		this.isUndergoneSurgery = isUndergoneSurgery;
	}


	public String getPhysician() {
		return physician;
	}

	public void setPhysician(String physician) {
		this.physician = physician;
	}

	

	public String getIsEyeSightProblem() {
		return isEyeSightProblem;
	}

	public void setIsEyeSightProblem(String isEyeSightProblem) {
		this.isEyeSightProblem = isEyeSightProblem;
	}

	public String getLeftEyePower() {
		return leftEyePower;
	}

	public void setLeftEyePower(String leftEyePower) {
		this.leftEyePower = leftEyePower;
	}

	public String getRightEyePower() {
		return rightEyePower;
	}

	public void setRightEyePower(String rightEyePower) {
		this.rightEyePower = rightEyePower;
	}

	public String getIsHandicapped() {
		return isHandicapped;
	}

	public void setIsHandicapped(String isHandicapped) {
		this.isHandicapped = isHandicapped;
	}

	public String getHasPolio() {
		return hasPolio;
	}

	public void setHasPolio(String hasPolio) {
		this.hasPolio = hasPolio;
	}

	public String getHasCancer() {
		return hasCancer;
	}

	public void setHasCancer(String hasCancer) {
		this.hasCancer = hasCancer;
	}

	public String getCancerType() {
		return cancerType;
	}

	public void setCancerType(String cancerType) {
		this.cancerType = cancerType;
	}

	public String getHasDiabetis() {
		return hasDiabetis;
	}

	public void setHasDiabetis(String hasDiabetis) {
		this.hasDiabetis = hasDiabetis;
	}

	public String getHasBloodPressure() {
		return hasBloodPressure;
	}

	public void setHasBloodPressure(String hasBloodPressure) {
		this.hasBloodPressure = hasBloodPressure;
	}

	public String getHasSTD() {
		return hasSTD;
	}

	public void setHasSTD(String hasSTD) {
		this.hasSTD = hasSTD;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString(){
		return "id="+id+", name="+name+", country="+country;
	}
}
