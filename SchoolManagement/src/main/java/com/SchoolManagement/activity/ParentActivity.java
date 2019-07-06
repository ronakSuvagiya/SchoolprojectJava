package com.SchoolManagement.activity;

import java.util.List;

import com.SchoolManagement.dto.ParentDto;
import com.SchoolManagement.enitiy.ParentMaster;
import com.SchoolManagement.enitiy.SchoolMaster;


public interface ParentActivity {

  public void addParent(ParentDto parentDto);

  public void updateParent(ParentDto parentDto);

  public void deleteParent(ParentDto parentDto);
  
  public List<ParentMaster> findBySchool(Integer schoolMaster);
  public ParentMaster findById(Integer id);
}
