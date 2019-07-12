package com.SchoolManagement.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolManagement.dao.FeesDao;
import com.SchoolManagement.enitiy.FeesMaster;
import com.SchoolManagement.enitiy.Student;
import com.SchoolManagement.service.StudentSerivce;

@RestController()
public class RecpitControllerApi {
	
	@Autowired
	FeesDao feesDio;
	
	@Autowired
	StudentSerivce stdents;
	
	@RequestMapping("/getRecpit")
	public List<FeesMaster> recpit(@RequestParam("id") Integer sid)
	{
		Student stu = stdents.findById(sid);
		return feesDio.findByStudent(stu);
	}
}
