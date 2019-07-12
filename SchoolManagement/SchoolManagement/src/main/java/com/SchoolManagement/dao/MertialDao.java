package com.SchoolManagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SchoolManagement.enitiy.MetiralMaster;

public interface MertialDao extends CrudRepository<MetiralMaster, Integer> {

	public List<MetiralMaster> findMetiralMasterBySchoolIdInAndStdIdInAndSubId(Integer schoolId,Integer stdId,Integer subid);
}
