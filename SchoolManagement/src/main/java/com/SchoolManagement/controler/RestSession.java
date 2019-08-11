package com.SchoolManagement.controler;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.SchoolManagement.ApiUri.SessionUri;

@ControllerAdvice(annotations = Controller.class)
@Order(2)
public class RestSession {

	@ModelAttribute
	public void myMethod(ServletRequest req, HttpServletResponse res) {
		HttpServletRequest request = (HttpServletRequest) req;
		String url = request.getServletPath();
	
		if (!url.equals("/login") & !url.equals("/addAttendance") & !url.equals("/getAttendance")
				& !url.equals("/addDiv") & !url.equals("/findByStd") & !url.equals("/findByStdID")
				& !url.equals("/Teacherlogin") & !url.equals("/studentLogin") & !url.equals("/PrentLogin")
				& !url.equals("/addParent") & !url.equals("/updateParent") & !url.equals("/deleteParent")
				& !url.equals("/selectParent") & !url.equals("/findByParentid") & !url.equals("/findByStudents")
				& !url.equals("/login") & !url.equals("/getRecpit") & !url.equals("/addStudent")
				& !url.equals("/updateStudent") & !url.equals("/deleteStudent") & !url.equals("/selectStudent")
				& !url.equals("/findByStudentid") & !url.equals("/findByStdAndDiv") & !url.equals("/addTeacher")
				& !url.equals("/updateTeacher") & !url.equals("/deleteTeacher") & !url.equals("/selectTeacher")
				& !url.equals("/findByTeacherid") & !url.equals("/setTimeTable") & !url.equals("/setExamTimeTable")  & !url.equals("/loginData") & !url.equals("/finstdBySchoolId")
				& !url.equals("/findByStdAndDivAndSchool") & !url.toLowerCase().contains("api") &!url.equals("/addTokenApi")) {
			if (request.getSession() != null && request.getSession().getAttribute(SessionUri.SchoolId) != null) {
				System.out.println(request.getSession().getAttribute(SessionUri.SchoolId));
			} else {
				System.out.println("notlogin");
				try {
					res.sendRedirect("/login");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
