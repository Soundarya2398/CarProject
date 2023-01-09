package com.te.employee1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;


import com.te.employee1.dto.Employee1;
@Repository
public class Employee1daoImplimentation implements Employee1dao {

	@Override
	public Employee1 getEmployee(int empid) {
		
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		Employee1 employee1 = null;

		try {
			factory = Persistence.createEntityManagerFactory("rest");
			manager = factory.createEntityManager();

			employee1 = manager.find(Employee1.class, empid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (factory != null)
				factory.close();
			if (manager != null)
				manager.close();
		}
		if (employee1 != null) {
			return employee1;
		}
		return null;
	}

	@Override
	public boolean deleteEmployeeDetail(int empid) {
		
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("rest");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = null;
			Employee1 employee = manager.find(Employee1.class, empid);

			if (employee != null) {
				try {
					transaction = manager.getTransaction();
					transaction.begin();
					manager.remove(employee);
					transaction.commit();
				} catch (Exception e) {
					if (transaction != null)
						transaction.rollback();
				} finally {
					if (factory != null)
						factory.close();
					if (manager != null)
						manager.close();
				}
				return true;
			}
			return false;
		}

	@Override
	public boolean update(int empid) {
		EntityTransaction transaction=null;
	
		
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("rest");
		EntityManager manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		Employee1 employee=manager.find(Employee1.class, empid);
		
		if(employee!=null) {
			transaction.begin();
		//employee.setEmpid(employee.getEmpid());
		employee.setEname(employee.getEname());
		employee.setDob(employee.getDob());
		employee.setPassword(employee.getPassword());
		transaction.commit();
		return true;
		}
		
		else {
			return false;
		}
		
		
		
	}
	}

	


