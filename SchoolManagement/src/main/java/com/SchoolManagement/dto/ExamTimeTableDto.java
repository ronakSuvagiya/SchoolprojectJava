package com.SchoolManagement.dto;

public class ExamTimeTableDto {

  public String date;

  public String S_time;

  public String E_time;

  public String subject;

  public Integer std_id;

  public Integer school_id;

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getS_time() {
    return S_time;
  }

  public void setS_time(String s_time) {
    S_time = s_time;
  }

  public String getE_time() {
    return E_time;
  }

  public void setE_time(String e_time) {
    E_time = e_time;
  }

  public String getSubject() {
    return subject;
  }

  public Integer getStd_id() {
    return std_id;
  }

  public void setStd_id(Integer std_id) {
    this.std_id = std_id;
  }

  public Integer getSchool_id() {
    return school_id;
  }

  public void setSchool_id(Integer school_id) {
    this.school_id = school_id;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }



}
