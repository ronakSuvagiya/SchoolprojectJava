package com.SchoolManagement.controlerMVC;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.SchoolManagement.dto.StudentDto;
import com.SchoolManagement.enitiy.AttendanceMaster;
import com.SchoolManagement.enitiy.ParentMaster;
import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.enitiy.Student;

@Controller
public class StudentController {

  @Autowired
  StdDio stdDio;

  @Autowired
  SchoolDao schoolDao;

  @RequestMapping("/add_student")
  public ModelAndView addTeacher(HttpServletRequest request) {
    ModelAndView model = new ModelAndView("add_student");
    model.addObject("school", (Integer) request.getSession().getAttribute(SessionUri.SchoolId));
    List<StdMaster> std = stdDio.findBySchool(
        schoolDao.findById((Integer) request.getSession().getAttribute(SessionUri.SchoolId)).get());
    model.addObject("StdName", std);
    return model;
  }

  @RequestMapping("/edit_student")
  public ModelAndView edit_student(@RequestParam("id") Integer id, HttpServletRequest request) {
    ModelAndView model = new ModelAndView("edit_student");
    RestTemplate rest = new RestTemplate();
    ResponseEntity<Student> reposEntity =
        rest.getForEntity(ApiUrl.FINDBYIDSTUDENT + id, Student.class);
    System.out.println(reposEntity);
    Student student = reposEntity.getBody();
    model.addObject("student", student);
    List<StdMaster> std = stdDio.findBySchool(
        schoolDao.findById((Integer) request.getSession().getAttribute(SessionUri.SchoolId)).get());
    model.addObject("StdName", std);
    model.addObject("school", (Integer) request.getSession().getAttribute(SessionUri.SchoolId));
    return model;
  }

  @RequestMapping("/edit_stu")
  public ModelAndView edit_student(@RequestParam("rollno") Integer rollno,
      @RequestParam("name") String name, @RequestParam(name = "lastName") String lastName,
      @RequestParam(name = "gender") String gender, @RequestParam(name = "dob") java.sql.Date dob,
      @RequestParam("std") String std, @RequestParam("div") String div,
      @RequestParam("oldstd") String oldstd, @RequestParam("oldrollno") Integer oldrollno,
      @RequestParam(name = "address") String address, HttpServletRequest request) {
    ModelAndView model = null;

    Integer schoolId = (Integer) request.getSession().getAttribute(SessionUri.SchoolId);
    StudentDto student =
        converDto(rollno, name, lastName, std, div, gender, address, dob, schoolId);

    student.setOldRollNo(oldrollno);
    student.setOldStd(oldstd);
    RestTemplate resttemp = new RestTemplate();
    HttpEntity<StudentDto> httpEntity = new HttpEntity<StudentDto>(student);
    ResponseEntity<ResponesDto> responseEntity =
        resttemp.postForEntity(ApiUrl.EDITSTUDENT, httpEntity, ResponesDto.class);

    System.out.println("==>" + responseEntity);
    model = allStudent(request);
    if (responseEntity.getStatusCode() == HttpStatus.OK) {
      ResponesDto repoDto = responseEntity.getBody();
      model.addObject("msg", repoDto);
    }

    return model;
  }

  @RequestMapping("/all_students")
  public ModelAndView allStudent(HttpServletRequest request) {
    ModelAndView model = new ModelAndView("all_students");
    System.out.println(ApiUrl.ALLSTUDENT + request.getSession().getAttribute(SessionUri.SchoolId));

    RestTemplate rest = new RestTemplate();
    ResponseEntity<Student[]> reposEntity = rest.getForEntity(
        ApiUrl.ALLSTUDENT + request.getSession().getAttribute(SessionUri.SchoolId),
        Student[].class);
    System.out.println(reposEntity);
    Student[] student = reposEntity.getBody();
    model.addObject("studentList", student);

    return model;

  }

  @RequestMapping("/add_stu")
  public ModelAndView add_student(@RequestParam("rollno") Integer rollno,
      @RequestParam("name") String name, @RequestParam(name = "lastName") String lastName,
      @RequestParam(name = "gender") String gender, @RequestParam(name = "dob") java.sql.Date dob,
      @RequestParam("std") String std, @RequestParam("div") String div,
      @RequestParam(name = "address") String address, HttpServletRequest request) {
    ModelAndView model = new ModelAndView("add_student");

    Integer schoolId = (Integer) request.getSession().getAttribute(SessionUri.SchoolId);
    System.out.println("=====>" + request.getSession().getAttribute(SessionUri.SchoolId));

    StudentDto student =
        converDto(rollno, name, lastName, std, div, gender, address, dob, schoolId);

    RestTemplate resttemp = new RestTemplate();
    HttpEntity<StudentDto> httpEntity = new HttpEntity<StudentDto>(student);
    ResponseEntity<ResponesDto> responseEntity =
        resttemp.postForEntity(ApiUrl.ADDSTUDENT, httpEntity, ResponesDto.class);

    model.addObject("school", (Integer) request.getSession().getAttribute(SessionUri.SchoolId));
    List<StdMaster> std1 = stdDio.findBySchool(
        schoolDao.findById((Integer) request.getSession().getAttribute(SessionUri.SchoolId)).get());
    model.addObject("StdName", std1);
    System.out.println("==>" + responseEntity);
    if (responseEntity.getStatusCode() == HttpStatus.OK) {
      ResponesDto repoDto = responseEntity.getBody();
      model.addObject("msg", repoDto);
    }
    return model;
  }

  
  @RequestMapping("/student_profile")
  public ModelAndView profile(@RequestParam("id") Integer id)
  {
	  ModelAndView model = new ModelAndView("student_profile");
	  RestTemplate rest = new RestTemplate();
	    ResponseEntity<ParentMaster> reposEntity =
	        rest.getForEntity(ApiUrl.FINDBYSTUDENTS + id, ParentMaster.class);
	    System.out.println(reposEntity);
	    ParentMaster parentMaster = reposEntity.getBody();
	    model.addObject("parent", parentMaster);
	  return model;
  }
  
  @RequestMapping("/reportAttendance")
  public ModelAndView report(@RequestParam("rollno") Integer rollno,@RequestParam("students") Integer sId,@RequestParam("div") Integer dId,@RequestParam("std") Integer stuId,@RequestParam("school") Integer schoolId,@RequestParam("start") Date Start ,@RequestParam("end") Date end)
  {
	  ModelAndView model = profile(sId);
	  RestTemplate rest = new RestTemplate();
	    ResponseEntity<AttendanceMaster[]> reposEntity =
	        rest.getForEntity(ApiUrl.AttendsanceReport + dId + "&std=" + stuId + "&school=" + schoolId + "&startingDate=" + Start + "&endDate="+ end, AttendanceMaster[].class);
	    System.out.println(reposEntity);
	    List<Date> pre = new ArrayList<>();
	    AttendanceMaster[] attendanceMasters = reposEntity.getBody();
	    for (AttendanceMaster attendanceMaster : attendanceMasters) {
	    	System.out.println("id" + attendanceMaster.getId());
	    	String roll =  attendanceMaster.getRollNo();
			String noList[] = roll.split(",");
			System.out.println(rollno);
			List<String> numberList = Arrays.asList(noList);
			if(numberList.contains(rollno.toString()))
			{
				pre.add(attendanceMaster.getDate());
			}
			
		}
	    model.addObject("DateList",pre);
	  return model;
  }
  
  public StudentDto converDto(Integer rollno, String name, String lastName, String std, String div,
      String gender, String address, java.sql.Date dob, Integer schooldId) {
    StudentDto student = new StudentDto();
    student.setAddress(address);
    student.setDiv(div);
    student.setDob(dob);
    student.setGender(gender);
    student.setLast_name(lastName);
    student.setName(name);
    student.setRoll_no(rollno);
    student.setSchool_id(schooldId);
    student.setStd(std);
    return student;
  }
}
