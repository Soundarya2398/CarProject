package com.te.employee.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.employee.Exception.ExceptionClass;
import com.te.employee.dto.Employee;

@Repository
public class EmployeeDaoImplimentation implements EmployeeDao {

	@Override
	public Employee validate(int id, String password) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		Employee employee = null;

		try {
			factory = Persistence.createEntityManagerFactory("spring");
			manager = factory.createEntityManager();

			employee = manager.find(Employee.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (factory != null)
				factory.close();
			if (manager != null)
				manager.close();
		}

		if (employee != null) {
			if (employee.getPassword().equals(password)) {
				return employee;
			} else {

				throw new ExceptionClass("invalid password");
			}
		}

		throw new ExceptionClass("Enter Valid id!!");
	}

	@Override
	public Employee getEmployeeDetail(int id) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		Employee employee = null;

		try {
			factory = Persistence.createEntityManagerFactory("spring");
			manager = factory.createEntityManager();

			employee = manager.find(Employee.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (factory != null)
				factory.close();
			if (manager != null)
				manager.close();
		}
		if (employee != null) {
			return employee;
		}
		return null;
	}

	@Override
	public boolean deleteEmployeeDetail(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("spring");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = null;
		Employee employee = manager.find(Employee.class, id);

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
	public Employee updateEmployeeDetail(int id, String name, String address, String password) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("spring");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = null;
		Employee employee = manager.find(Employee.class, id);

		if (employee != null) {
			try {
				transaction = manager.getTransaction();
				transaction.begin();
				employee.setName(name);
				employee.setAddress(address);
				employee.setPassword(password);
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
			return employee;
		}

		return null;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		boolean result = false;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("spring");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = null;

		if (employee != null) {
			try {
				transaction = manager.getTransaction();
				transaction.begin();
				manager.persist(employee);
				if (employee != null) {
					result = true;
				} else {
					result = false;
				}
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

		}

		return result;
	}
}
