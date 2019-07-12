package com.SchoolManagement.controlerMVC;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.SchoolManagement.ApiUri.ApiUrl;
import com.SchoolManagement.ApiUri.SessionUri;
import com.SchoolManagement.common.ResponesDto;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dto.AttendanceDto;
import com.SchoolManagement.dto.StudentDto;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.service.StudentSerivce;

@Controller
public class AttendanceController {

	@Autowired
	StdDio stdDio;

	@Autowired
	SchoolDao schoolDao;
	
	@Autowired
	StudentSerivce studentSerivce;
	
	@RequestMapping("/add_attendance")
	public ModelAndView attendance(HttpServletRequest request)
	{
		ModelAndView model = new ModelAndView("add_attendance");
		model.addObject("school", (Integer) request.getSession().getAttribute(SessionUri.SchoolId));
		List<StdMaster> std = stdDio.findBySchool(
				schoolDao.findById((Integer) request.getSession().getAttribute(SessionUri.SchoolId)).get());
		model.addObject("StdName", std);
		return model;
	}
	
	@RequestMapping("/Attendance")
	public ModelAndView addAttendance(HttpServletRequest request,@RequestParam("collectionDate") Date date, @RequestParam("rollno") String number, @RequestParam("std") Integer stdId,@RequestParam("div") Integer divId)
	{
		ModelAndView model = new ModelAndView();
		model=attendance(request);
		System.out.println(number);
		AttendanceDto att = new AttendanceDto();
		att.setDate(date);
		att.setDiv(divId);
		att.setRollNo(number);
		att.setStd(stdId);
		att.setSchool((Integer) request.getSession().getAttribute(SessionUri.SchoolId));
		
		RestTemplate resttemp = new RestTemplate();
	    HttpEntity<AttendanceDto> httpEntity = new HttpEntity<AttendanceDto>(att);
	    ResponseEntity<ResponesDto> responseEntity =
	        resttemp.postForEntity(ApiUrl.ADDATT, httpEntity, ResponesDto.class);

	    System.out.println("==>" + responseEntity);
	    if (responseEntity.getStatusCode() == HttpStatus.OK) {
	      ResponesDto repoDto = responseEntity.getBody();
	      System.out.println("11");
	      model.addObject("msg", repoDto);
	    }
	    
		
		return model;
	}
}
