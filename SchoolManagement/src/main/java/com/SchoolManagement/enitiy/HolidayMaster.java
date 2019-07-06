package com.SchoolManagement.enitiy;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HolidayMaster {

	@Id
	@GeneratedValue
	private Integer id;
	
	private Date date;
	
	private String title;
	
	@ManyToOne(targetEntity=SchoolMaster.class)
	@JoinColumn(name="school_id")
	SchoolMaster school;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	
	
}
