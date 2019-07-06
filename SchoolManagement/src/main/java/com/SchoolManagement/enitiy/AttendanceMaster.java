package com.SchoolManagement.enitiy;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AttendanceMaster {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(targetEntity = SchoolMaster.class)
  @JoinColumn(name = "school_id")
  private SchoolMaster school;

  @ManyToOne(targetEntity = StdMaster.class)
  @JoinColumn(name = "std_id")
  private StdMaster std;


  @ManyToOne(targetEntity = DivMaster.class)
  @JoinColumn(name = "div_id")
  private DivMaster div;

  private String rollNo;

  private Date date;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public DivMaster getDiv() {
    return div;
  }

  public void setDiv(DivMaster div) {
    this.div = div;
  }

  public String getRollNo() {
    return rollNo;
  }

  public void setRollNo(String rollNo) {
    this.rollNo = rollNo;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }



}
