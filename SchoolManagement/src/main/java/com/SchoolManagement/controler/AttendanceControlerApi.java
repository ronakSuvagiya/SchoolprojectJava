package com.SchoolManagement.controler;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.SchoolManagement.common.ResponesDto;
import com.SchoolManagement.common.setResult;
import com.SchoolManagement.dao.AttendanceDao;
import com.SchoolManagement.dao.DivDio;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dao.imp.AttendnceDaoImpl;
import com.SchoolManagement.dto.AttendanceDto;
import com.SchoolManagement.enitiy.AttendanceMaster;
import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.service.AttendanceService;

@RestController
public class AttendanceControlerApi {

  @Autowired
  AttendanceService attendanceService;
  
  @Autowired
  DivDio divDao;
  
  @Autowired
  SchoolDao schooldao;
  
  @Autowired
  StdDio stdDao;
  
  @Autowired 
  AttendnceDaoImpl aDao;

  @RequestMapping("/addAttendance")
  public ResponseEntity<ResponesDto> addDiv(@RequestBody AttendanceDto attendanceDto) {

    attendanceService.addAttendance(attendanceDto);
    setResult result = new setResult();
    ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Add Attendance Successfully");
    return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
  }
  
  @RequestMapping("/getAttendance")
  public List<AttendanceMaster> atte(@RequestParam("div") Integer div, @RequestParam("std") Integer std, @RequestParam("school") Integer school,@RequestParam("startingDate")Date start,@RequestParam("endDate")Date end)
  {
	  DivMaster divMaster = divDao.findById(div).get();
	  StdMaster stdMaster = stdDao.findById(std).get();
	  SchoolMaster schoolMaster = schooldao.findById(school).get();
	  return aDao.findByDivAndSchoolAndStdAndDateBetween(divMaster, schoolMaster,stdMaster,start,end);
  }
}
