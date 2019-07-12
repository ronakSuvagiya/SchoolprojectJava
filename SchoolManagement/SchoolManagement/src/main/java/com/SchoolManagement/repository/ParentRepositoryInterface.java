package com.SchoolManagement.repository;

import java.util.List;

import com.SchoolManagement.enitiy.ParentMaster;
import com.SchoolManagement.enitiy.SchoolMaster;

public interface ParentRepositoryInterface {
  public void addParent(ParentMaster parentMaster);

  public void updateParent(ParentMaster parentMaster);

  public void deleteParent(ParentMaster parentMaster);
  
  public List<ParentMaster> findBySchool(SchoolMaster schoolMaster);
  
  public ParentMaster findById(Integer id);
}
