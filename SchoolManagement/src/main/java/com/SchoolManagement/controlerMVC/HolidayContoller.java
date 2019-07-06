package com.SchoolManagement.controlerMVC;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.SchoolManagement.ApiUri.SessionUri;
import com.SchoolManagement.common.ResponesDto;
import com.SchoolManagement.dao.HolidatDao;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dto.HolidayDto;
import com.SchoolManagement.enitiy.HolidayMaster;

@Controller
public class HolidayContoller {
	
	@Autowired
	SchoolDao schoolDao;

	@Autowired
	HolidatDao holidayDao;
	
	
	@RequestMapping("/holiday")
	public ModelAndView holiday() {
		ModelAndView model = new ModelAndView("add_holiday");
		return model;
	}
	
	@RequestMapping("/AddHoliday")
	public ModelAndView addholiday(@ModelAttribute("Holiday") HolidayDto holidayDto,HttpServletRequest request) {
		ModelAndView model = new ModelAndView("add_holiday");
		HolidayMaster holidayMaster = converDto(holidayDto, (Integer) request.getSession().getAttribute(SessionUri.SchoolId));
		ResponesDto pos = new ResponesDto();
		try {
			holidayDao.save(holidayMaster);
			pos.setCode(200);
			pos.setMessage("Add Holiday Successfully");
			model.addObject("msg", pos);
		} catch (Exception e) {
			// TODO: handle exception
			pos.setCode(300);
			pos.setMessage("Somthing is Worng");
			model.addObject("msg", pos);
		}
		return model;
	}
	
	public HolidayMaster converDto(HolidayDto holidayDto,Integer schoolid) {
		HolidayMaster holiday = new HolidayMaster();
		holiday.setDate(holidayDto.getDate());
		holiday.setTitle(holidayDto.getDesc());
		holiday.setSchool(schoolDao.findById(schoolid).get());
		return holiday;
	}
}
