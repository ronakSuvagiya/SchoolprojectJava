package com.SchoolManagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SchoolManagement.enitiy.FirebaseToken;
import com.SchoolManagement.enitiy.NotifactionData;

public interface NotifactionDataDao extends CrudRepository<NotifactionData, Integer> {

	public List<FirebaseToken> findBySchoolId(Integer id);
	
	public List<NotifactionData> findBySchoolIdAndSend(Integer id, String type);
	
	public List<NotifactionData> findBySchoolIdAndSendAndStdId(Integer id, String type,Integer stdid);
	
	
	public List<FirebaseToken> findBySchoolIdAndStdId(Integer id, Integer stdId);
}
