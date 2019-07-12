package com.SchoolManagement.controlerMVC;


import java.util.Date;
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
import com.SchoolManagement.dao.FeesDao;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dto.ParentDto;
import com.SchoolManagement.enitiy.FeesMaster;
import com.SchoolManagement.enitiy.ParentMaster;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.enitiy.Student;
import com.SchoolManagement.service.StudentSerivce;

@Controller
public class FeeController {
	
	@Autowired
	StdDio stdDio;

	@Autowired
	SchoolDao schoolDao;
	
	@Autowired
	FeesDao feesDao;
	
	@Autowired
	StudentSerivce studentSerivce;

	@RequestMapping("/add_fees")
	public ModelAndView addfee(HttpServletRequest request)
	{
		ModelAndView model = new ModelAndView("add_fees");
		model.addObject("school", (Integer) request.getSession().getAttribute(SessionUri.SchoolId));
		List<StdMaster> std = stdDio.findBySchool(
				schoolDao.findById((Integer) request.getSession().getAttribute(SessionUri.SchoolId)).get());
		model.addObject("StdName", std);
		return model;
	}
	
	@RequestMapping("/add_fee")
	public ModelAndView addFees(HttpServletRequest request,@RequestParam("amount") long amount,@RequestParam("stu") Integer students,@RequestParam("collectionDate") java.sql.Date date,@RequestParam("Details") String deatils)
	{
		ModelAndView model = new ModelAndView();
		FeesMaster fees = new FeesMaster();
		fees.setAmount(amount);
		fees.setDate(date);
		fees.setDeatils(deatils);
		fees.setStudent(studentSerivce.findById(students));
		model=addfee(request);
		ResponesDto pos = new ResponesDto();
		try {
			feesDao.save(fees);
			pos.setCode(200);
			pos.setMessage("Std Add Successfully");
			model.addObject("msg", pos);
		} catch (Exception e) {
			// TODO: handle exception
			pos.setCode(300);
			pos.setMessage("Somthing is Worng");
			model.addObject("msg", pos);
		}
		return model;
	}
	
	@RequestMapping("/recpit")
	public ModelAndView recpit(HttpServletRequest request,@RequestParam("stu") Integer students)
	{
		SchoolMaster school = schoolDao.findById((Integer)request.getSession().getAttribute(SessionUri.SchoolId)).get();
		ModelAndView model = new ModelAndView("fees_receipt");
		Student st = studentSerivce.findById(students);
		List<FeesMaster> fee = feesDao.findByStudentAndRecipt(studentSerivce.findById(students), false);
		long am = 0;    
		for (FeesMaster feesMaster : fee) {
		    	 am = am + feesMaster.getAmount();
				feesMaster.setRecipt(true);
				feesDao.save(feesMaster);
			}
		if(fee.isEmpty())
		{
				model.addObject("amount","N/A");
			   model.addObject("student",st);
			   model.addObject("feeDeatils",fee);
			   model.addObject("date", new Date());
		}
		else {
		   Student student =  fee.get(0).getStudent();
		   model.addObject("amount",am);
		   model.addObject("student", student);
		   model.addObject("feeDeatils",fee);
		   model.addObject("date", new Date());
		}
		model.addObject("logo",school.getLogoPath());
		return model;
	}
}
