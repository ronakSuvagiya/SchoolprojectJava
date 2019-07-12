package com.SchoolManagement.repository;

import java.util.List;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.TeacherMaster;

public interface TeacherRepositoryInterface {

  public void addTeacher(TeacherMaster teacherMaster);

  public void updateTeacher(TeacherMaster teacherMaster);

  public void deleteTeacher(TeacherMaster teacherMaster);

  public List<TeacherMaster> selectTeacher(SchoolMaster school);


  public TeacherMaster findByTeacherid(Integer id);
}
