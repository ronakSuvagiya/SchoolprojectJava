package com.SchoolManagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SchoolManagement.enitiy.ImageCatMaster;
import com.SchoolManagement.enitiy.SchoolMaster;

public interface ImageCatDao extends CrudRepository<ImageCatMaster, Integer> {

	public List<ImageCatMaster> findByschool(SchoolMaster school);

}
