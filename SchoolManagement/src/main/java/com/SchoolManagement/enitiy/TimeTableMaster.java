package com.SchoolManagement.enitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TimeTableMaster {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String pdfName;

  @ManyToOne(targetEntity = StdMaster.class)
  @JoinColumn(name = "std_id")
  private StdMaster std;

  @ManyToOne(targetEntity = DivMaster.class)
  @JoinColumn(name = "div_id")
  private DivMaster div;

  @ManyToOne(targetEntity = SchoolMaster.class)
  @JoinColumn(name = "school_id")
  private SchoolMaster school;

  private Integer type;

  public DivMaster getDiv() {
    return div;
  }

  public void setDiv(DivMaster div) {
    this.div = div;
  }

  public SchoolMaster getSchool() {
    return school;
  }

  public void setSchool(SchoolMaster school) {
    this.school = school;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPdfName() {
    return pdfName;
  }

  public void setPdfName(String pdfName) {
    this.pdfName = pdfName;
  }

  public StdMaster getStd() {
    return std;
  }

  public void setStd(StdMaster std) {
    this.std = std;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }


}
