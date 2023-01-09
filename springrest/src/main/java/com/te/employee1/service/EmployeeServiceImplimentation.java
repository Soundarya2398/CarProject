package com.te.employee1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.employee1.dao.Employee1dao;
import com.te.employee1.dto.Employee1;
@Service
public class EmployeeServiceImplimentation implements Employee1Service{
	@Autowired
private Employee1dao dao;
	@Override
	public Employee1 getEmployee(int empid) {
		if (empid > 0)
			return dao.getEmployee(empid);

		return null;
	}
	@Override
	public boolean deleteEmployeeDetail(int empid) {
		if (empid > 0) {
			return dao.deleteEmployeeDetail(empid);
		}
		return false;
	}
	@Override
	public boolean update(int empid) {
		if(empid>0) {
			return dao.update(empid);
		}
		return false;
	}

	
	
}
