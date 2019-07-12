package com.SchoolManagement.controler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.SchoolManagement.common.ResponesDto;
import com.SchoolManagement.common.setResult;
import com.SchoolManagement.dao.MertialDao;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dao.SubjectDao;
import com.SchoolManagement.enitiy.MetiralMaster;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.service.MaterialService;

@RestController
public class MertialApi {
	
	@Autowired
	SchoolDao school;
	
	@Autowired
	MertialDao m2;
	
	@Autowired
	SubjectDao subDao;
	
	@Autowired
	StdDio stdDao;
	
	@Autowired
	MaterialService materialService;
	
	public static String uploadDir = System.getProperty("user.dir") + "/document";

	@RequestMapping(value = "/addmatirealApi",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponesDto> addmatrial(@RequestParam("file") MultipartFile image1, Integer sub, Integer std,Integer schoolId){
		MetiralMaster m1 = new MetiralMaster();
		Path fileNameAndPath = Paths.get(uploadDir, image1.getOriginalFilename());
	    try {
	      Files.write(fileNameAndPath, image1.getBytes());
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
		m1.setDoc_name(image1.getOriginalFilename());
		m1.setSchool(school.findById(schoolId).get());
		m1.setSub(subDao.findById(sub).get());
		m1.setStd(stdDao.findById(std).get());
		try {
			m2.save(m1);
			setResult result = new setResult();
			ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Upload Image Successfully");
			return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			setResult result = new setResult();
			ResponesDto respone = result.setResponse(300, "Something is worng");
			return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
		}
	}
	
	@GetMapping("getMaterialDetailsApi/{schoolId}/{subjectId}/{stdId}")
	public List<MetiralMaster> getMaterialDetails(@PathVariable("schoolId") Integer schoolId,@PathVariable("subjectId") Integer subjectId,@PathVariable("stdId")Integer stdId)
	{
		List<MetiralMaster> materials = materialService.getMaterialdetailsBySchoolAndStdAndSub(schoolId, subjectId, stdId);
		return materials;
	}
}
