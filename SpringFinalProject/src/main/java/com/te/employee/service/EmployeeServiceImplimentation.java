package com.te.employee.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.employee.dao.EmployeeDao;
import com.te.employee.dto.Employee;


@Service
public class EmployeeServiceImplimentation implements EmployeeService{
	
	
	
		@Autowired
		private EmployeeDao dao;

		@Override
		public Employee validate(int id, String password) {
			if (id > 0)
				return dao.validate(id, password);
			return null;
		}

		@Override
		public Employee getEmployeeDetail(int id) {
			if (id > 0)
				return dao.getEmployeeDetail(id);
			return null;
		}

		@Override
		public boolean deleteEmployeeDetail(int id) {
			if (id > 0) {
				return dao.deleteEmployeeDetail(id);
			}
			return false;
		}

		@Override
		public Employee updateEmployeeDetail(int id, String name, String address, String password) {
			if (id > 0) {
				return dao.updateEmployeeDetail(id, name, address, password);
			}
			return null;
		}

		@Override
		public boolean addEmployee(Employee employee) {
			if(employee.getId()>0) {
				return dao.addEmployee(employee);
			}
			return false;
		}

		
		
			
		

	}



