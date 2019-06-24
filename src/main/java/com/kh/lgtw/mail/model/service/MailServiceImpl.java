package com.kh.lgtw.mail.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.mail.model.dao.MailDao;
import com.kh.lgtw.mail.model.exception.StatusTypeException;
import com.kh.lgtw.mail.model.vo.Mail;

@Service
public class MailServiceImpl implements MailService{

	@Autowired private MailDao md;
	@Autowired private SqlSession session;
	
	
	// 전체 이메일 갯수 조회
	@Override
	public int getMailListCount() {
		return md.getMailListCount(session);
	}

	// 페이징 처리한 전체 이메일 리스트 조회
	@Override
	public ArrayList<Mail> selectMailList(PageInfo pi) {
		return md.selectMailList(session, pi);
	}

	// 메일 상태 변경
	@Override
	public int updateMailStatus(Map<String, Object> map) throws StatusTypeException {
		return md.updateMailStatus(session, map);
	}

}
