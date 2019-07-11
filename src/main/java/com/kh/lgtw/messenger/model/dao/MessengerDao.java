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
	
	//MessengerDetail 조회
	HashMap<String, Object> selectDetailMessneger(Map<String, Object> params, SqlSession sqlSession);
	
	//reSendMessneger
	int reSendMessneger(Map<String, Object> params, SqlSession sqlSession);
	
	//메세지 삭제
	int deleteMessenger(Map<String, Object> params, SqlSession sqlSession);
	
	//조회시 메세지 읽음상태 변경
	int updateReadStatus(Map<String, Object> params, SqlSession sqlSession);

	//임시저장 메세지 수정
	int updateMessenger(Map<String, Object> params, SqlSession sqlSession);

	ArrayList<HashMap<String, Object>> getStoDetail(Map<String, Object> params, SqlSession sqlSession);
	
	//stoSend
	int stoSendMessenger(Map<String, Object> params, SqlSession sqlSession);

	int delMessenger(Map<String, Object> params, SqlSession sqlSession);

	
}
