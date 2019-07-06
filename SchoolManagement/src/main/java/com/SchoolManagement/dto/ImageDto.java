package com.SchoolManagement.dto;

import org.springframework.web.multipart.MultipartFile;

public class ImageDto {
private Integer id;
	
	private MultipartFile image_name;
	
	
	private Integer cat;
	

	private Integer school;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	
	public MultipartFile getImage_name() {
		return image_name;
	}


	public void setImage_name(MultipartFile image_name) {
		this.image_name = image_name;
	}


	public Integer getCat() {
		return cat;
	}


	public void setCat(Integer cat) {
		this.cat = cat;
	}


	public Integer getSchool() {
		return school;
	}


	public void setSchool(Integer school) {
		this.school = school;
	}
	
	
	

}
