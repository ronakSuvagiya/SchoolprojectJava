package com.SchoolManagement.repository;

import java.util.List;

import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.enitiy.Student;

public interface StudentRepositoryInterface {
  public void addStudents(Student student);

  public void updateStudents(Student student);

  public void deleteStudents(Student student);

  public List<Student> selectStudent(SchoolMaster school);

  public Student findById(Integer id);
  
  public List<Student> findByStdAndDivId(StdMaster std,DivMaster div);
}
