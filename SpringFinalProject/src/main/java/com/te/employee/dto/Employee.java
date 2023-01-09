package com.te.employee.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Employee {




	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String password;
}
