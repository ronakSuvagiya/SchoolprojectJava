package com.SchoolManagement.activity.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SchoolManagement.activity.StudentActivity;
import com.SchoolManagement.dao.DivDio;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dao.StudentDio;
import com.SchoolManagement.dto.StudentDto;
import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.enitiy.Student;
import com.SchoolManagement.repository.StudentRepositoryInterface;

@Service
public class StudentActivityImpl implements StudentActivity {

  @Autowired
  StudentRepositoryInterface studentrepo;

  @Autowired
  DivDio divDio;

  @Autowired
  SchoolDao schoolDao;

  @Autowired
  StdDio stdDao;

  @Autowired
  StudentDio studentDio;

  @Override
  public void addStudent(StudentDto stDto) {
    String username = stDto.getName().substring(0, 3) + stDto.getLast_name().substring(0, 3);
    String password =
        stDto.getDob().getDay() + "" + stDto.getDob().getMonth() + "@" + stDto.getName();
    Student st = new Student();
    st = dtoToEntity(stDto, st);
    st.setUsername(username);
    st.setPassword(password);
    studentrepo.addStudents(st);
  }

  @Override
  public void updateStudents(StudentDto student) {
    // TODO Auto-generated method stub
    SchoolMaster sc = schoolDao.findById(student.getSchool_id()).get();
    StdMaster std = stdDao.findBystdNameAndSchool(student.getOldStd(),
        schoolDao.findById(student.getSchool_id()).get());
    Student st = studentDio.findByRollNoAndSchoolAndStd(student.getOldRollNo(), sc, std);
    st = dtoToEntity(student, st);
    studentrepo.updateStudents(st);
  }


  @Override
  public void deleteStudents(StudentDto student) {
    // TODO Auto-generated method stub
    SchoolMaster sc = schoolDao.findById(student.getSchool_id()).get();
    StdMaster std = stdDao.findBystdNameAndSchool(student.getStd(),
        schoolDao.findById(student.getSchool_id()).get());
    Student st = studentDio.findByRollNoAndSchoolAndStd(student.getRoll_no(), sc, std);
    st = dtoToEntity(student, st);
    studentrepo.deleteStudents(st);
  }

  public Student dtoToEntity(StudentDto stDto, Student st) {
    SchoolMaster scMaster = schoolDao.findById(stDto.getSchool_id()).get();
    StdMaster std = stdDao.findBystdNameAndSchool(stDto.getStd(), scMaster);
    System.out.println(stDto.getDiv());
    DivMaster div = divDio.findBynameAndStdId(stDto.getDiv(), std);
    System.out.println(div.getName() + "=========>");
    st.setDivId(div);
    st.setDob(stDto.getDob());
    st.setLastName(stDto.getLast_name());
    st.setMobileNo(stDto.getMobile_no());
    st.setAddress(stDto.getAddress());
    st.setGender(stDto.getGender());
    st.setName(stDto.getName());
    st.setRollNo(stDto.getRoll_no());
    st.setSchool(schoolDao.findById(stDto.getSchool_id()).get());
    st.setStd(std);
    return st;
  }

  @Override
  public List<Student> selectStudent(Integer school) {
    // TODO Auto-generated method stub
    return studentrepo.selectStudent(schoolDao.findById(school).get());
  }

  @Override
  public Student findById(Integer id) {
    // TODO Auto-generated method stub
    return studentrepo.findById(id);
  }

@Override
public List<Student> findByStdAndDivId(Integer std, Integer div) {
	// TODO Auto-generated method stub
	StdMaster std1 = stdDao.findById(std).get();
	DivMaster div1 = divDio.findById(div).get();
	return studentDio.findByStdAndDivId(std1, div1);
}

}
