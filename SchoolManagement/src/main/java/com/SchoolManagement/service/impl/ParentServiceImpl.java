package com.SchoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SchoolManagement.activity.ParentActivity;
import com.SchoolManagement.dto.ParentDto;
import com.SchoolManagement.enitiy.ParentMaster;
import com.SchoolManagement.service.ParentSerivce;

@Service
public class ParentServiceImpl implements ParentSerivce {

  @Autowired
  ParentActivity parentActivity;

  @Override
  public void addParent(ParentDto parentDto) {
    // TODO Auto-generated method stub
    parentActivity.addParent(parentDto);

  }

  @Override
  public void updateParent(ParentDto parentDto) {
    // TODO Auto-generated method stub
    parentActivity.updateParent(parentDto);

  }

  @Override
  public void deleteParent(ParentDto parentDto) {
    // TODO Auto-generated method stub
    parentActivity.deleteParent(parentDto);
  }

@Override
public List<ParentMaster> selectParent(Integer schoolId) {
	// TODO Auto-generated method stub
	return parentActivity.findBySchool(schoolId);
}

@Override
public ParentMaster findById(Integer id) {
	// TODO Auto-generated method stub
	return parentActivity.findById(id);
}

}
