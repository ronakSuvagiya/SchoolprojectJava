package com.SchoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SchoolManagement.dao.MertialDao;
import com.SchoolManagement.dto.MaterialDto;
import com.SchoolManagement.enitiy.MetiralMaster;
import com.SchoolManagement.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService{

	@Autowired
	MertialDao materialDao;

	@Override
	public List<MetiralMaster> getMaterialdetailsBySchoolAndStdAndSub(Integer schoolID, Integer stdId, Integer subId) {

		return materialDao.findMetiralMasterBySchoolIdInAndStdIdInAndSubId(schoolID, stdId, subId);
	}
	
	
}
