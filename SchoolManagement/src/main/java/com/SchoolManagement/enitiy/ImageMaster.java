package com.SchoolManagement.enitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ImageMaster {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String image_name;
	
	@ManyToOne(targetEntity=ImageCatMaster.class)
	@JoinColumn(name = "cat_id")
	private ImageCatMaster cat;
	
	@ManyToOne(targetEntity=SchoolMaster.class)
	@JoinColumn(name = "school_id")
	private SchoolMaster school;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public ImageCatMaster getCat() {
		return cat;
	}

	public void setCat(ImageCatMaster cat) {
		this.cat = cat;
	}

	public SchoolMaster getSchool() {
		return school;
	}

	public void setSchool(SchoolMaster school) {
		this.school = school;
	}
	
	
	
}
