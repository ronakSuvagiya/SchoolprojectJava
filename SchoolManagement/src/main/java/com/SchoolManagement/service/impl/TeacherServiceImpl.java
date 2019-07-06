package com.SchoolManagement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SchoolManagement.activity.TeachertActivity;
import com.SchoolManagement.dto.TeacherDto;
import com.SchoolManagement.enitiy.TeacherMaster;
import com.SchoolManagement.service.TeacherSerivce;

@Service
public class TeacherServiceImpl implements TeacherSerivce {

  @Autowired
  TeachertActivity teacherActivity;


  @Override
  public void addTeacher(TeacherDto teacherDto) {
    // TODO Auto-generated method stub
    teacherActivity.addTeacher(teacherDto);

  }

  @Override
  public void updateTeacher(TeacherDto teacherDto) {
    // TODO Auto-generated method stub
    teacherActivity.updateTeacher(teacherDto);
  }

  @Override
  public void deleteTeacher(TeacherDto teacherDto) {
    // TODO Auto-generated method stub
    teacherActivity.deleteTeacher(teacherDto);
  }

  @Override
  public List<TeacherMaster> selectStudents(Integer schoolId) {
    // TODO Auto-generated method stub
    return teacherActivity.selectTeacher(schoolId);
  }

  @Override
  public TeacherMaster findByTeacherid(Integer id) {
    // TODO Auto-generated method stub
    return teacherActivity.findByTeacherid(id);
  }

}
