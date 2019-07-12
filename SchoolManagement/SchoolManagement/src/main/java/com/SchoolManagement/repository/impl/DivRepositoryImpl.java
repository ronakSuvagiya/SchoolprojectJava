package com.SchoolManagement.repository.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.SchoolManagement.dao.DivDio;
import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.repository.DivRepositery;

@Repository
public class DivRepositoryImpl implements DivRepositery {

  @Autowired
  DivDio divDio;

  @Transactional
  @Override
  public void addDiv(DivMaster div) {
    divDio.save(div);
  }


  @Override
  public List<DivMaster> findByStd(StdMaster std) {
    // TODO Auto-generated method stub
    return divDio.findBystdId(std);
  }
}
