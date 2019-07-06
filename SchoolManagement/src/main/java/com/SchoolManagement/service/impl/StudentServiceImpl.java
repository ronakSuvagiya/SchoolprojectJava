package com.SchoolManagement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SchoolManagement.activity.StudentActivity;
import com.SchoolManagement.dto.StudentDto;
import com.SchoolManagement.enitiy.Student;
import com.SchoolManagement.service.StudentSerivce;

@Service
public class StudentServiceImpl implements StudentSerivce {

  @Autowired
  StudentActivity studentActivity;

  @Override
  public void addStudent(StudentDto studentDto) {
    // TODO Auto-generated method stub
    studentActivity.addStudent(studentDto);

  }

  @Override
  public void updateStudents(StudentDto student) {
    // TODO Auto-generated method stub
    studentActivity.updateStudents(student);

  }

  @Override
  public void deleteStudents(StudentDto student) {
    // TODO Auto-generated method stub
    studentActivity.deleteStudents(student);
  }

  @Override
  public List<Student> selectStudent(Integer school) {
    // TODO Auto-generated method stub
    return studentActivity.selectStudent(school);
  }

  @Override
  public Student findById(Integer id) {
    // TODO Auto-generated method stub
    return studentActivity.findById(id);
  }

@Override
public List<Student> findByStdAndDivId(Integer std, Integer div) {
	// TODO Auto-generated method stub
	return studentActivity.findByStdAndDivId(std, div);
}

}
