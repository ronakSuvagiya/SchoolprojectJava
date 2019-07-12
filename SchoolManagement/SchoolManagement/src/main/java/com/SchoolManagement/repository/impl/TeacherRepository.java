package com.SchoolManagement.repository.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.SchoolManagement.dao.TeacherDio;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.TeacherMaster;
import com.SchoolManagement.repository.TeacherRepositoryInterface;

@Repository
public class TeacherRepository implements TeacherRepositoryInterface {

  @Autowired
  TeacherDio tacherDio;

  @Transactional
  @Override
  public void addTeacher(TeacherMaster teacherMaster) {
    // TODO Auto-generated method stub
    tacherDio.save(teacherMaster);
  }

  @Transactional
  @Override
  public void updateTeacher(TeacherMaster teacherMaster) {
    // TODO Auto-generated method stub
    tacherDio.save(teacherMaster);
  }

  @Transactional
  @Override
  public void deleteTeacher(TeacherMaster teacherMaster) {
    // TODO Auto-generated method stub
    tacherDio.delete(teacherMaster);
  }

  @Override
  public List<TeacherMaster> selectTeacher(SchoolMaster school) {
    // TODO Auto-generated method stub
    return (List<TeacherMaster>) tacherDio.findBySchoolId(school);
  }

  @Override
  public TeacherMaster findByTeacherid(Integer id) {
    // TODO Auto-generated method stub
    return tacherDio.findByid(id);
  }

}
