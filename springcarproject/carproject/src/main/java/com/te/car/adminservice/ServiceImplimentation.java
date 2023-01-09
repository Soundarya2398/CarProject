package com.te.car.adminservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.car.admindao.AdmindaoInterface;
import com.te.car.admindto.Admin;
import com.te.car.cardto.Car;


@Service
public class ServiceImplimentation implements AdminServiceInterface {
	@Autowired
	private AdmindaoInterface dao;

	@Override
	public Admin validate(int id, String password) {
		if (id > 0) {
			return dao.validate(id, password);
	}
else {
		return null;
	}
	}

	@Override
	public List<Car> all() {
		
		return dao.all();
	}

	@Override
	public List<Car> allDetails(String string) {
		
		return dao.allDetails(string);
	}

	@Override
	public boolean add(Car car) {
		if(car.getId()>=0) {
			return dao.add(car);
		}else {
		return false;
		}
	}

	@Override
	public boolean deleteCar(int id) {
		if(id>=0) {
			return dao.deleteCar(id);
		}
		return false;
	}

	@Override
	public Car searchcar(int id) {
		if (id > 0) {
			return dao.searchcar(id);
		}else {
		return null;
	}
	}

	@Override
	public boolean updateCar(Car car) {
		if(car.getId()<=0) {
		return false;
	}else {
		return dao.updateCar(car);
	}
		
}
}

