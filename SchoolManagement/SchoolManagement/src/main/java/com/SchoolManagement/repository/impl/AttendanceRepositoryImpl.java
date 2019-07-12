package com.SchoolManagement.repository.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.SchoolManagement.dao.AttendanceDao;
import com.SchoolManagement.enitiy.AttendanceMaster;
import com.SchoolManagement.repository.AttendanceRepositery;

@Repository
public class AttendanceRepositoryImpl implements AttendanceRepositery {

  @Autowired
  AttendanceDao att;


  @Transactional
  @Override
  public void addAttendance(AttendanceMaster attendanceMaster) {
    // TODO Auto-generated method stub
    att.save(attendanceMaster);
  }

}
