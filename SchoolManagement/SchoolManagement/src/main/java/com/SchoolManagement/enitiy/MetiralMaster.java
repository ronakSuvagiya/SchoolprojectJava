package com.SchoolManagement.enitiy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MetiralMaster {

	@Id
	@GeneratedValue
	private Integer id;

	private String doc_name;

	@ManyToOne(targetEntity = SubjectMaster.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "subject_id")
	private SubjectMaster sub;

	@ManyToOne(targetEntity = SchoolMaster.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "school_id")
	private SchoolMaster school;
	
	@ManyToOne(targetEntity = StdMaster.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "std_id")
	private StdMaster std;
	
	

	public StdMaster getStd() {
		return std;
	}

	public void setStd(StdMaster std) {
		this.std = std;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDoc_name() {
		return doc_name;
	}

	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	public SubjectMaster getSub() {
		return sub;
	}

	public void setSub(SubjectMaster sub) {
		this.sub = sub;
	}

	public SchoolMaster getSchool() {
		return school;
	}

	public void setSchool(SchoolMaster school) {
		this.school = school;
	}

}
