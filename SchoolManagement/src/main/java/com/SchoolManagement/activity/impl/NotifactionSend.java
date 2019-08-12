package com.SchoolManagement.activity.impl;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SchoolManagement.dao.NotifactionLogDao;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.enitiy.NotifactionLog;



@Service
public class NotifactionSend {

	@Autowired
	SchoolDao schoolDao;
	
	@Autowired
	NotifactionLogDao dao;
	
	public void send(List<String> tokan,String Data,String title,Integer id) throws IOException {
		
	System.out.println("notifaction");
		JSONObject message = new JSONObject();
		message.put("registration_ids", tokan);
		message.put("priority", "high");

		JSONObject notification = new JSONObject();
		notification.put("title", title);
		notification.put("detail", Data);

		message.put("data", notification);
	
		System.out.println(message.toString());
		RestTemplate resttemp = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type","application/json");
		headers.set("Authorization", "key=AAAA7xSn4Yw:APA91bGaNhGlWvkhl1VxxhLoMHsLW2kv6ahnX-lMJYBhg1lmCpyPMBe4HlRAWa6CM3DaybfLqVv_N-FHJ3NLqQoTE2CJ5czRWxlvK1us8DgSNOwGMEU22ouHRrOkJNkdLjVX8aNDJozR");
		
		HttpEntity<String> entity = new HttpEntity<String>(message.toString(),headers);
		String result = resttemp.postForObject("https://fcm.googleapis.com/fcm/send", entity, String.class);
		System.out.println(result);

		JSONObject json = new JSONObject(result);
			NotifactionLog log = new NotifactionLog();
			log.setFail(json.getInt("failure"));
			log.setSchool(schoolDao.findById(id).get());
			log.setTotal(tokan.size());
			log.setSend(json.getInt("success"));
			dao.save(log);
		
	}
}
