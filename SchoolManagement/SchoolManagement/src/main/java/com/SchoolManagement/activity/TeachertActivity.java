package com.SchoolManagement.activity;

import java.util.List;
import com.SchoolManagement.dto.TeacherDto;
import com.SchoolManagement.enitiy.TeacherMaster;


public interface TeachertActivity {

  public void addTeacher(TeacherDto teacherDto);

  public void updateTeacher(TeacherDto teacherDto);

  public void deleteTeacher(TeacherDto teacherDto);

  public TeacherMaster findByTeacherid(Integer id);

  public List<TeacherMaster> selectTeacher(Integer school);

}
