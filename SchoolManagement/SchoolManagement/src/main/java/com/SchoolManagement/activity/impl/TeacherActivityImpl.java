package com.SchoolManagement.activity.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SchoolManagement.activity.TeachertActivity;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dao.TeacherDio;
import com.SchoolManagement.dto.TeacherDto;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.enitiy.TeacherMaster;
import com.SchoolManagement.repository.TeacherRepositoryInterface;

@Service
public class TeacherActivityImpl implements TeachertActivity {

  @Autowired
  TeacherRepositoryInterface teacherrepo;

  @Autowired
  TeacherDio teacherDio;

  @Autowired
  SchoolDao schoolDao;

  @Autowired
  StdDio stdDio;

  @Autowired
  HttpServletRequest rerquest;

  @Override
  public void addTeacher(TeacherDto teacherDto) {
    // TODO Auto-generated method stub
    String username =
        teacherDto.getName().substring(0, 3) + teacherDto.getLastName().substring(0, 3);
    String password = teacherDto.getMobileNo().substring(0, 3) + "@" + teacherDto.getName();
    TeacherMaster teacher = new TeacherMaster();
    teacher = dtoToEntity(teacherDto, teacher);
    teacher.setUserName(username);
    teacher.setPassword(password);
    teacherrepo.addTeacher(teacher);
  }

  @Override
  public void updateTeacher(TeacherDto teacherDto) {
    // TODO Auto-generated method stub
    SchoolMaster sc = schoolDao.findById(teacherDto.getSchoolId()).get();
    TeacherMaster tc = teacherDio.findByTeacherCodeAndSchoolId(teacherDto.getTeacherCode(), sc);
    tc = dtoToEntity(teacherDto, tc);
    teacherrepo.updateTeacher(tc);

  }

  @Override
  public void deleteTeacher(TeacherDto teacherDto) {
    // TODO Auto-generated method stub
    SchoolMaster sc = schoolDao.findById(teacherDto.getSchoolId()).get();
    TeacherMaster tc = teacherDio.findByTeacherCodeAndSchoolId(teacherDto.getTeacherCode(), sc);
    tc = dtoToEntity(teacherDto, tc);
    teacherrepo.deleteTeacher(tc);
  }

  public TeacherMaster dtoToEntity(TeacherDto teDto, TeacherMaster te) {
    te.setLastName(teDto.getLastName());
    te.setMobileNo(teDto.getMobileNo());
    te.setName(teDto.getName());
    te.setEmailId(teDto.getEmailId());
    te.setTeacherCode(teDto.getTeacherCode());
    te.setDob(teDto.getDob());
    te.setGender(teDto.getGender());
    System.out.println(teDto.getDepartment());
    SchoolMaster sc = schoolDao.findById(teDto.getSchoolId()).get();
    StdMaster std = stdDio.findBystdNameAndSchool(teDto.getDepartment(), sc);
    te.setDepartment(std);
    te.setSchoolId(sc);
    return te;
  }

  @Override
  public List<TeacherMaster> selectTeacher(Integer school) {
    // TODO Auto-generated method stub
    return teacherrepo.selectTeacher(schoolDao.findById(school).get());
  }

  @Override
  public TeacherMaster findByTeacherid(Integer id) {
    // TODO Auto-generated method stub
    return teacherrepo.findByTeacherid(id);
  }

}
