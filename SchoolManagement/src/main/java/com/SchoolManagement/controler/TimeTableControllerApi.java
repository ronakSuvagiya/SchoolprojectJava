package com.SchoolManagement.controler;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.SchoolManagement.activity.TimeTableActivity;
import com.SchoolManagement.activity.impl.SetTimeTablePDF;
import com.SchoolManagement.common.ResponesDto;
import com.SchoolManagement.common.setResult;
import com.SchoolManagement.dao.TimeTableDao;
import com.SchoolManagement.dto.ExamTimeTableDto;
import com.SchoolManagement.dto.TeacherTimeTableDto;
import com.SchoolManagement.dto.TimeTableDto;
import com.SchoolManagement.enitiy.TimeTableMaster;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

@RestController
public class TimeTableControllerApi {


	// time table for 0 and exam time table for 1
	
  @Autowired
  TimeTableActivity timeTableActivity;
  
  @Autowired
  TimeTableDao table;

  @Autowired
  ServletContext context;
  	
 // public static String uploadDir = "/WEB-INF/classes/static/timeTable/";
  
  public static String uploadDir = "/timeTable/";
  
  @RequestMapping("/setTimeTable")
  public ResponseEntity<ResponesDto> setTimeTable(@RequestBody TimeTableDto timeTableDto) {
    try {
    	String path = context.getRealPath(uploadDir);
      SetTimeTablePDF.setPdf(timeTableDto,path);
      timeTableActivity.addTimeTable(timeTableDto);
      setResult result = new setResult();
      ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Set TimeTabel Successfully");
      return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
    } catch (FileNotFoundException | DocumentException e) {
      // TODO Auto-generated catch block
      setResult result = new setResult();
      ResponesDto respone = result.setResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
      return new ResponseEntity<ResponesDto>(respone, HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping("/setTimeTableTeacherApi")
  public ResponseEntity<ResponesDto> setTimeTableTeacher(@RequestBody TeacherTimeTableDto timeTableDto) {
    try {
    	String path = context.getRealPath(uploadDir);
      SetTimeTablePDF.setPdfTeacher(timeTableDto, path);
      timeTableActivity.addTeacherTimeTable(timeTableDto);
      setResult result = new setResult();
      ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Set TimeTabel Successfully");
      return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
    } catch (FileNotFoundException | DocumentException e) {
      // TODO Auto-generated catch block
      setResult result = new setResult();
      ResponesDto respone = result.setResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
      return new ResponseEntity<ResponesDto>(respone, HttpStatus.BAD_REQUEST);
    }
  }

  
  @RequestMapping("/setExamTimeTable")
  public ResponseEntity<ResponesDto> setExamTimeTable(
      @RequestBody ExamTimeTableDto examTimeTableDto) {
    try {
    	String path = context.getRealPath(uploadDir);
      SetTimeTablePDF.setExamPdf(examTimeTableDto,path);
      timeTableActivity.addTimeTableExam(examTimeTableDto);
      setResult result = new setResult();
      ResponesDto respone =
          result.setResponse(HttpStatus.OK.value(), "Set Exam TimeTabel Successfully");
      return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
    } catch (FileNotFoundException | DocumentException | ParseException e) {
      // TODO Auto-generated catch block
      setResult result = new setResult();
      ResponesDto respone = result.setResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
      return new ResponseEntity<ResponesDto>(respone, HttpStatus.BAD_REQUEST);
    }
  }
  
  @GetMapping("/ApiGetTimeTable")
  public TimeTableMaster getTimeTable(@RequestParam("id") Integer divID) {
	  Integer i = new Integer(0);
	  return table.findByDivIdAndType(divID,i);
  }
  
  @GetMapping("/ApiGetTimeTableExam")
  public List<TimeTableMaster> getTimeTableExam(@RequestParam("Stdid") Integer divID) {
	  Integer i = new Integer(1);
	  return table.findByStdIdAndType(divID, i);
  }
  
  @GetMapping("/ApiGetTimeTableTeacher")
  public TimeTableMaster ApiGetTimeTableTeacher(@RequestParam("TecherID") Integer divID) {
	  return table.findByTeacherId(divID);
  }
}
