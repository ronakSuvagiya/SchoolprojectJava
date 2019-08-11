package com.SchoolManagement.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SchoolManagement.activity.impl.NotifactionSend;
import com.SchoolManagement.common.ResponesDto;
import com.SchoolManagement.common.setResult;
import com.SchoolManagement.dao.FirebaseTokenDao;
import com.SchoolManagement.dao.NotifactionDataDao;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dao.StdDio;
import com.SchoolManagement.dto.NotifactionDto;
import com.SchoolManagement.dto.TokenDto;
import com.SchoolManagement.enitiy.FirebaseToken;
import com.SchoolManagement.enitiy.NotifactionData;
import com.SchoolManagement.enitiy.NotifactionLog;
import com.google.firebase.messaging.BatchResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.MulticastMessage;
import com.google.firebase.messaging.SendResponse;

@RestController
public class NotifactionApi {

	@Autowired
	FirebaseTokenDao token;

	@Autowired
	StdDio stdDao;

	@Autowired
	NotifactionDataDao notifactionDataDao;

	@Autowired
	SchoolDao schoolDao;
	
	@Autowired
	NotifactionSend sendData;
	
	@Autowired
	FirebaseTokenDao firebaseToken;
	
	@PostMapping("/addTokenApi")
	public ResponseEntity<ResponesDto> addTopken(@RequestBody TokenDto tokanDto){
		FirebaseToken ftoken = new FirebaseToken();
		ftoken.setDeviceId(tokanDto.getDeviceID());
		ftoken.setToken(tokanDto.getTokan());
		ftoken.setSchool(schoolDao.findById(tokanDto.getSchool()).get());
		ftoken.setStd(stdDao.findById(tokanDto.getStd()).get());
		try {
			firebaseToken.save(ftoken);
			setResult result = new setResult();
			ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Token Add Successfully");
			return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			setResult result = new setResult();
			ResponesDto respone = result.setResponse(300, "Something is worng");
			return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
		}
	}
	
	@PostMapping("/updateTokenApi")
	public  ResponseEntity<ResponesDto> UadteTopken(@RequestBody TokenDto tokanDto){
		FirebaseToken ftoken = firebaseToken.findByDeviceId(tokanDto.getDeviceID());
		ftoken.setDeviceId(tokanDto.getDeviceID());
		ftoken.setToken(tokanDto.getTokan());
		ftoken.setSchool(schoolDao.findById(tokanDto.getSchool()).get());
		ftoken.setStd(stdDao.findById(tokanDto.getStd()).get());
		try {
			firebaseToken.save(ftoken);
			setResult result = new setResult();
			ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Token Add Successfully");
			return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			setResult result = new setResult();
			ResponesDto respone = result.setResponse(300, "Something is worng");
			return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
		}
	}
	@PostMapping("/sendNotifactionApi")
	public ResponseEntity<ResponesDto> sendNotifaction(@RequestBody NotifactionDto notiDto) {
		NotifactionData notiData = new NotifactionData();
		notiData.setData(notiDto.getData());
		notiData.setTitle(notiDto.getTitle());
		notiData.setSchool(schoolDao.findById(notiDto.getId()).get());
		notiData.setSend(notiDto.getType());
		if (notiDto.getType().equals("Std")) {
			notiData.setStd(stdDao.findById(notiDto.getStd()).get());
		}
		try {
			List<String> tokenf = new ArrayList<String>();
			List<FirebaseToken> firebaseToken = new ArrayList<>();
			notifactionDataDao.save(notiData);
			System.out.println(notiDto.getType().equals("All"));
			if (notiDto.getType().equals("All")) {
				firebaseToken = token.findBySchoolId(notiDto.getId());
				System.out.println(firebaseToken.size());
				for (int i = 0; i <= firebaseToken.size()-1; i++) {
					System.out.println("call" + i);
					tokenf.add(firebaseToken.get(i).getToken());
					if (i >= 99) {
						// call
						sendData.send(tokenf, notiDto.getData(), notiDto.getTitle(), notiDto.getId());
						tokenf.removeAll(tokenf);
					}
				}
				sendData.send(tokenf, notiDto.getData(), notiDto.getTitle(), notiDto.getId());
			} else if (notiDto.getType().equals("Std")) {
				firebaseToken = token.findBySchoolIdAndStdId( notiDto.getId(), notiDto.getStd());
				for (int i = 0; i <= firebaseToken.size()-1; i++) {
					tokenf.add(firebaseToken.get(i).getToken());
					if (i >= 99) {

						// call
						sendData.send(tokenf,  notiDto.getData(), notiDto.getTitle(), notiDto.getId());
						tokenf.removeAll(tokenf);
					}
				}
				sendData.send(tokenf,  notiDto.getData(), notiDto.getTitle(), notiDto.getId());
			}

			setResult result = new setResult();
			ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Notifaction Send Successfully");
			return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			setResult result = new setResult();
			ResponesDto respone = result.setResponse(300, "Something is worng");
			return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
		}

	}
	
	@GetMapping("/getDataApi")
	public List<NotifactionData> getData(@RequestParam("school")Integer id, @RequestParam("std") Integer std){
		List<NotifactionData> data = notifactionDataDao.findBySchoolIdAndSend(id, "All");
		List<NotifactionData> data1 = notifactionDataDao.findBySchoolIdAndSendAndStdId(id, "Std", std);
		data.addAll(data1);
		return data;
	}
}
