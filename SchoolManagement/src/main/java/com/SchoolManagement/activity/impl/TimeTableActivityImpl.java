package com.SchoolManagement.activity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SchoolManagement.activity.TimeTableActivity;
import com.SchoolManagement.dao.DivDio;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dto.ExamTimeTableDto;
import com.SchoolManagement.dto.TimeTableDto;
import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.enitiy.TimeTableMaster;
import com.SchoolManagement.repository.TimeTableRepository;

@Service
public class TimeTableActivityImpl implements TimeTableActivity {

  @Autowired
  TimeTableRepository timeTableRepo;

  @Autowired
  DivDio divDio;

  @Autowired
  StdDio stdDio;

  @Autowired
  SchoolDao schoolDao;

  @Override
  public void addTimeTable(TimeTableDto timeTableDto) {
    // TODO Auto-generated method stub
    TimeTableMaster timeTableMaster = new TimeTableMaster();
    timeTableMaster = dtoToEnitiy(timeTableDto, timeTableMaster);
    timeTableRepo.setTimeTable(timeTableMaster);
  }

  public TimeTableMaster dtoToEnitiy(TimeTableDto timeTableDto, TimeTableMaster timeTableMaster) {
    DivMaster div = divDio.findById(timeTableDto.getDiv_id()).get();
    timeTableMaster.setDiv(div);

    StdMaster std = stdDio.findById(timeTableDto.getStd_id()).get();
    timeTableMaster.setStd(std);

    SchoolMaster school = schoolDao.findById(timeTableDto.getSchool_id()).get();
    timeTableMaster.setSchool(school);

    timeTableMaster.setPdfName(timeTableDto.getStd_id() + "" + timeTableDto.getDiv_id() + ""
        + timeTableDto.getSchool_id() + ".pdf");

    timeTableMaster.setType(0);
    return timeTableMaster;
  }

  @Override
  public void addTimeTableExam(ExamTimeTableDto examTimeTable) {
    // TODO Auto-generated method stub
    TimeTableMaster timeTableMaster = new TimeTableMaster();
    timeTableMaster = dtoToEnitiyExam(examTimeTable, timeTableMaster);
    timeTableRepo.setTimeTable(timeTableMaster);
  }

  public TimeTableMaster dtoToEnitiyExam(ExamTimeTableDto examTimeTable,
      TimeTableMaster timeTableMaster) {

    StdMaster std = stdDio.findById(examTimeTable.getStd_id()).get();
    timeTableMaster.setStd(std);

    SchoolMaster school = schoolDao.findById(examTimeTable.getSchool_id()).get();
    timeTableMaster.setSchool(school);

    timeTableMaster
        .setPdfName(examTimeTable.getStd_id() + "" + examTimeTable.getSchool_id() + ".pdf");

    timeTableMaster.setType(1);
    return timeTableMaster;
  }
}
