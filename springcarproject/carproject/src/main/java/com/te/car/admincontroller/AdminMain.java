package com.te.car.admincontroller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.car.admindto.Admin;

public class AdminMain {

	public static void main(String[] args) {
		Admin admin=new Admin();
		admin.setAdmin_name("guru");
		admin.setAid(10);
		admin.setPassword("g@12");
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("car");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		

	}

}
