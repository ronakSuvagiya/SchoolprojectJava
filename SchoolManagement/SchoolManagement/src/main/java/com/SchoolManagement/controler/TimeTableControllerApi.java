package com.SchoolManagement.controler;

import java.io.FileNotFoundException;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SchoolManagement.activity.TimeTableActivity;
import com.SchoolManagement.activity.impl.SetTimeTablePDF;
import com.SchoolManagement.common.ResponesDto;
import com.SchoolManagement.common.setResult;
import com.SchoolManagement.dto.ExamTimeTableDto;
import com.SchoolManagement.dto.TimeTableDto;
import com.itextpdf.text.DocumentException;

@RestController
public class TimeTableControllerApi {


  @Autowired
  TimeTableActivity timeTableActivity;

  @RequestMapping("/setTimeTable")
  public ResponseEntity<ResponesDto> setTimeTable(@RequestBody TimeTableDto timeTableDto) {
    try {
      SetTimeTablePDF.setPdf(timeTableDto);
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

  @RequestMapping("/setExamTimeTable")
  public ResponseEntity<ResponesDto> setExamTimeTable(
      @RequestBody ExamTimeTableDto examTimeTableDto) {
    try {
      SetTimeTablePDF.setExamPdf(examTimeTableDto);
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
}
