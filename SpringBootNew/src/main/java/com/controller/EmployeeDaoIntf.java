package com.controller;

import java.util.List;

public interface EmployeeDaoIntf {
	public void saveDetails(Employee emp);

	public List<Employee> showList();

	public void deleteById(int id);

	public int editById(int id1);

	public Employee update(Employee emp);

}
