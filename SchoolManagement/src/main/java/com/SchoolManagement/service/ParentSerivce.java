package com.SchoolManagement.service;

import java.util.List;

import com.SchoolManagement.dto.ParentDto;
import com.SchoolManagement.enitiy.ParentMaster;

public interface ParentSerivce {

  public void addParent(ParentDto parentDto);

  public void updateParent(ParentDto parentDto);

  public void deleteParent(ParentDto parentDto);
  
  public List<ParentMaster> selectParent(Integer schoolId);
  
  public ParentMaster findById(Integer id);
}
