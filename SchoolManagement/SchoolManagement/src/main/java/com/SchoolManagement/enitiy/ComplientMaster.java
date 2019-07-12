package com.SchoolManagement.enitiy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ComplientMaster {

	@Id
	@GeneratedValue
	private Integer id;
	
	  @ManyToOne(targetEntity = Student.class, cascade = CascadeType.ALL)
	  @JoinColumn(name = "studentId")
	  private Student student;
	  
	  private String title;
	  
	  private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	  
	  
	  
	  
}
