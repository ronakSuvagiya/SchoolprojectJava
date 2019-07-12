package com.SchoolManagement.repository.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.SchoolManagement.dao.StudentDio;
import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.enitiy.Student;
import com.SchoolManagement.repository.StudentRepositoryInterface;

@Repository
public class StudentRepository implements StudentRepositoryInterface {

  @Autowired
  StudentDio studentdio;

  @Transactional
  @Override
  public void addStudents(Student student) {
    studentdio.save(student);
  }

  @Transactional
  @Override
  public void updateStudents(Student student) {
    // TODO Auto-generated method stub
    studentdio.save(student);
  }

  @Transactional
  @Override
  public void deleteStudents(Student student) {
    // TODO Auto-generated method stub
    studentdio.delete(student);
  }

  @Override
  public List<Student> selectStudent(SchoolMaster school) {
    // TODO Auto-generated method stub
    return studentdio.findByschool(school);
  }

  @Override
  public Student findById(Integer id) {
    // TODO Auto-generated method stub
    return studentdio.findById(id).get();
  }

@Override
public List<Student> findByStdAndDivId(StdMaster std, DivMaster div) {
	// TODO Auto-generated method stub
	return studentdio.findByStdAndDivId(std, div);
}

}
