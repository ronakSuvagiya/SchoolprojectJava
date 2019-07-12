package com.SchoolManagement.controlerMVC;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.SchoolManagement.ApiUri.ApiUrl;
import com.SchoolManagement.ApiUri.SessionUri;
import com.SchoolManagement.common.ResponesDto;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dto.DivDto;
import com.SchoolManagement.dto.StudentDto;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.StdMaster;

@Controller
public class DeptmentController {

	@Autowired
	StdDio stdDio;

	@Autowired
	SchoolDao schoolDao;

	@RequestMapping("/add_department")
	public ModelAndView addDep(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("add_department");
		model.addObject("school", (Integer) request.getSession().getAttribute(SessionUri.SchoolId));
		List<StdMaster> std = stdDio.findBySchool(
				schoolDao.findById((Integer) request.getSession().getAttribute(SessionUri.SchoolId)).get());
		model.addObject("StdName", std);
		return model;
	}

	@RequestMapping("/addStd")
	public ModelAndView addstd(HttpServletRequest request, @RequestParam("Stdname") String stdName,@RequestParam("fee") long fee) {
		ModelAndView model = new ModelAndView("add_department");
		SchoolMaster school = schoolDao.findById((Integer) request.getSession().getAttribute(SessionUri.SchoolId))
				.get();
		StdMaster std = new StdMaster();
		std.setStdName(stdName);
		std.setSchool(school);
		std.setFees(fee);
		stdDio.save(std);
		model = addDep(request);
		ResponesDto pos = new ResponesDto();
		pos.setCode(200);
		pos.setMessage("Std Add Successfully");
		model.addObject("msg", pos);
		return model;
	}

	@RequestMapping("/adddivs")
	public ModelAndView addDiv(HttpServletRequest request, @RequestParam("std") Integer stdName,
			@RequestParam("DivName") String divName) {
		ModelAndView model = new ModelAndView("add_department");
		DivDto div = new DivDto();
		div.setName(divName);
		div.setStd_id(stdName);

		RestTemplate resttemp = new RestTemplate();
		HttpEntity<DivDto> httpEntity = new HttpEntity<DivDto>(div);
		ResponseEntity<ResponesDto> responseEntity = resttemp.postForEntity(ApiUrl.ADDDIV, httpEntity,
				ResponesDto.class);

		model = addDep(request);
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			ResponesDto repoDto = responseEntity.getBody();
			model.addObject("msg", repoDto);
		}

		return model;
	}
}
