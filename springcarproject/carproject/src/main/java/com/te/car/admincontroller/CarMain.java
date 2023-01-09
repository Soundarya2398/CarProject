package com.te.car.admincontroller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.car.cardto.Car;

public class CarMain {

	public static void main(String[] args) {
		EntityTransaction transaction=null;
		Car car=new Car();
		car.setId(100);
		car.setName("hyundai");
		car.setCompany("honda");
		car.setBreak_System("automatic");
		car.setEngine_Capacity(12);
		car.setFuel_type("petrol");
		car.setGear_type("gear");
		car.setImage_url(null);
		car.setMileage(16.0);
		car.setOnboard_price(789063);
		car.setShowroom_Price(8000);
		car.setSeating_Capacity(6);
		
		try {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("car");
			EntityManager manager=factory.createEntityManager();
			transaction=manager.getTransaction();
			transaction.begin();
			manager.persist(car);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}

}
