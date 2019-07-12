package com.SchoolManagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SchoolManagement.enitiy.FeesMaster;
import com.SchoolManagement.enitiy.Student;

public interface FeesDao extends CrudRepository<FeesMaster, Integer> {

	public List<FeesMaster> findByStudent(Student student);
	
	public List<FeesMaster> findByStudentAndRecipt(Student stu,Boolean rec);
}
