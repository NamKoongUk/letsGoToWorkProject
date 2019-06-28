package com.kh.lgtw.mail.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.mail.model.dao.MailDao;
import com.kh.lgtw.mail.model.exception.StatusTypeException;
import com.kh.lgtw.mail.model.vo.Absence;
import com.kh.lgtw.mail.model.vo.ListCondition;
import com.kh.lgtw.mail.model.vo.Mail;

@Service
public class MailServiceImpl implements MailService{

	@Autowired private MailDao md;
	@Autowired private SqlSession sqlSession;
	
	// 전체 이메일 갯수 조회
	@Override
	public int getMailListCount() {
		return md.getMailListCount(sqlSession);
	}

	// 페이징 처리한 전체 이메일 리스트 조회
	@Override
	public ArrayList<Mail> selectMailList(PageInfo pi) {
		return md.selectMailList(sqlSession, pi);
	}

	// 메일 상태 변경
	@Override
	public int updateMailStatus(Map<String, Object> map) throws StatusTypeException {
		return md.updateMailStatus(sqlSession, map);
	}

	// 메일 상세 페이지 조회
	@Override
	public Mail selectMailDetail(int mailNo) {
		return md.selectMailDetail(sqlSession, mailNo);
	}

	// 부재중 설정 추가
	@Override
	public int insertAbsenceMail(Absence absence) {
		return md.insertAbsenceMail(sqlSession, absence);
	}

	// 부재중 리스트 조회
	@Override
	public ArrayList<Absence> selectAbcenceList(int empNo) {
		return md.selectAbsenceList(sqlSession, empNo);
	}

	// 메일 보내기
	@Override
	public int sendMail(Mail mail) {
		return md.sendMail(sqlSession, mail);
	}

	// 검색 메일 조회 - HashMap으로 
	@Override
	public ArrayList<Mail> selectSearchMailList(PageInfo pi, HashMap<String, Object> listCondition) {
		return md.selectSearchMailList(sqlSession, pi, listCondition);
	}

	// 검색 페이징을 위한 조건 리스트 갯수 조회
	@Override
	public int getMailSearchListCount(HashMap<String, Object> listCondition) {
		return md.getMailSearchListCount(sqlSession, listCondition);
	}

}
