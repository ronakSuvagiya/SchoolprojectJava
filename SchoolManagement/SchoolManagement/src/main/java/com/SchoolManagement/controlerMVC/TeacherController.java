package com.SchoolManagement.controlerMVC;

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
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dto.TeacherDto;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.enitiy.TeacherMaster;

@Controller
public class TeacherController {

  @Autowired
  HttpServletRequest request;

  @Autowired
  StdDio stdDio;

  @Autowired
  SchoolDao schoolDao;

  @RequestMapping("/add_professor")
  public ModelAndView addTeacher() {
    ModelAndView model = new ModelAndView("add_professor");
    System.out
        .println("school => " + (Integer) request.getSession().getAttribute(SessionUri.SchoolId));
    List<StdMaster> std = stdDio.findBySchool(
        schoolDao.findById((Integer) request.getSession().getAttribute(SessionUri.SchoolId)).get());
    model.addObject("StdName", std);
    return model;
  }

  @RequestMapping("/addPro")
  public ModelAndView addPro(@RequestParam(name = "teacherCode") String teacherCode,
      @RequestParam(name = "name") String name, @RequestParam(name = "lastName") String lastName,
      @RequestParam(name = "emailId") String Email,
      @RequestParam(name = "department") String department,
      @RequestParam(name = "gender") String gender,
      @RequestParam(name = "mobileNo") String mobileNo,
      @RequestParam(name = "dob") java.sql.Date dob, HttpServletRequest request) {
    ModelAndView model = new ModelAndView("add_professor");
    List<StdMaster> std = stdDio.findBySchool(
        schoolDao.findById((Integer) request.getSession().getAttribute(SessionUri.SchoolId)).get());
    model.addObject("StdName", std);

    Integer schoolId = (Integer) request.getSession().getAttribute(SessionUri.SchoolId);
    System.out.println("=====>" + request.getSession().getAttribute(SessionUri.SchoolId));
    TeacherDto teacher =
        converDto(teacherCode, name, lastName, Email, department, gender, mobileNo, dob, schoolId);


    RestTemplate resttemp = new RestTemplate();
    HttpEntity<TeacherDto> httpEntity = new HttpEntity<TeacherDto>(teacher);
    ResponseEntity<ResponesDto> responseEntity =
        resttemp.postForEntity(ApiUrl.ADDTEACHER, httpEntity, ResponesDto.class);

    System.out.println("==>" + responseEntity);
    if (responseEntity.getStatusCode() == HttpStatus.OK) {
      ResponesDto repoDto = responseEntity.getBody();
      model.addObject("msg", repoDto);
    }
    return model;
  }


  @RequestMapping("/all_professors")
  public ModelAndView allPro(HttpServletRequest request) {
    ModelAndView model = new ModelAndView("all_professors");
    System.out
        .println(ApiUrl.SELECTTEACHER + request.getSession().getAttribute(SessionUri.SchoolId));

    RestTemplate rest = new RestTemplate();
    ResponseEntity<TeacherMaster[]> reposEntity = rest.getForEntity(
        ApiUrl.SELECTTEACHER + request.getSession().getAttribute(SessionUri.SchoolId),
        TeacherMaster[].class);
    System.out.println(reposEntity);
    TeacherMaster[] tecaher = reposEntity.getBody();
    model.addObject("teacherList", tecaher);

    return model;
  }

  @RequestMapping("/edit_professor")
  public ModelAndView editPro(@RequestParam("id") Integer teId) {
    ModelAndView model = new ModelAndView("edit_professor");
    RestTemplate rest = new RestTemplate();
    ResponseEntity<TeacherMaster> reposEntity =
        rest.getForEntity(ApiUrl.FINDBYIDTEACHER + teId, TeacherMaster.class);
    System.out.println(reposEntity);
    TeacherMaster tecaher = reposEntity.getBody();
    model.addObject("teacher", tecaher);
    List<StdMaster> std = stdDio.findBySchool(
        schoolDao.findById((Integer) request.getSession().getAttribute(SessionUri.SchoolId)).get());
    model.addObject("StdName", std);
    return model;
  }

  @RequestMapping("/edit_pro")
  public ModelAndView edit_pro(@RequestParam(name = "teacherCode") String teacherCode,
      @RequestParam(name = "name") String name, @RequestParam(name = "lastName") String lastName,
      @RequestParam(name = "emailId") String Email,
      @RequestParam(name = "department") String department,
      @RequestParam(name = "gender") String gender,
      @RequestParam(name = "mobileNo") String mobileNo,
      @RequestParam(name = "dob") java.sql.Date dob, HttpServletRequest request) {
    ModelAndView model = null;
    List<StdMaster> std = stdDio.findBySchool(
        schoolDao.findById((Integer) request.getSession().getAttribute(SessionUri.SchoolId)).get());

    Integer schoolId = (Integer) request.getSession().getAttribute(SessionUri.SchoolId);
    System.out.println("=====>" + request.getSession().getAttribute(SessionUri.SchoolId));
    TeacherDto teacher =
        converDto(teacherCode, name, lastName, Email, department, gender, mobileNo, dob, schoolId);

    RestTemplate resttemp = new RestTemplate();
    HttpEntity<TeacherDto> httpEntity = new HttpEntity<TeacherDto>(teacher);
    ResponseEntity<ResponesDto> responseEntity =
        resttemp.postForEntity(ApiUrl.EDITTEACHER, httpEntity, ResponesDto.class);

    System.out.println("==>" + responseEntity);
    model = allPro(request);
    model.addObject("StdName", std);

    if (responseEntity.getStatusCode() == HttpStatus.OK) {
      ResponesDto repoDto = responseEntity.getBody();
      model.addObject("msg", repoDto);
    }

    return model;
  }

  public TeacherDto converDto(String teacherCode, String name, String lastName, String Email,
      String department, String gender, String mobileNo, java.sql.Date dob, Integer schooldId) {
    TeacherDto teacher = new TeacherDto();
    teacher.setTeacherCode(teacherCode);
    teacher.setName(name);
    teacher.setLastName(lastName);
    teacher.setDepartment(department);
    teacher.setDob(dob);
    teacher.setGender(gender);
    teacher.setEmailId(Email);
    teacher.setMobileNo(mobileNo);
    teacher.setSchoolId(schooldId);
    return teacher;
  }
}
