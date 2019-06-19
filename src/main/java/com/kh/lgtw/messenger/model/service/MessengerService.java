package com.kh.lgtw.messenger.model.service;

import java.util.Map;

public interface MessengerService {

	String sendMessenger(Map<String, Object> params);

	String deleteMessenger(String msgNo);

	String selectStorageMessenger(String msgGno);

	String selectDetailMessneger(String msgNo);


}
