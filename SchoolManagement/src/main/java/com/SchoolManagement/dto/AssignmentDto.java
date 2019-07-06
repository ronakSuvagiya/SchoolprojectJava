package com.SchoolManagement.dto;

import java.sql.Date;

public class AssignmentDto {
	

	private Date date;
	
	private Integer teacherMaster;
	
	private String description;
	
	private Integer subject;
	
	private Integer school;
	
	private Integer std;
		
	private Integer div;
	
	private Date created_on;
	
	
	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Integer getSchool() {
		return school;
	}

	public void setSchool(Integer school) {
		this.school = school;
	}

	public Integer getStd() {
		return std;
	}

	public void setStd(Integer std) {
		this.std = std;
	}

	public Integer getDiv() {
		return div;
	}

	public void setDiv(Integer div) {
		this.div = div;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getTeacherMaster() {
		return teacherMaster;
	}

	public void setTeacherMaster(Integer teacherMaster) {
		this.teacherMaster = teacherMaster;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSubject() {
		return subject;
	}

	public void setSubject(Integer subject) {
		this.subject = subject;
	}

	
	
}
