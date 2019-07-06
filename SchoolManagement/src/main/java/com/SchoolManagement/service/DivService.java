package com.SchoolManagement.service;

import java.util.List;
import com.SchoolManagement.dto.DivDto;
import com.SchoolManagement.enitiy.DivMaster;

public interface DivService {
  public void addDiv(DivDto div);

  public List<DivMaster> findByStd(String stdName, Integer school);
}
