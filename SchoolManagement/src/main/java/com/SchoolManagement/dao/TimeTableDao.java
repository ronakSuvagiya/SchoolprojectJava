package com.SchoolManagement.dao;

import org.springframework.data.repository.CrudRepository;
import com.SchoolManagement.enitiy.TimeTableMaster;


public interface TimeTableDao extends CrudRepository<TimeTableMaster, Integer> {

	public TimeTableMaster findByDivId(Integer id);
}
