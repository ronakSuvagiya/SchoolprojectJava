package com.SchoolManagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SchoolManagement.enitiy.StdMaster;
import com.SchoolManagement.enitiy.SubjectMaster;

public interface SubjectDao extends CrudRepository<SubjectMaster, Integer> {
	
	public List<SubjectMaster> findByStd(StdMaster std);

}
