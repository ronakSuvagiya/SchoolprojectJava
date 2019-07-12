package com.SchoolManagement.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolManagement.common.ResponesDto;
import com.SchoolManagement.common.setResult;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dao.SubjectDao;
import com.SchoolManagement.dto.SubjectDto;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.enitiy.SubjectMaster;

@RestController
public class SubjectApi {
	
	@Autowired
	StdDio std;
	
	@Autowired
	SubjectDao subject;
	
	@Autowired
	SchoolDao schoolDao;

	@RequestMapping("/AddSubjectApi")
	public ResponseEntity<ResponesDto> AddSubjectApi(@RequestBody SubjectDto stbject){
		SubjectMaster sub = convertDto(stbject);
		subject.save(sub);
		setResult result = new setResult();
		ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Add Subject Successfully");
		return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
	}
	
	@RequestMapping("/getSubjectApi")
	public List<SubjectMaster> getSub(@RequestParam Integer stdid,@RequestParam Integer school){
		StdMaster stdm = std.findByIdAndSchool(stdid,schoolDao.findById(school).get());
		return subject.findByStd(stdm);
	}
	
	public SubjectMaster convertDto(SubjectDto subdto){
		SubjectMaster sub = new SubjectMaster();
		sub.setName(subdto.getName());
		sub.setStd(std.findById(subdto.getStd()).get());
		return sub;
	}
}
