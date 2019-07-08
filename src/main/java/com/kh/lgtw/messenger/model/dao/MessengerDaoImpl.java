package com.kh.lgtw.messenger.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.lgtw.approval.model.vo.PageInfo;

@Repository
public class MessengerDaoImpl implements MessengerDao {

	@Override
	public int sendMessenger(Map<String, Object> params, SqlSession sqlSession) {
		int result = 0;
		
		ArrayList<Integer> list = (ArrayList<Integer>) params.get("sendEmp");
		for(int i=0; i<list.size(); i++) {
			if(i==0) {
				sqlSession.selectOne("Messenger.msgNoSeq");
			}
			params.put("sendEmp",list.get(i));
			result += sqlSession.insert("Messenger.sendMessenger", params);
		}
		System.out.println(result);
		return 0;
	}
	
	//메세지 조회용 메소드
	@Override
	public ArrayList<HashMap<String, Object>> selectMessenger(Map<String, Object> params, SqlSession sqlSession) {
		
		PageInfo pi = (PageInfo) params.get("pi");
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)sqlSession.selectList("Messenger.selctMessengerList", params,rowBounds);
	}
	
	//메세지 디테일 조회용 메소드
	@Override
	public HashMap<String, Object> selectDetailMessneger(Map<String, Object> params, SqlSession sqlSession) {
		return sqlSession.selectOne("Messenger.selectMessengerDetail", params);
	}
	
	
	@Override
	public int selectMessengerCount(Map<String, Object> params, SqlSession sqlSession) {
		return sqlSession.selectOne("Messenger.selectMessengerCount",params);
	}

	@Override
	public String deleteMessenger(String msgNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectStorageMessenger(String msgGno) {
		// TODO Auto-generated method stub
		return null;
	}




	

	

}
