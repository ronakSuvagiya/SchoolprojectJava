package com.SchoolManagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SchoolManagement.enitiy.FirebaseToken;

public interface FirebaseTokenDao extends CrudRepository<FirebaseToken, Integer> {
	
	public FirebaseToken findByDeviceId(String id);

	public List<FirebaseToken> findBySchoolIdAndStdId(Integer id, Integer stdId);
	
	public List<FirebaseToken> findBySchoolId(Integer id);
}
