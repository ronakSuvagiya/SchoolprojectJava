package com.SchoolManagement.service;

import com.SchoolManagement.enitiy.ParentMaster;
import com.SchoolManagement.enitiy.Student;
import com.SchoolManagement.enitiy.TeacherMaster;

public interface LoginApiService {

  public TeacherMaster TeacherloginApi(String username, String pass);

  public Student studentLoginApi(String username, String pass);

  public ParentMaster PrentLoginApi(String username, String pass);

}
