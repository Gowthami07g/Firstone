package com.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="newemployee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empNo;
	private String empName;
	private String city;
	private String phnoe;
	public Employee(int empNo, String empName, String city, String phnoe) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.city = city;
		this.phnoe = phnoe;
	}
	public Employee() {
		super();
		
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhnoe() {
		return phnoe;
	}
	public void setPhnoe(String phnoe) {
		this.phnoe = phnoe;
	}
	

}
