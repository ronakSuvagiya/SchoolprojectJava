package com.SchoolManagement.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.SchoolManagement.dto.LoginDto;
import com.SchoolManagement.enitiy.TeacherMaster;
import com.SchoolManagement.service.LoginApiService;

@RestController
public class LogInApi {

  @Autowired
  LoginApiService loginService;

  @RequestMapping("/Teacherlogin")
  public TeacherMaster TeacherloginApi(@RequestBody LoginDto login) {
    TeacherMaster techer = loginService.TeacherloginApi(login.getUserName(), login.getPass());
    return techer;
  }

  @RequestMapping("/studentLogin")
  public void studentLoginApi(@RequestParam(name = "username", required = true) String username,
      @RequestParam(name = "pass", required = true) String pass) {

  }

  @RequestMapping("/PrentLogin")
  public void PrentLoginApi(@RequestParam(name = "username", required = true) String username,
      @RequestParam(name = "pass", required = true) String pass) {

  }
}
