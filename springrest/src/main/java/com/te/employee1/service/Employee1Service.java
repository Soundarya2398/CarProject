package com.te.employee1.service;

import com.te.employee1.dto.Employee1;

public interface Employee1Service {
	public Employee1 getEmployee(int empid);
	
	public boolean deleteEmployeeDetail(int id);
	
	public boolean update(int empid);

}
