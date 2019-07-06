package com.SchoolManagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SchoolManagement.enitiy.EventMaster;
import com.SchoolManagement.enitiy.SchoolMaster;

public interface EventDao extends CrudRepository<EventMaster, Integer> {

	public List<EventMaster> findBySchool(SchoolMaster school);
}
