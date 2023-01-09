package com.te.car.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(ExceptionClass.class)
	public String handlerException(HttpServletRequest request,ExceptionClass exception) {
		request.setAttribute("errMsg", exception.getMessage());
		return "loginForm";
	}
	
}
