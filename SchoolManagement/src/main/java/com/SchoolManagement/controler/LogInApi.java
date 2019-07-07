package com.SchoolManagement.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolManagement.dao.ParentDao;
import com.SchoolManagement.dto.LoginDto;
import com.SchoolManagement.enitiy.ParentMaster;
import com.SchoolManagement.enitiy.TeacherMaster;
import com.SchoolManagement.service.LoginApiService;

@RestController
public class LogInApi {

  @Autowired
  LoginApiService loginService;
  
  @Autowired
  ParentDao parentDao;

  @RequestMapping("/Teacherlogin")
  public TeacherMaster TeacherloginApi(@RequestBody LoginDto login) {
    TeacherMaster techer = loginService.TeacherloginApi(login.getUserName(), login.getPass());
    return techer;
  }

  @RequestMapping("/studentLogin")
  public ParentMaster studentLoginApi(@RequestParam(name = "username", required = true) String username,
      @RequestParam(name = "pass", required = true) String pass) {
	  return parentDao.findByUserNameAndPassword(username, pass);
  }

  @RequestMapping("/PrentLogin")
  public ParentMaster PrentLoginApi(@RequestParam(name = "username", required = true) String username,
      @RequestParam(name = "pass", required = true) String pass) {
	  return parentDao.findByUserNameAndPassword(username, pass);
  }
}
