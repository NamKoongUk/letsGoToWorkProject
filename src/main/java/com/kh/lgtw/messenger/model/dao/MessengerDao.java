package com.kh.lgtw.messenger.model.dao;

import java.util.Map;

public interface MessengerDao {

	String sendMessenger(Map<String, Object> params);

	String deleteMessenger(String msgNo);

	String selectStorageMessenger(String msgGno);

	String selectDetailMessneger(String msgNo);

}
