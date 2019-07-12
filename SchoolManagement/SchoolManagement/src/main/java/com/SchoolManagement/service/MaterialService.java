package com.SchoolManagement.service;

import java.util.List;

import com.SchoolManagement.dto.MaterialDto;
import com.SchoolManagement.enitiy.MetiralMaster;

public interface MaterialService {

	public List<MetiralMaster> getMaterialdetailsBySchoolAndStdAndSub(Integer schoolID, Integer stdId,Integer subId) ;
}
