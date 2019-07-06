package com.SchoolManagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.SchoolManagement.enitiy.HolidayMaster;
import com.SchoolManagement.enitiy.SchoolMaster;

public interface HolidatDao extends CrudRepository<HolidayMaster, Integer>{
	
	public List<HolidayMaster> findBySchool(SchoolMaster school);
	
}
