package com.SchoolManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SchoolManagement.activity.AttendanceActivity;
import com.SchoolManagement.dto.AttendanceDto;
import com.SchoolManagement.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

  @Autowired
  AttendanceActivity attendanceActivity;

  @Override
  public void addAttendance(AttendanceDto atDto) {
    // TODO Auto-generated method stub
    attendanceActivity.addAttendance(atDto);
  }

}
