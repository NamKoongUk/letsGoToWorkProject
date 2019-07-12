package com.kh.lgtw.mail.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.common.SqlQuery;
import com.kh.lgtw.mail.model.exception.StatusTypeException;
import com.kh.lgtw.mail.model.vo.Absence;
import com.kh.lgtw.mail.model.vo.ListCondition;
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
				result += (int) session.update("Mail.updateDeleteStatus", arrayNum.get(i));
			}
		}else {
			throw new StatusTypeException("상태 유형이 올바르지 않습니다.");
		}
		
		if(result != arrayNum.size()) {
			throw new StatusTypeException("입력된 값이 모두 수정되지 않았습니다.");
		}
		
		System.out.println("type : " + type + " arrayLength : " + arrayNum.size() + " result : " + result);
		return result;
	}

	// 메일 상세페이지 조회
	@Override
	public Mail selectMailDetail(SqlSession sqlSession, int mailNo) {
		Mail m = sqlSession.selectOne("Mail.selectMailDetail", mailNo);
		int result = sqlSession.update("Mail.updateReadStatus", mailNo);
		
		System.out.println(" m : " + m);
		System.out.println("result : " + result);
		
		return m;
	}

	// 메일 부재중 추가 
	@Override
	public int insertAbsenceMail(SqlSession sqlSession, Absence absence) {
		return sqlSession.insert("Mail.insertAbsenceMail", absence);
	}

	// 메일 부재중 리스트 조회
	@Override
	public ArrayList<Absence> selectAbsenceList(SqlSession sqlSession, int empNo) {
		return (ArrayList) sqlSession.selectList("Mail.selectAbsenceList", empNo);
	}

	// 메일 보내기
	@Override
	public int sendMail(SqlSession sqlSession, Mail mail) {
		return sqlSession.insert("Mail.sendMail", mail);
	}

	// 검색 메일 조회
	@Override
	public ArrayList<Mail> selectSearchMailList(SqlSession sqlSession, PageInfo pi, HashMap<String, Object> listCondition) {
		int offset = (pi.getCurrentPage() - 1)  * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		SqlQuery.getSqlQuery(sqlSession, "Mail.searchList", listCondition);
		
		return (ArrayList)sqlSession.selectList("Mail.searchList", listCondition, rowBounds);
	}

	// 검색 페이징을 위한 리스트 갯수 조회 
	@Override
	public int getMailSearchListCount(SqlSession sqlSession, HashMap<String, Object> listCondition) {
		return sqlSession.selectOne("Mail.getMailSearchListCount");
	}

	// s3에서 받아온 정보를 데이터베이스에 insert
	@Override
	public int insertReciveMail(SqlSession sqlSession, Mail reciveMail) {
		System.out.println("Message : " + reciveMail);
		return sqlSession.insert("Mail.insertReciveMail", reciveMail);
	}

	// 보낸 사원의 이름을 조회
	@Override
	public HashMap<String, Object> selectSendEmpName(SqlSession sqlSession, String sendMail) {
		return sqlSession.selectOne("Mail.selectSendEmpName", sendMail);
	}

	// 받는 사원의 이름을 조회
	@Override
	public HashMap<String, Object> selectReciveEmpName(SqlSession sqlSession, String reciveMail) {
		return sqlSession.selectOne("Mail.selectReciveEmpName", reciveMail);
	}

	

}
