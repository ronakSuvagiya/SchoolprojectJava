package com.SchoolManagement.activity;

import com.SchoolManagement.dto.ExamTimeTableDto;
import com.SchoolManagement.dto.TimeTableDto;

public interface TimeTableActivity {
  public void addTimeTable(TimeTableDto timeTable);

  public void addTimeTableExam(ExamTimeTableDto examTimeTable);



}
