package com.kh.lgtw.mail.controller;

import org.springframework.mail.SimpleMailMessage;

public class SendMailMessage {

	public SendMailMessage() {}
	
	public void sendMailMessage() {
		simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(sender.getFrom());
		simpleMailMessage.setTo(sender.getTo().get(0));
		simpleMailMessage.setSubject(sender.getSubject());
		simpleMailMessage.setText(sender.getContent());
		System.out.println("simpleMailMessage : " + simpleMailMessage);
		System.out.println("mailSender 너는 왜 널이니.. " + mailSender);
		mailSender.send(simpleMailMessage);
	}
}
