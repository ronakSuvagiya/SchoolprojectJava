package com.SchoolManagement.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.TeacherMaster;

public interface TeacherDio
    extends CrudRepository<TeacherMaster, Integer>, JpaSpecificationExecutor<TeacherMaster> {

  public TeacherMaster findByid(Integer id);

  public TeacherMaster findByTeacherCodeAndSchoolId(String techerCode, SchoolMaster school);

  public TeacherMaster findByUserNameIgnoreCaseAndPasswordIgnoreCase(String username, String pass);

  public List<TeacherMaster> findBySchoolId(SchoolMaster school);
  
  public Long countBySchoolId(SchoolMaster school);
}
