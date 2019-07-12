package com.SchoolManagement.controlerMVC;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.SchoolManagement.ApiUri.ApiUrl;
import com.SchoolManagement.ApiUri.SessionUri;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dto.LoginDto;
import com.SchoolManagement.enitiy.TeacherMaster;

@Controller
public class LogInContaroller {

  @Autowired
  SchoolDao schoolDao;

  @Autowired
  IndexController index;

  @RequestMapping("/login")
  public ModelAndView login() {
    ModelAndView model = new ModelAndView("login");
    return model;
  }

  @PostMapping("/loginData")
  public ModelAndView loginData(@RequestParam("userName") String username,
      @RequestParam("pass") String pass, HttpServletRequest request) {
    ModelAndView model;
    LoginDto login = new LoginDto();
    login.setUserName(username);
    login.setPass(pass);
    // service call
    RestTemplate restTemplent = new RestTemplate();
    HttpEntity<LoginDto> httpEntity = new HttpEntity<LoginDto>(login);
    ResponseEntity<TeacherMaster> responseEntity =
        restTemplent.postForEntity(ApiUrl.TEACHERLOGINURL, httpEntity, TeacherMaster.class);
    if (responseEntity.getStatusCode() == HttpStatus.OK) {
      TeacherMaster teacher = responseEntity.getBody();
      if (teacher != null) {
        System.out.println(teacher.getSchoolId().getId());
        request.getSession().setAttribute(SessionUri.SchoolId, teacher.getSchoolId().getId());
        request.getSession().setAttribute(SessionUri.techerId, teacher.getId());
        request.getSession().setAttribute(SessionUri.TecherName, teacher.getName());
        model = index.index(request);
      } else {
        model = new ModelAndView("login");
        model.addObject("InvaildMessage", "Invaild Username And Password");
      }
    } else {
      model = new ModelAndView("login");
      model.addObject("ServiceMessage", responseEntity.getStatusCodeValue());
    }
    return model;
  }

  @RequestMapping("/logout")
  public ModelAndView logout(HttpServletRequest request) {
    request.getSession().invalidate();
    ModelAndView model = new ModelAndView("login");
    return model;
  }
}
