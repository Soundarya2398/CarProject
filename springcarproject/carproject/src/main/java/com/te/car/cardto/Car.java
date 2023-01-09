package com.te.car.cardto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table
public class Car implements Serializable {
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String company;
	@Column
	private String fuel_type;
	@Column
	private String Break_System;
	@Column
	private double showroom_Price;
	@Column
	private double Onboard_price;
	@Column
	private String image_url;
	@Column
	private double mileage;
	@Column
	private int Seating_Capacity;
	@Column
	private int Engine_Capacity;
	@Column
	private String Gear_type;
	
	
	
	
	

}
