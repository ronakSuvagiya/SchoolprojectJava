package com.SchoolManagement.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.SchoolManagement.enitiy.AttendanceMaster;
import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.StdMaster;

public interface AttendanceDao extends CrudRepository<AttendanceMaster, Integer> {


}
