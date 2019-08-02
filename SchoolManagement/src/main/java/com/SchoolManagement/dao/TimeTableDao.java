package com.SchoolManagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.SchoolManagement.enitiy.TimeTableMaster;


public interface TimeTableDao extends CrudRepository<TimeTableMaster, Integer> {

	public TimeTableMaster findByDivIdAndType(Integer id,Integer type);
	public TimeTableMaster findByTeacherId(Integer id);
	public List<TimeTableMaster> findByStdIdAndType(Integer id,Integer type);
}
