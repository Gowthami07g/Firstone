package com.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeServiceIntf{

	@Autowired
	
	EmployeeDaoIntf dao;
	
	public void saveDetails(Employee emp) {
		
		dao.saveDetails(emp);
		
	}

	@Override
	public List<Employee> showlist() {
		
		return dao.showList();
	}

	@Override
	public void deleteById(int id) {
		
		dao.deleteById(id);
	}

	@Override
	public int editById(int id1) {
		
		return dao.editById(id1);
	}

	@Override
	public Employee update(Employee emp) {
		
		return dao.update(emp);
	}

}
