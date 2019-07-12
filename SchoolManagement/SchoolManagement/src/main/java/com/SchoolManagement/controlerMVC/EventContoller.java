package com.SchoolManagement.controlerMVC;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.SchoolManagement.ApiUri.SessionUri;
import com.SchoolManagement.common.ResponesDto;
import com.SchoolManagement.dao.EventDao;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dto.EventDto;
import com.SchoolManagement.enitiy.EventMaster;

@Controller
public class EventContoller {


	@Autowired
	SchoolDao school;
	
	@Autowired
	EventDao eventDao;
	
	@RequestMapping("event")
	public ModelAndView event() {
		ModelAndView model = new ModelAndView("event");
		return model;
	}
	
	@RequestMapping("/AddEvent")
	public ModelAndView AddEvent(@ModelAttribute("event") EventDto event,HttpServletRequest request) {
		ModelAndView model = new ModelAndView("event");
		EventMaster eventMaster = convrtDto(event, (Integer) request.getSession().getAttribute(SessionUri.SchoolId));
		ResponesDto pos = new ResponesDto();
		try {
			eventDao.save(eventMaster);	
			pos.setCode(200);
			pos.setMessage("Add Event Successfully");
			model.addObject("msg", pos);
		} catch (Exception e) {
			pos.setCode(300);
			pos.setMessage("Somthing is Worng");
			model.addObject("msg", pos);
		}
		return model;
	}
	
	public EventMaster convrtDto(EventDto eventDto,Integer schoolId) {
		EventMaster event = new EventMaster();
		event.setTitle(eventDto.getTitle());
		event.setStartDate(eventDto.getStartDate());
		event.setEndDate(eventDto.getEndDate());
		event.setSchool(school.findById(schoolId).get());
		event.setStartTime(eventDto.getStartTime());
		return event;
	}
}
