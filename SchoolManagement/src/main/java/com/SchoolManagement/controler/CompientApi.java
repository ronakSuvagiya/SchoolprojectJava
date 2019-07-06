package com.SchoolManagement.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolManagement.common.ResponesDto;
import com.SchoolManagement.common.setResult;
import com.SchoolManagement.dao.StudentDio;
import com.SchoolManagement.dao.complientDao;
import com.SchoolManagement.dto.ComplientDto;
import com.SchoolManagement.enitiy.ComplientMaster;

@RestController
public class CompientApi {

	@Autowired
	StudentDio student;

	@Autowired
	complientDao complient;

	@RequestMapping("/addComplientApi")
	public ResponseEntity<ResponesDto> addcompient(@RequestBody ComplientDto comp) {
		ComplientMaster compMaster = converDto(comp);
		complient.save(compMaster);
		setResult result = new setResult();
		ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Send Complient Successfully");
		return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
	}

	@GetMapping("/getComplentsApi")
	public List<ComplientMaster> getComp(@RequestParam("student") Integer stdID){
		return complient.findByStudent(student.findById(stdID).get());
	}
	
	public ComplientMaster converDto(ComplientDto compDto) {
		ComplientMaster comp = new ComplientMaster();
		comp.setDescription(compDto.getDescription());
		comp.setTitle(compDto.getTitle());
		comp.setStudent(student.findById(compDto.getStudent()).get());
		return comp;
	}
}
