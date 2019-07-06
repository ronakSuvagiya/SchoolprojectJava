package com.SchoolManagement.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.SchoolManagement.dao.HolidatDao;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.enitiy.HolidayMaster;

@RestController
public class HolidayApi {
	
	@Autowired
	HolidatDao holiday;
	
	@Autowired
	SchoolDao schoolDao;

	@GetMapping("/getHolidayApi")
	public List<HolidayMaster> getHoliday(@RequestParam("school") Integer school){
		List<HolidayMaster> holidayMaster =  holiday.findBySchool(schoolDao.findById(school).get());
		return holidayMaster;
	}
}
