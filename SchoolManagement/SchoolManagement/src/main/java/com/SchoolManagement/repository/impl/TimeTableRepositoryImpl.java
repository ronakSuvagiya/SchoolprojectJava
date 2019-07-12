package com.SchoolManagement.repository.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SchoolManagement.dao.TimeTableDao;
import com.SchoolManagement.enitiy.TimeTableMaster;
import com.SchoolManagement.repository.TimeTableRepository;

@Service
public class TimeTableRepositoryImpl implements TimeTableRepository {

  @Autowired
  TimeTableDao timeTableDao;

  @Transactional
  @Override
  public void setTimeTable(TimeTableMaster timeTableMaster) {
    // TODO Auto-generated method stub
    timeTableDao.save(timeTableMaster);
  }

}
