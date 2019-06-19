package com.kh.lgtw.messenger.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lgtw.messenger.model.dao.MessengerDao;

@Service
public class MessengerServiceImpl implements MessengerService {
	@Autowired
	private MessengerDao md;
	
	@Override
	public String sendMessenger(Map<String, Object> params) {
		
		return md.sendMessenger(params);
	}

	@Override
	public String deleteMessenger(String msgNo) {
		// TODO Auto-generated method stub
		return md.deleteMessenger(msgNo);
	}

	@Override
	public String selectStorageMessenger(String msgGno) {
		// TODO Auto-generated method stub
		return md.selectStorageMessenger(msgGno);
	}

	@Override
	public String selectDetailMessneger(String msgNo) {
		// TODO Auto-generated method stub
		return md.selectDetailMessneger(msgNo);
	}

}
