package com.SchoolManagement.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.enitiy.StdMaster;

public interface DivDio extends CrudRepository<DivMaster, Integer> {

  public List<DivMaster> findBystdId(StdMaster std);

  public DivMaster findBynameAndStdId(String name, StdMaster std);

}
