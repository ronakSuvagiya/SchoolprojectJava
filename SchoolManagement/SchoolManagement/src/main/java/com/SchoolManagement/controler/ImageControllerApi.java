package com.SchoolManagement.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolManagement.enitiy.ImageMaster;
import com.SchoolManagement.service.ImageMasterService;


@RestController
public class ImageControllerApi {

	@Autowired
	ImageMasterService imageMasterServive;

	@GetMapping("getImagesBySchoolApi/{schoolId}")
	public List<ImageMaster> getImagesBySchool(@PathVariable("schoolId")Integer schoolId)
	{
		return imageMasterServive.findImageMasterBySchoolId(schoolId);
	}
	
}
