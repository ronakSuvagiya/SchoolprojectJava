package com.SchoolManagement.enitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FirebaseToken {

	@Id
	@GeneratedValue
	private Integer id;

	private String token;

	private String deviceId;

	@ManyToOne(targetEntity = SchoolMaster.class)
	@JoinColumn(name = "school_id")
	private SchoolMaster school;

	@ManyToOne(targetEntity = StdMaster.class)
	@JoinColumn(name = "std_id")
	private StdMaster std;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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

}
