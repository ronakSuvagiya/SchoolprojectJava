package com.SchoolManagement.controler;

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
import com.SchoolManagement.dao.ParentDao;
import com.SchoolManagement.dto.ParentDto;
import com.SchoolManagement.enitiy.ParentMaster;
import com.SchoolManagement.enitiy.Student;
import com.SchoolManagement.service.ParentSerivce;
import com.SchoolManagement.service.StudentSerivce;

@RestController
public class ParentContarolerApi {

  @Autowired
  ParentSerivce parentService;
  
  @Autowired
  StudentSerivce studentSerivce;
  
  @Autowired
  ParentDao pdao;

  @RequestMapping("/addParent")
  public ResponseEntity<ResponesDto> addParent(@RequestBody ParentDto parentDto) {
    parentService.addParent(parentDto);
    setResult result = new setResult();
    ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Add Parent Successfully");
    return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
  }

  @PostMapping("/updateParent")
  public ResponseEntity<ResponesDto> updateStudent(@RequestBody ParentDto parentDto) {
    parentService.updateParent(parentDto);
    setResult result = new setResult();
    ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Update Parent Successfully");
    return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
  }

  @PostMapping("/deleteParent")
  public ResponseEntity<ResponesDto> deleteStudent(@RequestBody ParentDto parentDto) {
    parentService.deleteParent(parentDto);
    setResult result = new setResult();
    ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Delete Parent Successfully");
    return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
  }
  
  @GetMapping("/selectParent")
  public List<ParentMaster> selectStudent(@RequestParam("school") Integer school) {
    return parentService.selectParent(school);
  }
  
  @GetMapping("/findByParentid")
  public ParentMaster finbyid(@RequestParam("id") Integer id) {
    ParentMaster stList = parentService.findById(id);
    return stList;
  }
  
  @GetMapping("/findByStudents")
  public ParentMaster findBystudents(@RequestParam("id") Integer id) {
	 Student st = studentSerivce.findById(id);
	 return pdao.findByStu(st);
  }

}
