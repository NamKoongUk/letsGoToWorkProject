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
		
		int offset = (pi.getCurrentPage() - 1)  * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList) session.selectList("Mail.selectMailList", pi, rowBounds);
	}

	// 메일 상태 변경
	@Override
	public int updateMailStatus(SqlSession session, Map<String, Object> map) throws StatusTypeException {
		int result = 0;
		
		
		ArrayList<Integer> arrayNum = (ArrayList) map.get("checkList");
		String type = (String) map.get("type");
		System.out.println("dao array : " + arrayNum);
		System.out.println("dao type : " + type);
		
		if(type.equals("read")) {
			for(int i = 0; i < arrayNum.size(); i++) {
				result += (int) session.update("Mail.updateReadStatus", arrayNum.get(i));
			}
		}else if(type.equals("delete")) {
			for(int i = 0; i < arrayNum.size(); i++) {
				result += session.update("Mail.updateDeleteStatus", arrayNum.get(i));
			}
		}else {
			throw new StatusTypeException("상태 유형이 올바르지 않습니다.");
		}
		
		System.out.println("type : " + type + " arrayLength : " + arrayNum.size() + " result : " + result);
		return result;
	}

}
