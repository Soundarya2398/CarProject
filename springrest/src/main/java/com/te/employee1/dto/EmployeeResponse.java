package com.te.employee1.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeResponse implements Serializable {
	
	private int status;
	private String msg;
	private String description;
	
	private Employee1 bean;
	

}
