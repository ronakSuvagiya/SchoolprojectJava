package com.SchoolManagement.enitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StdMaster {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String stdName;
  
  private long fees;

  @ManyToOne(targetEntity = SchoolMaster.class)
  @JoinColumn(name = "school_id")
  private SchoolMaster school;

  public SchoolMaster getSchool() {
    return school;
  }

  public void setSchool(SchoolMaster school) {
    this.school = school;
  }

  public long getFees() {
	return fees;
}

public void setFees(long fees) {
	this.fees = fees;
}

public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getStdName() {
    return stdName;
  }

  public void setStdName(String stdName) {
    this.stdName = stdName;
  }


}
