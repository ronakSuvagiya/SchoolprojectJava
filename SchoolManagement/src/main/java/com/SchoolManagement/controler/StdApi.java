package com.SchoolManagement.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.enitiy.StdMaster;

@RestController
public class StdApi {

	@Autowired
	SchoolDao school;
	
	@Autowired
	StdDio std;
	
	@RequestMapping("finstdBySchoolId")
	public List<StdMaster> stdList(@RequestParam("school")Integer schoolId)
	{
		return std.findBySchool(school.findById(schoolId).get());
	}
	
}
