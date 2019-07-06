package com.SchoolManagement.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.enitiy.Student;


public interface StudentDio extends CrudRepository<Student, Integer> {

  public Student findByIdAndSchoolAndStd(Integer id, SchoolMaster school,
      StdMaster stdMaster);

  public List<Student> findByschool(SchoolMaster school);
  
  public List<Student> findByStdAndDivId(StdMaster std,DivMaster div);
  
  public Student findByRollNoAndSchoolAndStd(Integer rollno, SchoolMaster school,
	      StdMaster stdMaster);
  
  public Long countBySchool(SchoolMaster schoolMaste);
  
  public List<Student> findByStdAndDivIdAndSchool(StdMaster std,DivMaster div,SchoolMaster school);
  
}
