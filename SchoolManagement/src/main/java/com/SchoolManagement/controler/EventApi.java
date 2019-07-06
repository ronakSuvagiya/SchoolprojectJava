package com.SchoolManagement.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolManagement.dao.EventDao;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.enitiy.EventMaster;

@RestController
public class EventApi {

	@Autowired
	EventDao event;
	
	@Autowired
	SchoolDao schoolDao;
	
	@GetMapping("/getEventApi")
	public List<EventMaster> getEvent(@RequestParam("school") Integer school) {
		List<EventMaster> eventMaster=  event.findBySchool(schoolDao.findById(school).get());
		return eventMaster;
	}
}
