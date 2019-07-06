package com.SchoolManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SchoolManagement.dao.ParentDao;
import com.SchoolManagement.dao.StudentDio;
import com.SchoolManagement.dao.TeacherDio;
import com.SchoolManagement.enitiy.ParentMaster;
import com.SchoolManagement.enitiy.Student;
import com.SchoolManagement.enitiy.TeacherMaster;
import com.SchoolManagement.service.LoginApiService;

@Service
public class LogInApiServiceImpl implements LoginApiService {


  @Autowired
  TeacherDio teacher;

  @Autowired
  StudentDio student;

  @Autowired
  ParentDao parent;

  @Override
  public TeacherMaster TeacherloginApi(String username, String pass) {
    // TODO Auto-generated method stub
    System.out.println(username);
    System.out.println(pass);
    return teacher.findByUserNameIgnoreCaseAndPasswordIgnoreCase(username, pass);
  }

  @Override
  public Student studentLoginApi(String username, String pass) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ParentMaster PrentLoginApi(String username, String pass) {
    // TODO Auto-generated method stub
    return null;
  }

}
