package com.SchoolManagement.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SchoolManagement.enitiy.AssignmentMaster;
import com.SchoolManagement.enitiy.DivMaster;
import com.SchoolManagement.enitiy.SchoolMaster;
import com.SchoolManagement.enitiy.StdMaster;

public interface AssignmentDao extends CrudRepository<AssignmentMaster, Integer>{

	public AssignmentMaster findBySchoolAndStdAndDivIdAndDate(SchoolMaster sc, StdMaster std,DivMaster div,Date dDate);
	
	public List<AssignmentMaster> findByStdAndDivIdAndDate(StdMaster std,DivMaster div,Date Created_on);
	
	public List<AssignmentMaster> findByStdAndDivIdAndAssign(StdMaster std,DivMaster div,Date date);
	
}
