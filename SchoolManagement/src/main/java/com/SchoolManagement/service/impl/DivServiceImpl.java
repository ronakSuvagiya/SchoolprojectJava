package com.SchoolManagement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SchoolManagement.activity.DivActivity;
import com.SchoolManagement.dto.DivDto;
import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.service.DivService;

@Service
public class DivServiceImpl implements DivService {

  @Autowired
  DivActivity divactivity;

  @Override
  public void addDiv(DivDto div) {
    // TODO Auto-generated method stub
    divactivity.addDiv(div);
  }

  @Override
  public List<DivMaster> findByStd(String stdName, Integer school) {
    // TODO Auto-generated method stub
    return divactivity.findByStd(stdName, school);
  }

}
