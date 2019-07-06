package com.SchoolManagement.activity.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SchoolManagement.activity.ParentActivity;
import com.SchoolManagement.dao.DivDio;
import com.SchoolManagement.dao.ParentDao;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dao.StudentDio;
import com.SchoolManagement.dto.ParentDto;
import com.SchoolManagement.enitiy.ParentMaster;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.enitiy.Student;
import com.SchoolManagement.repository.ParentRepositoryInterface;

@Service
public class ParentActivityImpl implements ParentActivity {

  @Autowired
  ParentRepositoryInterface parentrepo;

  @Autowired
  StudentDio studentDio;

  @Autowired
  ParentDao parent;

  @Autowired
  DivDio divDio;

  @Autowired
  SchoolDao schoolDao;

  @Autowired
  StdDio stdDao;

  @Override
  public void addParent(ParentDto paDto) {
    String username = paDto.getName().substring(0, 3) + paDto.getLastName().substring(0, 3);
    String password = paDto.getMobileNo().substring(0, 3) + "@" + paDto.getName();
    ParentMaster parent = new ParentMaster();
    parent = dtoToEntity(paDto, parent);
    parent.setUserName(username);
    parent.setPassword(password);
    parentrepo.addParent(parent);
  }

  @Override
  public void updateParent(ParentDto paDto) {
    // TODO Auto-generated method stub
    SchoolMaster sc = schoolDao.findById(paDto.getSchool_id()).get();
    StdMaster std = stdDao.findById(paDto.getStd()).get();
    Student st = studentDio.findByIdAndSchoolAndStd(paDto.getStu(), sc, std);
    ParentMaster par = parent.findByStu(st);
    par = dtoToEntity(paDto, par);
    parentrepo.updateParent(par);
  }


  @Override
  public void deleteParent(ParentDto paDto) {
    // TODO Auto-generated method stub
    SchoolMaster sc = schoolDao.findById(paDto.getSchool_id()).get();
    StdMaster std = stdDao.findById(paDto.getStd()).get();
    Student st = studentDio.findByIdAndSchoolAndStd(paDto.getStu(), sc, std);
    ParentMaster par = parent.findByStu(st);
    par = dtoToEntity(paDto, par);
    parentrepo.deleteParent(par);
  }

  public ParentMaster dtoToEntity(ParentDto stDto, ParentMaster st) {
    st.setLastName(stDto.getLastName());
    st.setMobileNo(stDto.getMobileNo());
    st.setName(stDto.getName());
    st.setEmialID(stDto.getEmialID());
    SchoolMaster sc = schoolDao.findById(stDto.getSchool_id()).get();
    StdMaster std = stdDao.findById(stDto.getStd()).get();
    Student stu = studentDio.findByIdAndSchoolAndStd(stDto.getStu(), sc, std);
    st.setStu(stu);
   st.setSchool(sc);
    return st;
  }

@Override
public List<ParentMaster> findBySchool(Integer schoolMaster) {
	// TODO Auto-generated method stub
	SchoolMaster school = schoolDao.findById(schoolMaster).get();
	return parentrepo.findBySchool(school);
}

@Override
public ParentMaster findById(Integer id) {
	// TODO Auto-generated method stub
	return parentrepo.findById(id);
}

}
