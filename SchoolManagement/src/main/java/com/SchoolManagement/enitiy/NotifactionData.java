package com.SchoolManagement.enitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class NotifactionData {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String data;
	
	@ManyToOne(targetEntity = SchoolMaster.class)
	@JoinColumn(name = "school_id")
	private SchoolMaster school;
	
	@ManyToOne(targetEntity = StdMaster.class)
	@JoinColumn(name = "std_id")
	private StdMaster std;
	
	private String send;

	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public StdMaster getStd() {
		return std;
	}

	public void setStd(StdMaster std) {
		this.std = std;
	}

	public String getSend() {
		return send;
	}

	public void setSend(String send) {
		this.send = send;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public SchoolMaster getSchool() {
		return school;
	}

	public void setSchool(SchoolMaster school) {
		this.school = school;
	}

	
}
