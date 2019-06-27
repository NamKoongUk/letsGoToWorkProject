package com.kh.lgtw.mail.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.mail.model.exception.StatusTypeException;
import com.kh.lgtw.mail.model.vo.Absence;
import com.kh.lgtw.mail.model.vo.ListCondition;
import com.kh.lgtw.mail.model.vo.Mail;

public interface MailService{

	int getMailListCount();

	ArrayList<Mail> selectMailList(PageInfo pi);

	int updateMailStatus(Map<String, Object> map) throws StatusTypeException;

	Mail selectMailDetail(int mailNo);

	int insertAbsenceMail(Absence absence);

	ArrayList<Absence> selectAbcenceList(int empNo);

	int sendMail(Mail mail);

	ArrayList<Mail> selectSearchMailList(PageInfo pi, ListCondition lc);

}
