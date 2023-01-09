package com.te.car.admincontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.car.admindto.Admin;
import com.te.car.adminservice.AdminServiceInterface;
import com.te.car.cardto.Car;





@Controller
public class AdminController {
	
	@Autowired
	private AdminServiceInterface adminservice;
	
	@GetMapping("/Admin")
	public String getLoginPage() {
		return "AdminUser";
	}
	
	@GetMapping("/login")
	public String getAdminPage() {
		return "LoginForm";
	}
	
	@GetMapping("/userpage")
	public String getUserPage() {
		return "UserPage";
	}
	
	@PostMapping("/login")
	public String getHomePage(ModelMap map, int id, String password, HttpServletRequest request) {
		Admin admin = adminservice.validate(id, password);
		if (admin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedIn", admin);
			map.addAttribute("msg", admin.getAdmin_name());
			return "homePage";
		} else {
			map.addAttribute("errMsg", "Invalid credentials!!!");
			return "loginForm";
		}
	}
 
	@GetMapping("/add")
	public String add(Admin admin) {
		if(admin!=null) {
		return "Insert";
		}else {
		return "loginForm";
		}
	}
	
	@PostMapping("/add")
	public String addDetails(Admin admin,ModelMap map,Car car) {
		if(admin!=null) {
			Boolean car1=adminservice.add(car);
			if(car1==true) {
				map.addAttribute("msg","added Successfully");
				return "Insert";
			}else {
				map.addAttribute("errMsg","Something went Wrong");
				return "Insert";
			}
		}
		else {
			map.addAttribute("errMsg","Invalid Creditionls!!");
			return "LoginForm";
		}
	}
	
	
	
	@GetMapping("/update")
	public String updateDetails(@SessionAttribute(name = "loggedIn", required = false) Admin adminSession) {
		if(adminSession!=null) {
		return "Modify";
		}else {
			return "LoginForm";
		}
	}
	@PostMapping("/update")
	public String updateCarDetails(@SessionAttribute(name = "loggedIn", required = false) Admin adminSession,Car car,ModelMap map) {
		if(adminSession!=null) {
			Boolean car1=adminservice.updateCar(car);
			if(car1==true) {
				map.addAttribute("msg","updated Successfully");
				return "Modify";
			}else {
				map.addAttribute("errMsg","Something went Wrong");
				return "Modify";
			}
		}
		else {
			map.addAttribute("errMsg","Invalid Creditionls!!");
			return "LoginForm";
			
		}
	}
	
	@GetMapping("/delete")
	public String DeleteDetails(@SessionAttribute(name = "loggedIn", required = false) Admin adminSession,ModelMap map) {
		if (adminSession != null) {
			return "Delete";
		} else {
			map.addAttribute("errMsg", "Please Login First.");
			return "LoginForm";
		}
	}
	
	@PostMapping("/delete")
	public String DeleteDetails(@SessionAttribute(name = "loggedIn", required = false) Admin adminSession,ModelMap map,int id) {
		if (adminSession != null) {
			boolean isDeleted = adminservice.deleteCar(id);
			if (isDeleted==true) {
				map.addAttribute("del", "Deleted Successfully!!");
			} else {
				map.addAttribute("delMsg", "Record not found.");
			}
			return "Delete";
		} else {
			map.addAttribute("errMsg", "Please log in first.");
			return "LoginForm";
		}
		
	}
	@GetMapping("/search")
	public String SearchDetails(@SessionAttribute(name = "loggedIn", required = false) Admin admin,
			ModelMap map) {
		if (admin != null) {
			return "Search";
		} else {
			map.addAttribute("errMsg", "Please Login First.");
			return "LoginForm";
		}
		
	}
	
	@PostMapping("/search")
	public String SearchCarDetails(ModelMap map, int id,
			@SessionAttribute(name = "loggedIn", required = false) Admin adminSession) {
		if (adminSession != null) {
			Car car = adminservice.searchcar(id);
			if (car != null) {
				map.addAttribute("car", car);
			} else {
				map.addAttribute("errMsg", "Record Not Found");
			}
			return "Search";
		} else {
			map.addAttribute("errMsg", "Please log in first.");
			return "LoginForm";
		}
		
	}
	@GetMapping("/seeAll")
	public String seeall(Admin admin,ModelMap map) {
		if(admin!=null) {
			List<Car> cars=adminservice.all();
			map.addAttribute("msg",cars);
			return "SeeAll";
		}else {
			return "LoginForm";
		}
	}
	
	@GetMapping("/alldetails")
	public String userFetschingCarDetails(String string,ModelMap map) {
		System.out.println(string);
		
		List<Car> list=adminservice.allDetails(string);
		map.addAttribute("msg", list);
		System.out.println(list);
		return "AllDetails";
	}
	@GetMapping("/logout")
	public String Logout() {
		return "AdminUser";
	}
	
}
