package com.SchoolManagement.enitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SubjectMaster {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	@ManyToOne(targetEntity = StdMaster.class)
	@JoinColumn(name = "std_id")
	private StdMaster std;

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

	public StdMaster getStd() {
		return std;
	}

	public void setStd(StdMaster std) {
		this.std = std;
	} 
}
