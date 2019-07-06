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
import com.SchoolManagement.dto.TeacherDto;
import com.SchoolManagement.enitiy.TeacherMaster;
import com.SchoolManagement.service.TeacherSerivce;


@RestController
public class TeacherContarolerApi {

  @Autowired
  TeacherSerivce teacherService;

  @RequestMapping("/addTeacher")
  public ResponseEntity<ResponesDto> addTeacher(@RequestBody TeacherDto teacherDto) {
    teacherService.addTeacher(teacherDto);
    setResult result = new setResult();
    ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Add Teacher Successfully");
    return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
  }

  @PostMapping("/updateTeacher")
  public ResponseEntity<ResponesDto> updateTeacher(@RequestBody TeacherDto teacherDto) {
    teacherService.updateTeacher(teacherDto);
    setResult result = new setResult();
    ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Update Teacher Successfully");
    return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
  }

  @PostMapping("/deleteTeacher")
  public ResponseEntity<ResponesDto> deleteTeacher(@RequestBody TeacherDto teacherDto) {
    teacherService.deleteTeacher(teacherDto);
    setResult result = new setResult();
    ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Delete Teacher Successfully");
    return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
  }

  @GetMapping("/selectTeacher")
  public List<TeacherMaster> selectTeacher(@RequestParam("schoolId") Integer schoolId) {
    List<TeacherMaster> teList = teacherService.selectStudents(schoolId);
    return teList;
  }

  @GetMapping("/findByTeacherid")
  public TeacherMaster finbyid(@RequestParam("id") Integer id) {
    TeacherMaster teList = teacherService.findByTeacherid(id);
    return teList;
  }
}
