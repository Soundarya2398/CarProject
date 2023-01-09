package com.te.employee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.employee.dto.Employee;
import com.te.employee.service.EmployeeService;

@Controller

public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/login")
	public String getLoginPage() {
		return "loginForm";
	}

	@PostMapping("/login")
	public String getHomePage(ModelMap map, int empId, String password, HttpServletRequest request) {
		Employee employee = empService.validate(empId, password);
		if (employee != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedIn", employee);
			map.addAttribute("msg", employee.getName());
			return "homePage";
		} else {
			map.addAttribute("errMsg", "Invalid credentials!!!");
			return "loginForm";
		}
	}

	@GetMapping("/search")
	public String getSearchPage(@SessionAttribute(name = "loggedIn", required = false) Employee employee,
			ModelMap map) {
		if (employee != null) {
			return "searchPage";
		} else {
			map.addAttribute("errMsg", "Please Login First.");
			return "loginForm";
		}
	}

	@PostMapping("/search")
	public String getEmployeeDetailPage(ModelMap map, int empId,
			@SessionAttribute(name = "loggedIn", required = false) Employee employeeSession) {
		if (employeeSession != null) {
			Employee employee = empService.getEmployeeDetail(empId);
			if (employee != null) {
				map.addAttribute("employee", employee);
			} else {
				map.addAttribute("errMsg", "Record Not Found");
			}
			return "searchFormPage";
		} else {
			map.addAttribute("errMsg", "Please log in first.");
			return "loginForm";
		}
	}

	@GetMapping("/delete")
	public String getDeletePage(@SessionAttribute(name = "loggedIn", required = false) Employee employeeSession,
			ModelMap map) {

		if (employeeSession != null) {
			return "deleteFormPage";
		} else {
			map.addAttribute("errMsg", "Please Login First.");
			return "loginForm";
		}
	}

	@PostMapping("/delete")
	public String deleteEmployeePage(ModelMap map, int empId,
			@SessionAttribute(name = "loggedIn", required = false) Employee employeeSession) {
		if (employeeSession != null) {
			boolean isDeleted = empService.deleteEmployeeDetail(empId);
			if (isDeleted) {
				map.addAttribute("delMsg", "Deleted Successfully!!");
			} else {
				map.addAttribute("delMsg", "Record not found.");
			}
			return "deleteFormPage";
		} else {
			map.addAttribute("errMsg", "Please log in first.");
			return "loginForm";
		}
	}

	@GetMapping("/update")
	public String getUpdatePage(ModelMap map,
			@SessionAttribute(name = "loggedIn", required = false) Employee employeeSession) {
		if (employeeSession != null) {
			return "updateFormPage";
		} else {
			map.addAttribute("errMsg", "Please Login First!!");
			return "loginForm";
		}
	}

	@PostMapping("/update")
	public String updateEmployeeDetail(ModelMap map, int empId, String name, String address, String password,
			@SessionAttribute(name = "loggedIn", required = false) Employee employeeSession) {
		if (employeeSession != null) {
			Employee employee = empService.updateEmployeeDetail(empId, name, address, password);
			if (employee != null) {
				map.addAttribute("employee", employee);
				return "updateFormPage";
			} else {
				map.addAttribute("errMsg", "Record Not Found");
				return "updateFormPage";
			}
		} else {
			map.addAttribute("errMsg", "Please Login First!!");
			return "loginForm";
		}

	}

	@GetMapping("/add")
	public String getAddPage(
			@SessionAttribute(name = "loggedIn", required = false) Employee employeeSession) {
		if (employeeSession != null) {
		
		return "addForm";
		}else {
			return "loginForm";
		}
	}

	@PostMapping("/add")
	public String addEmployee(
			@SessionAttribute(name = "loggedIn", required = false) Employee employeeSession,Employee employee3,ModelMap map) {
		if (employeeSession!= null) {
			boolean b = empService.addEmployee(employee3);
			if (b == true) {
				map.addAttribute("errMsg", "sucessfully added");
				return "addForm";
			} else {
				map.addAttribute("errMsg", "ERORR! WHILE ADDING RECORD");
				return "addForm";
			}
		} else {

			return "loginForm";
		}

	}

	@GetMapping("/logout")
	public String getLogout(ModelMap map, HttpSession session) {
		session.invalidate();
		map.addAttribute("errMsg", "Logged Out !!!");
		return "loginForm";
	}

}
