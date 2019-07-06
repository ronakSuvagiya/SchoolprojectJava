package com.SchoolManagement.enitiy;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EventMaster {

	@Id
	@GeneratedValue
	private Integer id;
	
	private Date startDate;
	
	private Date endDate;
	
	private String startTime;
	
	private String title;
	
	@ManyToOne(targetEntity=SchoolMaster.class,cascade=CascadeType.ALL)
	@JoinColumn(name="school_id")
	private SchoolMaster school;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SchoolMaster getSchool() {
		return school;
	}

	public void setSchool(SchoolMaster school) {
		this.school = school;
	}


	
}
