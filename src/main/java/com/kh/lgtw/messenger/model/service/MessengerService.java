package com.kh.lgtw.messenger.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface MessengerService {
	//Messenger 전송
	int sendMessenger(Map<String, Object> params);
	
	//Messenger 조회
	ArrayList<HashMap<String, Object>> selectMessenger(Map<String, Object> params);
	
	//MessengerCount 조회
	int selectMessengerCount(Map<String, Object> params);
	
	String deleteMessenger(String msgNo);

	String selectStorageMessenger(String msgGno);

	String selectDetailMessneger(String msgNo);


}
