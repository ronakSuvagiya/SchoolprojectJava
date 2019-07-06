package com.SchoolManagement.enitiy;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer rollNo;

  private String name;

  private String lastName;

  private String mobileNo;

  private String gender;

  private Date dob;

  private String username;

  private String password;

  private String address;

  @ManyToOne(targetEntity = SchoolMaster.class)
  @JoinColumn(name = "school_id")
  private SchoolMaster school;

  @ManyToOne(targetEntity = StdMaster.class)
  @JoinColumn(name = "std_id")
  private StdMaster std;


  @ManyToOne(targetEntity = DivMaster.class)
  @JoinColumn(name = "div_id")
  private DivMaster divId;


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


  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getRollNo() {
    return rollNo;
  }


  public void setRollNo(Integer rollNo) {
    this.rollNo = rollNo;
  }


  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public String getMobileNo() {
    return mobileNo;
  }


  public void setMobileNo(String mobileNo) {
    this.mobileNo = mobileNo;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }



  public Date getDob() {
    return dob;
  }


  public void setDob(Date dob) {
    this.dob = dob;
  }


  public String getUsername() {
    return username;
  }


  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }


  public SchoolMaster getSchool() {
    return school;
  }


  public void setSchool(SchoolMaster school) {
    this.school = school;
  }


  public StdMaster getStd() {
    return std;
  }


  public void setStd(StdMaster std) {
    this.std = std;
  }


  public DivMaster getDivId() {
    return divId;
  }


  public void setDivId(DivMaster divId) {
    this.divId = divId;
  }



}
