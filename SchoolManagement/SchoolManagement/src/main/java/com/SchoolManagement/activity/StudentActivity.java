package com.SchoolManagement.activity;

import java.util.List;
import com.SchoolManagement.dto.StudentDto;
import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.enitiy.Student;

public interface StudentActivity {
  public void addStudent(StudentDto stDto);

  public void updateStudents(StudentDto student);

  public void deleteStudents(StudentDto student);

  public List<Student> selectStudent(Integer school);

  public Student findById(Integer id);
  
  public List<Student> findByStdAndDivId(Integer std,Integer div);
}
