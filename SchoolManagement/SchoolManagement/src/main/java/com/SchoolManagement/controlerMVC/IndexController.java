package com.SchoolManagement.controlerMVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.SchoolManagement.ApiUri.SessionUri;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StudentDio;
import com.SchoolManagement.dao.TeacherDio;
import com.SchoolManagement.enitiy.SchoolMaster;

@Controller
public class IndexController {

	@Autowired
	StudentDio st;
	
	@Autowired
	SchoolDao school;
	
	@Autowired
	TeacherDio tDao;
	
  @RequestMapping("/index")
  public ModelAndView index(HttpServletRequest request) {
    ModelAndView model = null;
    if(request.getSession() == null)
    {
    	model =new ModelAndView("login");
    	return model;
    }
    else
    {
    model = new ModelAndView("index");
    SchoolMaster sch = school.findById((Integer)request.getSession().getAttribute(SessionUri.SchoolId)).get();
    model.addObject("StudentCount", st.countBySchool(sch));
    model.addObject("techaerCount",tDao.countBySchoolId(sch));
    return model;
    }
  }
  
  @RequestMapping("/")
  public ModelAndView main(HttpServletRequest req) {
	  return index(req);
  }
}
