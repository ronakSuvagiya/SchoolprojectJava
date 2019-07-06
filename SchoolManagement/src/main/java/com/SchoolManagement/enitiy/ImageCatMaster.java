package com.SchoolManagement.enitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ImageCatMaster {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@ManyToOne(targetEntity=SchoolMaster.class)
	@JoinColumn(name = "school_id")
	private SchoolMaster school;

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

	public SchoolMaster getSchool() {
		return school;
	}

	public void setSchool(SchoolMaster school) {
		this.school = school;
	}
	
	
	
}
