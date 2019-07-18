package com.SchoolManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SchoolManagement.dao.ImageDao;
import com.SchoolManagement.enitiy.ImageMaster;
import com.SchoolManagement.service.ImageMasterService;

@Service
public class ImageMasterServiceImpl implements ImageMasterService {

	@Autowired
	ImageDao imageDao;
	
	@Override
	public List<ImageMaster> findImageMasterBySchoolId(Integer id) {
	
		return imageDao.findImageMasterBySchoolId(id);
	}

}
