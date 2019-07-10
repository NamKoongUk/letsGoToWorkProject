package com.kh.lgtw.messenger.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lgtw.messenger.model.dao.MessengerDao;

@Service
public class MessengerServiceImpl implements MessengerService {
	@Autowired
	private MessengerDao md;
	@Autowired
	private SqlSession sqlSession; 
	
	//Messenger 전송
	@Override
	public int sendMessenger(Map<String, Object> params) {	
		return md.sendMessenger(params, sqlSession);
	}
	
	//Messenger 조회
	@Override
	public ArrayList<HashMap<String, Object>> selectMessenger(Map<String, Object> params) {
		return md.selectMessenger(params, sqlSession);
	}
	
	//Messenger Count 조회
	@Override
	public int selectMessengerCount(Map<String, Object> params) {
		return md.selectMessengerCount(params, sqlSession);
	}
	
	//MessengerDatail 조회
	@Override
	public HashMap<String, Object> selectDetailMessneger(Map<String, Object> params) {
		if(params.get("messageType").equals("res")){
			int result = md.updateReadStatus(params,sqlSession);
		}
		return md.selectDetailMessneger(params, sqlSession);
	}
	//reSendMessenger
	@Override
	public int reSendMessneger(Map<String, Object> params) {
		return md.reSendMessneger(params, sqlSession);
	}
	
	//메세지 삭제
	@Override
	public int deleteMessenger(Map<String, Object> params) {
		return md.deleteMessenger(params, sqlSession);
	}
	
	//임시저장 메세지 수정
	@Override
	public int updateMessenger(Map<String, Object> params) {
		return md.updateMessenger(params, sqlSession);
	}
	
	//임시저장 조회
	@Override
	public ArrayList<HashMap<String, Object>> getStoDetail(Map<String, Object> params) {
		return md.getStoDetail(params, sqlSession);
	}



	


}
