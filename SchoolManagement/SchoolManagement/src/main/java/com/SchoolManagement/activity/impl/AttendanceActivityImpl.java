package com.SchoolManagement.activity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SchoolManagement.activity.AttendanceActivity;
import com.SchoolManagement.dao.DivDio;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dto.AttendanceDto;
import com.SchoolManagement.enitiy.AttendanceMaster;
import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.repository.AttendanceRepositery;

@Service
public class AttendanceActivityImpl implements AttendanceActivity {

  @Autowired
  AttendanceRepositery attendanceRepo;

  @Autowired
  SchoolDao schoolDao;

  @Autowired
  DivDio divDio;

  @Autowired
  StdDio stdDio;

  @Override
  public void addAttendance(AttendanceDto attendanceDto) {
    // TODO Auto-generated method stub
    AttendanceMaster aMaster = new AttendanceMaster();
    aMaster = dtoToEntity(attendanceDto, aMaster);
    attendanceRepo.addAttendance(aMaster);
  }

  public AttendanceMaster dtoToEntity(AttendanceDto aDto, AttendanceMaster attendanceMaster) {
    attendanceMaster.setDate(aDto.getDate());
    attendanceMaster.setRollNo(aDto.getRollNo());
    SchoolMaster acMaster = schoolDao.findById(aDto.getSchool()).get();

    attendanceMaster.setSchool(acMaster);
    DivMaster divMaster = divDio.findById(aDto.getDiv()).get();
    attendanceMaster.setDiv(divMaster);

    StdMaster stdMaster = stdDio.findById(aDto.getStd()).get();
    attendanceMaster.setStd(stdMaster);
    return attendanceMaster;
  }
}
