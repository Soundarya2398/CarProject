package com.te.car.admindto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity

public class Admin implements Serializable{
	@Id
	@Column
	private int aid;
	@Column
	private String admin_name;
	@Column
	private String password;
	

}
