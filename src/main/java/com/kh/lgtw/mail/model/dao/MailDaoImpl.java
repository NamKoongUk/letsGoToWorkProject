package com.kh.lgtw.mail.model.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.mail.model.exception.StatusTypeException;
import com.kh.lgtw.mail.model.vo.Mail;

@Repository
public class MailDaoImpl implements MailDao{

	// 전체 이메일 갯수 조회
	@Override
	public int getMailListCount(SqlSession session) {
		return session.selectOne("Mail.getMailListCount");
	}

	// 페이징 처리한 전체 이메일 갯수 조회
	@Override
	public ArrayList<Mail> selectMailList(SqlSession session, PageInfo pi) {
		
		// 시작번호
		int offset = (pi.getCurrentPage() - 1)  * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList) session.selectList("Mail.selectMailList", pi, rowBounds);
	}

	// 메일 상태 변경
	@Override
	public int updateMailStatus(SqlSession session, Map<String, Object> map) throws StatusTypeException {
		
		int[] arrayNum = (int[]) map.get("checkList");
		String type = (String) map.get("type");
		System.out.println("dao array : " + arrayNum);
		System.out.println("dao type : " + type);
		
		switch(type) {
		case "read": break;
		case "delete" : break;
			default : throw new StatusTypeException("상태 유형이 올바르지 않습니다.");
		}
		
		for(int i = 0; i < arrayNum.length; i++) {
			
		}
		
		return 0;
	}

}
