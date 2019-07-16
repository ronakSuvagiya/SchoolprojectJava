package com.SchoolManagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SchoolManagement.enitiy.MetiralMaster;

@Repository
public interface MertialDao extends CrudRepository<MetiralMaster, Integer> {

	public List<MetiralMaster> findMetiralMasterBySchoolIdInAndStdIdInAndSubId(Integer schoolId,Integer stdId,Integer subId);
	
}
