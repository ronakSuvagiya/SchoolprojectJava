package com.SchoolManagement.enitiy;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AssignmentMaster {

	@Id
	@GeneratedValue
	private Integer Id;

	private Date date;
	
	private Date assign;

	@ManyToOne(targetEntity = TeacherMaster.class)
	@JoinColumn(name = "createBy")
	private TeacherMaster teacherMaster;

	private String description;

	@ManyToOne(targetEntity = SubjectMaster.class)
	@JoinColumn(name = "subject_id")
	private SubjectMaster subject;

	@ManyToOne(targetEntity = SchoolMaster.class)
	@JoinColumn(name = "school_id")
	private SchoolMaster school;

	@ManyToOne(targetEntity = StdMaster.class)
	@JoinColumn(name = "std_id")
	private StdMaster std;

	@ManyToOne(targetEntity = DivMaster.class)
	@JoinColumn(name = "div_id")
	private DivMaster divId;
	
	public Date getAssign() {
		return assign;
	}

	public void setAssign(Date assign) {
		this.assign = assign;
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

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TeacherMaster getTeacherMaster() {
		return teacherMaster;
	}

	public void setTeacherMaster(TeacherMaster teacherMaster) {
		this.teacherMaster = teacherMaster;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SubjectMaster getSubject() {
		return subject;
	}

	public void setSubject(SubjectMaster subject) {
		this.subject = subject;
	}

}
