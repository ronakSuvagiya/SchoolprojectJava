package com.SchoolManagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SchoolManagement.enitiy.ImageMaster;

public interface ImageDao extends CrudRepository<ImageMaster, Integer> {
	public List<ImageMaster> findImageMasterBySchoolId(Integer id);
}
