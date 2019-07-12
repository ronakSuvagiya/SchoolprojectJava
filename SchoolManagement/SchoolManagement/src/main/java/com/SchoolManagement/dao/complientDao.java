package com.SchoolManagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SchoolManagement.enitiy.ComplientMaster;
import com.SchoolManagement.enitiy.Student;

public interface complientDao extends CrudRepository<ComplientMaster, Integer> {
	
	public List<ComplientMaster> findByStudent(Student student);

}
