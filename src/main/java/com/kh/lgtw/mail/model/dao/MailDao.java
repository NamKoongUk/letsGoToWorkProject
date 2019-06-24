package com.kh.lgtw.mail.model.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.mail.model.exception.StatusTypeException;
import com.kh.lgtw.mail.model.vo.Mail;

public interface MailDao {

	int getMailListCount(SqlSession session);

	ArrayList<Mail> selectMailList(SqlSession session, PageInfo pi);

	int updateMailStatus(SqlSession session, Map<String, Object> map) throws StatusTypeException;

}
