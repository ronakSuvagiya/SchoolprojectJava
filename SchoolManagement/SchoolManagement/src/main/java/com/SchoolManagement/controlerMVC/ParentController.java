package com.SchoolManagement.controlerMVC;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.SchoolManagement.ApiUri.ApiUrl;
import com.SchoolManagement.ApiUri.SessionUri;
import com.SchoolManagement.common.ResponesDto;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dto.ParentDto;
import com.SchoolManagement.dto.StudentDto;
import com.SchoolManagement.enitiy.ParentMaster;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.enitiy.Student;

@Controller
public class ParentController {

	@Autowired
	StdDio stdDio;

	@Autowired
	SchoolDao schoolDao;

	@RequestMapping("/add_parent")
	public ModelAndView add_parent(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("add_parent");
		model.addObject("school", (Integer) request.getSession().getAttribute(SessionUri.SchoolId));
		List<StdMaster> std = stdDio.findBySchool(
				schoolDao.findById((Integer) request.getSession().getAttribute(SessionUri.SchoolId)).get());
		model.addObject("StdName", std);
		return model;
	}

	@RequestMapping("/add_pnt")
	public ModelAndView add_pnt(HttpServletRequest request, String name, String emialID, String lastName,
			String mobileNo, Integer std, Integer stu) {
		ModelAndView model = new ModelAndView("add_parent");
		Integer schoolId = (Integer) request.getSession().getAttribute(SessionUri.SchoolId);
		System.out.println("=====>" + request.getSession().getAttribute(SessionUri.SchoolId));
		model.addObject("school", (Integer) request.getSession().getAttribute(SessionUri.SchoolId));
		List<StdMaster> std1 = stdDio.findBySchool(
				schoolDao.findById((Integer) request.getSession().getAttribute(SessionUri.SchoolId)).get());
		model.addObject("StdName", std1);

		ParentDto parents = converDto(name, lastName, mobileNo, emialID, schoolId, std, stu);

		RestTemplate resttemp = new RestTemplate();
		HttpEntity<ParentDto> httpEntity = new HttpEntity<ParentDto>(parents);
		ResponseEntity<ResponesDto> responseEntity = resttemp.postForEntity(ApiUrl.ADDPARENT, httpEntity,
				ResponesDto.class);

		System.out.println("==>" + responseEntity);
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			ResponesDto repoDto = responseEntity.getBody();
			model.addObject("msg", repoDto);
		}
		return model;

	}
	
	@RequestMapping("/editParent")
	public ModelAndView edit_parent(@RequestParam("id") Integer id,HttpServletRequest request)
	{
		ModelAndView model = new ModelAndView("edit_parent");
		 RestTemplate rest = new RestTemplate();
		    ResponseEntity<ParentMaster> reposEntity =
		        rest.getForEntity(ApiUrl.FINDBYIDPARENT + id, ParentMaster.class);
		    System.out.println(reposEntity);
		    ParentMaster parentMaster = reposEntity.getBody();
		    model.addObject("parent", parentMaster);
		    List<StdMaster> std = stdDio.findBySchool(
		        schoolDao.findById((Integer) request.getSession().getAttribute(SessionUri.SchoolId)).get());
		    model.addObject("StdName", std);
		    model.addObject("school", (Integer) request.getSession().getAttribute(SessionUri.SchoolId));
		return model;
	}

	@RequestMapping("/edit_pnt")
	public ModelAndView edit_pnt(HttpServletRequest request, String name, String emialID, String lastName,
			String mobileNo, Integer std, Integer stu)
	{
		 ModelAndView model = null;

		    Integer schoolId = (Integer) request.getSession().getAttribute(SessionUri.SchoolId);
		    ParentDto parent =
		        converDto(name, lastName,mobileNo,emialID,schoolId,std,stu);

		   
		    RestTemplate resttemp = new RestTemplate();
		    HttpEntity<ParentDto> httpEntity = new HttpEntity<ParentDto>(parent);
		    ResponseEntity<ResponesDto> responseEntity =
		        resttemp.postForEntity(ApiUrl.EDITPARENT, httpEntity, ResponesDto.class);

		    System.out.println("==>" + responseEntity);
		    model = all_parent(request);
		    if (responseEntity.getStatusCode() == HttpStatus.OK) {
		      ResponesDto repoDto = responseEntity.getBody();
		      model.addObject("msg", repoDto);
		    }

		    return model;
	}
	
	@RequestMapping("/all_parents")
	public ModelAndView all_parent(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("all_parents");
		RestTemplate rest = new RestTemplate();
		ResponseEntity<ParentMaster[]> reposEntity = rest.getForEntity(
				ApiUrl.ALLPARENT + request.getSession().getAttribute(SessionUri.SchoolId), ParentMaster[].class);
		System.out.println(reposEntity);
		ParentMaster[] student = reposEntity.getBody();
		model.addObject("studentList", student);

		return model;
	}

	public ParentDto converDto(String name, String lastName, String mobileNo, String emialID, Integer school_id,
			Integer std, Integer stu) {
		ParentDto pent = new ParentDto();
		pent.setName(name);
		pent.setLastName(lastName);
		pent.setMobileNo(mobileNo);
		pent.setEmialID(emialID);
		pent.setStu(stu);
		pent.setStd(std);
		pent.setSchool_id(school_id);
		return pent;
	}

}
