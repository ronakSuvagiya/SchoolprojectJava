package com.SchoolManagement.controlerMVC;



import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations=RestController.class)
public class SessionCheck {
	
	@ModelAttribute
	public void myMethod(ServletRequest req, HttpServletResponse res) {
			System.out.println("check");
	}

}
