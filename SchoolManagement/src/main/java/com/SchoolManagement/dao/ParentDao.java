package com.SchoolManagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.SchoolManagement.enitiy.ParentMaster;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.Student;


public interface ParentDao extends CrudRepository<ParentMaster, Integer> {

  public ParentMaster findByStu(Student stu);
  
  public List<ParentMaster> findBySchool(SchoolMaster schoolMaster);
  
}
