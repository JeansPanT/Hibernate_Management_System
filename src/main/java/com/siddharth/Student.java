package com.siddharth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Student Management System using Hibernate By @author JeansPanT!
 * @version 1.0
 */

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "Student_ID" )
	Integer id;
	@Column(name = "Student_Name",length = 50)
	String name;
	@Column(name = "Student_Age")
	Integer age;
	@Column(name = "Student_Percentage")
	Float per;
	@Column(name = "Student_Address",length = 100)
	String add;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Float getPer() {
		return per;
	}
	public void setPer(Float per) {
		this.per = per;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}

	
}
