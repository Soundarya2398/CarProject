package com.te.employee1.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Entity
@Data
public class Employee1 implements Serializable{
	
	@Id
	private int empid;
	private String ename;
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date dob;
	private String password;

}
