package com.kh.lgtw.mail.aws;

import org.springframework.beans.factory.annotation.Autowired;

import com.kh.lgtw.mail.controller.SendMail;

// 메일 전송 서비스 
public class MailSendingService {
 
	private SendMail sendMail;

	@Autowired 
	public MailSendingService(SendMail sendMail) {
		this.sendMail = sendMail;
	}
	
	public void sendMailMessage() {
		
	}
	
	
	  
	 
}
