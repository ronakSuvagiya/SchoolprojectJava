package com.SchoolManagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SchoolManagement.enitiy.ImageMaster;

@Repository
public interface ImageDao extends CrudRepository<ImageMaster, Integer> {

	public List<ImageMaster> findImageMasterBySchoolId(Integer id);
}
