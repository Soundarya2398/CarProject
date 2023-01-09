package com.te.car.admindao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.car.Exception.ExceptionClass;
import com.te.car.admindto.Admin;
import com.te.car.cardto.Car;




@Repository
public class DaoImplimentation implements AdmindaoInterface {

	@Override
	public Admin validate(int id, String password) {
		
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		Admin admin = null;

		try {
			factory = Persistence.createEntityManagerFactory("car");
			manager = factory.createEntityManager();

			admin = manager.find(Admin.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (factory != null)
				factory.close();
			if (manager != null)
				manager.close();
		}

		if (admin != null) {
			if (admin.getPassword().equals(password)) {
				return admin;
			} else {

				throw new ExceptionClass("invalid password");
			}
		}

		throw new ExceptionClass("Enter Valid id!!");
	}

	@Override
	public List<Car> all() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("car");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			String readAll="from Car";
			Query query=manager.createQuery(readAll);
			List<Car> cars=query.getResultList();
				
			
			
			transaction.commit();
			
			return cars;
			
		
		
		
	}

	@Override
	public List<Car> allDetails(String string) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("car");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			String readAll="from Car where name like :name1 or company like:company1 or fuel_type like:fuel";
			Query query=manager.createQuery(readAll);
			query.setParameter("name1",string+"%");
			query.setParameter("company1",string+"%");
			query.setParameter("fuel",string+"%");
			List<Car> cars=query.getResultList();
			System.out.println(cars);
			transaction.commit();
			return cars;
			
			
            
		

	}

	@Override
	public boolean add(Car car) {
	String fueltype=car.getFuel_type();
	if(fueltype.equals("electric")) {
		double showroomprice=car.getShowroom_Price();
		System.out.println(showroomprice);
		double onboard=showroomprice+(0.04*showroomprice);
		System.out.println(onboard);
		car.setOnboard_price(onboard);
	}else {
		double showroomprice=car.getShowroom_Price();
		if(showroomprice<500000) {
			double onroad=showroomprice+(0.13*showroomprice);
			car.setOnboard_price(onroad);
		}else if(showroomprice>500000 && showroomprice<1000000) {
			double onroad=showroomprice+(0.14*showroomprice);
			car.setOnboard_price(onroad);
		}else if(showroomprice>1000000 && showroomprice<2000000) {
			double onroad=showroomprice+(0.17*showroomprice);
			car.setOnboard_price(onroad);
		}else if(showroomprice>2000000) {
			double onroad=showroomprice+(0.18*showroomprice);
			car.setOnboard_price(onroad);
		}
	}
	boolean result=false;
	
	EntityTransaction transaction=null;
	
	
	try {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("car");
		EntityManager manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(car);
		if(car!=null) {
			result=true;
		}else {
			result=false;
		}
		transaction.commit();
		
	} catch (Exception e) {
		if(transaction!=null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}
	return result;
	
	}

	@Override
	public boolean deleteCar(int id) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("car");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = null;
		Car car= manager.find(Car.class, id);

		if (car != null) {
			try {
				transaction = manager.getTransaction();
				transaction.begin();
				manager.remove(car);
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
	public Car searchcar(int id) {
		
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		Car car = null;

		try {
			factory = Persistence.createEntityManagerFactory("car");
			manager = factory.createEntityManager();

			car = manager.find(Car.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (factory != null)
				factory.close();
			if (manager != null)
				manager.close();
		}
		if (car != null) {
			return car;
		}
		return null;
	}

	@Override
	public boolean updateCar(Car car) {
		EntityTransaction transaction=null;
		
		
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("car");
			EntityManager manager=factory.createEntityManager();
			transaction=manager.getTransaction();
			transaction.begin();
			Car car1=manager.find(Car.class, car.getId());
			if(car1!=null) {
			car1.setId(car.getId());
			car1.setName(car.getName());
			car1.setCompany(car.getCompany());
			car1.setBreak_System(car.getBreak_System());
			car1.setEngine_Capacity(car.getEngine_Capacity());
			car1.setFuel_type(car.getFuel_type());
			car1.setGear_type(car.getGear_type());
			car1.setImage_url(car.getImage_url());
			car1.setMileage(car.getMileage());
			car1.setOnboard_price(car.getOnboard_price());
			car1.setShowroom_Price(car.getShowroom_Price());
			car1.setSeating_Capacity(car.getSeating_Capacity());
			
			String fueltype=car.getFuel_type();
			if(fueltype.equals("electric")) {
				double showroomprice=car.getShowroom_Price();
				System.out.println(showroomprice);
				double onboard=showroomprice+(0.04*showroomprice);
				System.out.println(onboard);
				car.setOnboard_price(onboard);
			}else {
				double showroomprice=car.getShowroom_Price();
				if(showroomprice<500000) {
					double onroad=showroomprice+(0.13*showroomprice);
					car.setOnboard_price(onroad);
				}else if(showroomprice>500000 && showroomprice<1000000) {
					double onroad=showroomprice+(0.14*showroomprice);
					car.setOnboard_price(onroad);
				}else if(showroomprice>1000000 && showroomprice<2000000) {
					double onroad=showroomprice+(0.17*showroomprice);
					car.setOnboard_price(onroad);
				}else if(showroomprice>2000000) {
					double onroad=showroomprice+(0.18*showroomprice);
					car.setOnboard_price(onroad);
				}
			}
			transaction.commit();
			return true;
		} else{
			transaction.commit();
			return false;
		}
		}
}
	
			
	

		

	


