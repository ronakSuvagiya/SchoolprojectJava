package com.SchoolManagement.controler;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolManagement.common.ResponesDto;
import com.SchoolManagement.common.setResult;
import com.SchoolManagement.dao.AssignmentDao;
import com.SchoolManagement.dao.DivDio;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dao.SubjectDao;
import com.SchoolManagement.dao.TeacherDio;
import com.SchoolManagement.dto.AssignmentDto;
import com.SchoolManagement.enitiy.AssignmentMaster;

@RestController
public class AssignmentControlerApi {
	
	@Autowired
	SubjectDao subdao;
	
	@Autowired
	TeacherDio teacherDao;

	@Autowired
	AssignmentDao aDao;
	
	@Autowired
	StdDio stddao;
	
	@Autowired
	SchoolDao schoolDao;
	
	@Autowired
	DivDio divDao;
	
	
	@PostMapping("/addAssignmentApi")
	public ResponseEntity<ResponesDto> addass(@RequestBody AssignmentDto assigment) {
		AssignmentMaster ass = converdto(assigment);
		aDao.save(ass);
		setResult result = new setResult();
		ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Add Subject Successfully");
		return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
	}
	
	@RequestMapping("/getAssignmentApi")
	public List<AssignmentMaster> getAss(@RequestParam("std")Integer std,@RequestParam("div")Integer div,@RequestParam("date")Date date){
		return aDao.findByStdAndDivIdAndDate(stddao.findById(std).get(), divDao.findById(div).get(), date);
	}
	
	
	@GetMapping("/getAssignmentByAssignApi")
	public List<AssignmentMaster> getAsss(@RequestParam("std")Integer std,@RequestParam("div")Integer div,@RequestParam("date")Date date){
		return aDao.findByStdAndDivIdAndAssign(stddao.findById(std).get(), divDao.findById(div).get(), date);
	}
	
	public AssignmentMaster converdto(AssignmentDto assi) {
		AssignmentMaster ass= new AssignmentMaster();
		ass.setSubject(subdao.findById(assi.getSubject()).get());
		ass.setDescription(assi.getDescription());
		ass.setTeacherMaster(teacherDao.findByid(assi.getTeacherMaster()));
		ass.setDate(assi.getDate());
		ass.setDivId(divDao.findById(assi.getDiv()).get());
		ass.setSchool(schoolDao.findById(assi.getSchool()).get());
		ass.setStd(stddao.findById(assi.getStd()).get());
		ass.setAssign(assi.getCreated_on());
		return ass;
	}
}
