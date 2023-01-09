package com.te.employee1.dao;

import com.te.employee1.dto.Employee1;

public interface Employee1dao {
 public Employee1 getEmployee(int empid);
 
 public boolean deleteEmployeeDetail(int empid);
 
 public boolean update(int empid);
}
