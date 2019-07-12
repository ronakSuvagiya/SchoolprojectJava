package com.SchoolManagement.activity;

import java.util.List;
import com.SchoolManagement.dto.DivDto;
import com.SchoolManagement.enitiy.DivMaster;

public interface DivActivity {
  public void addDiv(DivDto div);

  public List<DivMaster> findByStd(String stdName, Integer school);
}
