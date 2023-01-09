package com.te.employee.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
//allows to handle exceptions across the whole application i.e., in different controller class also it can handle
public class ExceptionController {
	@ExceptionHandler(ExceptionClass.class)
	//it is used to handle the specific exception in the controller class
	public String handlerException(HttpServletRequest request,ExceptionClass exception) {
		request.setAttribute("errMsg", exception.getMessage());
		return "loginForm";
	}
	

}
