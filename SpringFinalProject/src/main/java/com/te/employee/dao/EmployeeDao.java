package com.te.employee.dao;
import com.te.employee.dto.Employee;
public interface EmployeeDao {
	
	

	
		
		public Employee validate(int id, String password);
		
		public Employee getEmployeeDetail(int id);
		
		public boolean deleteEmployeeDetail(int id);
		
		public Employee updateEmployeeDetail(int id,String name, String address, String password);
	  
		public boolean addEmployee(Employee employee);

}



