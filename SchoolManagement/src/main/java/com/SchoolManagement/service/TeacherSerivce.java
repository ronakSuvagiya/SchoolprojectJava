package com.SchoolManagement.service;

import java.util.List;
import com.SchoolManagement.dto.TeacherDto;
import com.SchoolManagement.enitiy.TeacherMaster;

public interface TeacherSerivce {

  public void addTeacher(TeacherDto teacherDto);

  public void updateTeacher(TeacherDto teacherDto);

  public void deleteTeacher(TeacherDto teacherDto);

  public List<TeacherMaster> selectStudents(Integer schoolId);

  public TeacherMaster findByTeacherid(Integer id);
}
