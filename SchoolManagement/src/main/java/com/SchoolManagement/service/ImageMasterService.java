package com.SchoolManagement.service;

import java.util.List;

import com.SchoolManagement.enitiy.ImageMaster;

public interface ImageMasterService {

	public List<ImageMaster> findImageMasterBySchoolId(Integer schoolId);
}