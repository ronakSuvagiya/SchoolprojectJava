package com.SchoolManagement.repository;

import java.util.List;
import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.enitiy.StdMaster;

public interface DivRepositery {
  public void addDiv(DivMaster div);

  public List<DivMaster> findByStd(StdMaster std);
}
