package com.SchoolManagement.dto;

import java.sql.Date;

public class HolidayDto {

	private Date date;
	
	private String Desc;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}
	
	
}
