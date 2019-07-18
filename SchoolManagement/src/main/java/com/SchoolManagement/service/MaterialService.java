package com.SchoolManagement.service;

import java.util.List;

import com.SchoolManagement.enitiy.MetiralMaster;

public interface MaterialService {

	public List<MetiralMaster> findMetiralMasterBySchoolIdInAndStdIdInAndSubId(Integer schoolId,Integer stdId,Integer subId);
}
