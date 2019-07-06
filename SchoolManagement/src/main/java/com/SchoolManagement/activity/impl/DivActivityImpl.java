package com.SchoolManagement.activity.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SchoolManagement.activity.DivActivity;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dto.DivDto;
import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.repository.DivRepositery;

@Service
public class DivActivityImpl implements DivActivity {

  @Autowired
  DivRepositery divrepo;

  @Autowired
  StdDio std;

  @Autowired
  SchoolDao schoolDao;

  @Override
  public void addDiv(DivDto div) {
    // TODO Auto-generated method stub
    DivMaster divmaster = new DivMaster();
    divmaster.setName(div.getName());
    StdMaster stdMaster = std.findById(div.getStd_id()).get();
    divmaster.setStdId(stdMaster);
    divrepo.addDiv(divmaster);
  }

  @Override
  public List<DivMaster> findByStd(String stdName, Integer school) {
    // TODO Auto-generated method stub
    return divrepo.findByStd(std.findBystdNameAndSchool(stdName, schoolDao.findById(school).get()));
  }

}
