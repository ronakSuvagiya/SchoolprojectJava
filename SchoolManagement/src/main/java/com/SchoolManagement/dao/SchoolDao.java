package com.SchoolManagement.dao;

import org.springframework.data.repository.CrudRepository;
import com.SchoolManagement.enitiy.SchoolMaster;

public interface SchoolDao extends CrudRepository<SchoolMaster, Integer> {

}
