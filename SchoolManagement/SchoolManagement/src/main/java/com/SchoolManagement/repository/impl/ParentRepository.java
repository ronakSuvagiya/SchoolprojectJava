package com.SchoolManagement.repository.impl;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.SchoolManagement.dao.ParentDao;
import com.SchoolManagement.enitiy.ParentMaster;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.repository.ParentRepositoryInterface;

@Repository
public class ParentRepository implements ParentRepositoryInterface {

  @Autowired
  ParentDao parentDio;

  @Transactional
  @Override
  public void addParent(ParentMaster parentMaster) {
    parentDio.save(parentMaster);
  }

  @Transactional
  @Override
  public void updateParent(ParentMaster parentMaster) {
    // TODO Auto-generated method stub
    parentDio.save(parentMaster);
  }

  @Transactional
  @Override
  public void deleteParent(ParentMaster parentMaster) {
    // TODO Auto-generated method stub
    parentDio.delete(parentMaster);
  }

@Override
public List<ParentMaster> findBySchool(SchoolMaster schoolMaster) {
	// TODO Auto-generated method stub
	return parentDio.findBySchool(schoolMaster);
}

@Override
public ParentMaster findById(Integer id) {
	// TODO Auto-generated method stub
	return parentDio.findById(id).get();
}

}
