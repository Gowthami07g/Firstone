package com.controller;

import java.util.List;

public interface EmployeeServiceIntf {
	void saveDetails(Employee emp);

	List<Employee> showlist();

	void deleteById(int id);

	int editById(int id1);

	Employee update(Employee emp); 

}
