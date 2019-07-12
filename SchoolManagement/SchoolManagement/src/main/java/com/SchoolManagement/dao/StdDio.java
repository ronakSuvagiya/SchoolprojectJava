package com.SchoolManagement.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.StdMaster;

public interface StdDio extends CrudRepository<StdMaster, Integer> {

  public List<StdMaster> findBySchool(SchoolMaster school);

  public StdMaster findBystdNameAndSchool(String stdName, SchoolMaster schMaster);
  
  public StdMaster findByIdAndSchool(Integer id, SchoolMaster schMaster);
}
