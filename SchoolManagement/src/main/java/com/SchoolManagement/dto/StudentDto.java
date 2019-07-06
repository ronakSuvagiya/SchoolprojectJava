package com.SchoolManagement.dto;

import java.sql.Date;

public class StudentDto {

  private Integer roll_no;

  private String name;

  private String mobile_no;

  private Date dob;

  private String std;

  private String div;

  private String last_name;

  private Integer school_id;

  private String address;

  private String gender;

  private Integer oldRollNo;

  private String oldStd;


  public Integer getOldRollNo() {
    return oldRollNo;
  }

  public void setOldRollNo(Integer oldRollNo) {
    this.oldRollNo = oldRollNo;
  }

  public String getOldStd() {
    return oldStd;
  }

  public void setOldStd(String oldStd) {
    this.oldStd = oldStd;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getRoll_no() {
    return roll_no;
  }

  public void setRoll_no(Integer roll_no) {
    this.roll_no = roll_no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMobile_no() {
    return mobile_no;
  }

  public void setMobile_no(String mobile_no) {
    this.mobile_no = mobile_no;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public String getStd() {
    return std;
  }

  public void setStd(String std) {
    this.std = std;
  }

  public String getDiv() {
    return div;
  }

  public void setDiv(String div) {
    this.div = div;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public Integer getSchool_id() {
    return school_id;
  }

  public void setSchool_id(Integer school_id) {
    this.school_id = school_id;
  }



}
