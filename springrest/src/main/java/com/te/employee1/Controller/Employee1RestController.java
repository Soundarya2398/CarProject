package com.te.employee1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.employee1.dto.Employee1;
import com.te.employee1.dto.EmployeeResponse;
import com.te.employee1.service.Employee1Service;
@RestController
public class Employee1RestController {
	@Autowired
	private Employee1Service service;
	
	@GetMapping(path="/getdetails",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Employee1 empDetails(int empid) {
		return service.getEmployee(empid);
		
	}
	@GetMapping(path="/getEmp",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse getempDetails(int empid) {
		EmployeeResponse response=new EmployeeResponse();
		boolean bean=service.deleteEmployeeDetail(empid);
		if(bean==true) {
			response.setStatus(200);
			response.setMsg("success");
			response.setDescription("data found for id"+empid);
			//response.setBean(bean)	;
			}else {
				response.setStatus(400);
				response.setMsg("failure");
				response.setDescription("something went wrong");
			}
		return response;
		
			
		}
	@GetMapping(path="/update",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public boolean updatedetails(int empid) {
		return service.update(empid);
		
	}

	
		
	}


