package com.kh.lgtw.messenger.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface MessengerDao {
	
	//Messenger 전송
	int sendMessenger(Map<String, Object> params, SqlSession sqlSession);
	
	//Messenger 조회
	ArrayList<HashMap<String, Object>> selectMessenger(Map<String, Object> params, SqlSession sqlSession);
	
	//Messenger Count 조회
	int selectMessengerCount(Map<String, Object> params, SqlSession sqlSession);
	
	String deleteMessenger(String msgNo);

	String selectStorageMessenger(String msgGno);

	String selectDetailMessneger(String msgNo);
}
