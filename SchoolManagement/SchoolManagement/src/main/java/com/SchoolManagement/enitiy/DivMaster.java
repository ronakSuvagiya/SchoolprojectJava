package com.SchoolManagement.enitiy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DivMaster {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @ManyToOne(targetEntity = StdMaster.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "std_id")
  private StdMaster stdId;

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

  public StdMaster getStdId() {
    return stdId;
  }

  public void setStdId(StdMaster stdId) {
    this.stdId = stdId;
  }


}
