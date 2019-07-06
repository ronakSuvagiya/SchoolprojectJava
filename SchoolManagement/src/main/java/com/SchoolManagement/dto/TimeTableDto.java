package com.SchoolManagement.dto;

public class TimeTableDto {

  private Integer std_id;

  private Integer div_id;

  private Integer school_id;

  private String mon;

  private String tue;

  private String wed;

  private String thu;

  private String fri;

  private String sat;


  public Integer getSchool_id() {
    return school_id;
  }

  public void setSchool_id(Integer school_id) {
    this.school_id = school_id;
  }

  public Integer getStd_id() {
    return std_id;
  }

  public void setStd_id(Integer std_id) {
    this.std_id = std_id;
  }

  public Integer getDiv_id() {
    return div_id;
  }

  public void setDiv_id(Integer div_id) {
    this.div_id = div_id;
  }

  public String getMon() {
    return mon;
  }

  public void setMon(String mon) {
    this.mon = mon;
  }

  public String getTue() {
    return tue;
  }

  public void setTue(String tue) {
    this.tue = tue;
  }

  public String getWed() {
    return wed;
  }

  public void setWed(String wed) {
    this.wed = wed;
  }

  public String getThu() {
    return thu;
  }

  public void setThu(String thu) {
    this.thu = thu;
  }

  public String getFri() {
    return fri;
  }

  public void setFri(String fri) {
    this.fri = fri;
  }

  public String getSat() {
    return sat;
  }

  public void setSat(String sat) {
    this.sat = sat;
  }


}
