package com.SchoolManagement.enitiy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ParentMaster {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String lastName;

  private String emialID;

  private String userName;

  private String mobileNo;

  private String password;

  @ManyToOne(targetEntity = Student.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "studentId")
  private Student stu;
  

  @ManyToOne(targetEntity = SchoolMaster.class)
  @JoinColumn(name = "school_id")
  private SchoolMaster school;

  public SchoolMaster getSchool() {
	return school;
}

public void setSchool(SchoolMaster school) {
	this.school = school;
}

public String getMobileNo() {
    return mobileNo;
  }

  public void setMobileNo(String mobileNo) {
    this.mobileNo = mobileNo;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmialID() {
    return emialID;
  }

  public void setEmialID(String emialID) {
    this.emialID = emialID;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Student getStu() {
    return stu;
  }

  public void setStu(Student stu) {
    this.stu = stu;
  }


}
