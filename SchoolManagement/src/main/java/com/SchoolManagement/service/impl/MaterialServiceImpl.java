    
package com.SchoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SchoolManagement.dao.MertialDao;
import com.SchoolManagement.enitiy.MetiralMaster;
import com.SchoolManagement.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService{

	@Autowired
	MertialDao materialDao;
	
	@Override
	public List<MetiralMaster> findMetiralMasterBySchoolIdInAndStdIdInAndSubId(Integer schoolId, Integer stdId,Integer subjectId) {
		
		return materialDao.findMetiralMasterBySchoolIdInAndStdIdInAndSubId(schoolId, stdId, subjectId);
	}

}