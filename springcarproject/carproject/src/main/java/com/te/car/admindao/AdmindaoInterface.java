package com.te.car.admindao;

import java.util.List;

import com.te.car.admindto.Admin;
import com.te.car.cardto.Car;

public interface AdmindaoInterface {
	
	public Admin validate(int id, String password);
	
	public List<Car> all();
	
	public List<Car> allDetails(String string);
	
	public boolean add (Car car);
	
	public boolean deleteCar(int id);
	
	public Car searchcar(int id);
	
	public boolean updateCar(Car car);

}
